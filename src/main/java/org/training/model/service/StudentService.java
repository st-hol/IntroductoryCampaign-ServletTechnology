package org.training.model.service;


import org.training.model.dao.DaoFactory;
import org.training.model.dao.StudentDao;
import org.training.model.dao.impl.JDBCStudentDao;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import org.training.model.exception.AlreadyExistingDBRecordException;
import org.training.model.mail.MailTemplatePath;
import org.training.model.mail.notificators.StudentNotificator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;



/**
 * This class realize logic
 * for manipulation with db.
 *
 * @author Stanislav Holovachuk
 */
public class StudentService {

    final private static int IS_ENROLLED = 1;

    private DaoFactory daoFactory = DaoFactory.getInstance();


    /**
     * Registers student's account if such not exist yet.
     *
     * @param student Student.
     */
    public void registerStudentInDB(Student student) throws AlreadyExistingDBRecordException {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            if ( studentDao.emailAlreadyTaken(student.getEmail()) ){
                throw new AlreadyExistingDBRecordException("Failed registering already existing user email "+
                        student.getEmail());
            }

            studentDao.create(student);
        }
    }


    /**
     * obtains student by email.
     *
     * @param email String.
     */
    public Student getStudentByEmail(String email) {

        List<Student> students = getAllUsers();

        return students.stream()
                .filter(student -> email.equals(student.getEmail()))
                .findAny()
                .orElse(null);

    }

    /**
     * checks if such user exist in db.
     * @param email String.
     */
    public boolean isExistingUser(String email, String password){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.userIsExist(email, password);
        }
    }


    /**
     * obtain role by email and password.
     * @param email String.
     * @param password String.
     */
    public Student.ROLE getRoleByEmailAndPass(String email, String password){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.getRoleByEmailPassword(email, password);
        }
    }


    /**
     * obtains student by id.
     *
     * @param id long.
     */
    public Student getStudentById(long id){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findById(id);
        }
    }

    /**
     * obtains List of all students.
     */
    public List<Student> getAllUsers() {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }


    /**
     * obtains List of certain quantity of enrolled students.
     */
    public JDBCStudentDao.PaginationResult getAllEnrolledStudentsByPagination(int lowerBound, int upperBound) {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findByPagination(lowerBound, upperBound);
        }
    }


    /**
     * sends e-mail notification to student:
     * rejection or admission notice.
     */
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










//    public List<Student> getAllEnrolledStudents(List<ApplicationForAdmission> applications) {
//
//        List<Student> students = new ArrayList<>();
//
//        for (ApplicationForAdmission application: applications){
//            students.add(application.getStudent());
//        }
//        return students.stream().sorted(Comparator.comparing(Student::getRating).reversed()).collect(Collectors.toList());
//    }











//    public Optional<Student> login(String email) {
//        Optional<Student> result;
//
//        try (StudentDao studentDao = daoFactory.createStudentDao()) {
//            result = studentDao.findByEmail(email);
//        }
//
//        return result;
//    }