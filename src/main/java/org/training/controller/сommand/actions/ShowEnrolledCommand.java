package org.training.controller.сommand.actions;

import org.training.controller.сommand.Command;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import org.training.model.service.ApplicationService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowEnrolledCommand implements Command {

    private StudentService studentService = new StudentService();
    private ApplicationService applicationService = new ApplicationService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
        final HttpSession session = request.getSession();

        final String path = request.getServletContext().getContextPath();


        //to prevent user coming back to cached pages after logout
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", 0);
        if (session.getAttribute("email") == null || session.getAttribute("password") == null
                || session.getAttribute("role") == null) {
            return  "redirect@" + path + "/jsp/error/invalidSession.jsp";
        }

        List<ApplicationForAdmission> applications = applicationService.getAllConfirmedApplications();
        List<Student> enrolledStudents = studentService.getAllEnrolledStudents(applications);
        request.setAttribute("enrolledStudents", enrolledStudents );

        //todo make it pretty
        String role = request.getSession().getAttribute("role").toString().toLowerCase();
        return "/WEB-INF/"+ role +"/enrolledlist.jsp";
    }
}







//     return "/WEB-INF/common/enrolledlist.jsp";

//        System.out.println("students::");
//        for (Student student: enrolledStudents ) {
//            System.out.println(student.toString());
//        }