package org.training.model.service;


import org.training.model.dao.DaoFactory;
import org.training.model.dao.StudentDao;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import org.training.model.mail.MailTemplatePath;
import org.training.model.mail.notificators.StudentNotificator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    final private static int IS_ENROLLED = 1;

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public StudentDao getDaoFactory() {
        return daoFactory.createStudentDao();
    }

    public void registerStudentInDB(Student student) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {
            studentDao.create(student);
        }
    }

    public Student getCurrentSessionStudent(HttpServletRequest request){

        final HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        System.out.println( (String) session.getAttribute("email"));
        System.out.println(  session.getAttribute("email").toString());

        return getStudentByEmail(email);
    }

    private Student getStudentByEmail(String email) {

        List<Student> students = getAllUsers();

        return students.stream()
                .filter(student -> email.equals(student.getEmail()))
                .findAny()
                .orElse(null);

    }

//        //todo streamApi
//        for (Student student: students) {
//            if (student.getEmail().equals(email)){
//                return student;
//            }
//        }
//        //todo optional
//        return null;
//    }


    public Student getStudentById(long id){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findById(id);
        }
    }


    public List<Student> getAllUsers() {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }

    public List<Student> getAllEnrolledStudents(List<ApplicationForAdmission> applications) {

        List<Student> students = new ArrayList<>();

        for (ApplicationForAdmission application: applications){
            students.add(application.getStudent());
        }
        return students.stream().sorted(Comparator.comparing(Student::getRating).reversed()).collect(Collectors.toList());
    }

    public void notifyStudentByEmail(ApplicationForAdmission applicationForAdmission) {

        ApplicationService applicationService = new ApplicationService();

        //get current
        applicationForAdmission = applicationService.
                getApplicationByStudentId(applicationForAdmission.getStudent().getId());

        StudentNotificator studentNotificator = new StudentNotificator();

        final String emailValue = applicationForAdmission.getStudent().getEmail();

        final String fullName = applicationForAdmission.getStudent().getFirstName()
                + applicationForAdmission.getStudent().getLastName();

        if (applicationForAdmission.getIsEnrolled() == IS_ENROLLED){
            studentNotificator.sendEmail(emailValue, fullName, MailTemplatePath.ADMISSION_NOTICE);
        } else {
            studentNotificator.sendEmail(emailValue, fullName, MailTemplatePath.REJECTION_NOTICE);
        }
    }
}











//    public Optional<Student> login(String email) {
//        Optional<Student> result;
//
//        try (StudentDao studentDao = daoFactory.createStudentDao()) {
//            result = studentDao.findByEmail(email);
//        }
//
//        return result;
//    }