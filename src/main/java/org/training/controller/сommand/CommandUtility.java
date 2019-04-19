package org.training.controller.сommand;

import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Exam;
import org.training.model.entity.Speciality;
import org.training.model.entity.Student;
import org.training.model.service.ApplicationService;
import org.training.model.service.ExamService;
import org.training.model.service.SpecialityService;
import org.training.model.service.StudentService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class CommandUtility {

    public static boolean checkUserIsLogged(HttpServletRequest request, String email, String password){

        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession()
                .getServletContext()
                .getAttribute("loggedUsers");


        if(loggedUsers.stream().anyMatch(email::equals)) {
            return true;
        }

        loggedUsers.add(email);
        request.getSession()
                .getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }



    public static void unlogUser(HttpServletRequest request, String email) {

        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>)
                request.getSession().getServletContext().getAttribute("loggedUsers");

        loggedUsers.remove(email);

        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);

        final HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("password");
        session.removeAttribute("role");
    }


    //to prevent user coming back to cached pages after logout
    public static void disallowBackToCached(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final HttpSession session = request.getSession();
        final String path = request.getServletContext().getContextPath();

        //to prevent user coming back to cached pages after logout
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", 0);
        if (session.getAttribute("email") == null || session.getAttribute("password") == null
                || session.getAttribute("role") == null) {
            response.sendRedirect(path +  "/jsp/error/invalidSession.jsp");
            //return  "redirect@" + path + "/jsp/error/invalidSession.jsp";
        }
    }


    public static void defineStudentsAttribute(HttpServletRequest request) {
        final StudentService studentService = new StudentService();
        List<Student> students = studentService.getAllUsers();
        request.setAttribute("students", students);
    }

    public static void defineExamsAttribute(HttpServletRequest request) {
        final ExamService examService = new ExamService();
        List<Exam> exams = examService.getAllExams();
        request.setAttribute("exams", exams);
    }

    public static void defineSpecialitiesAttribute(HttpServletRequest request) {
        final SpecialityService specialityService = new SpecialityService();
        List<Speciality> specialities = specialityService.getAllSpecialities();
        request.setAttribute("specialities", specialities);
    }

    public static void defineEnrolled(HttpServletRequest request){
        final ApplicationService applicationService = new ApplicationService();
        final StudentService studentService = new StudentService();
        List<ApplicationForAdmission> applications = applicationService.getAllConfirmedApplications();
        List<Student> enrolledStudents = studentService.getAllEnrolledStudents(applications);
        request.setAttribute("enrolledStudents", enrolledStudents );
    }



}
