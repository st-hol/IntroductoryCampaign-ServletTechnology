package org.training.controller.сommand.actions;

import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        //to prevent user coming back to cached pages after logout
        CommandUtility.disallowBackToCached(request, response);

        CommandUtility.defineEnrolled(request);

        //todo make it pretty
        final String role = request.getSession().getAttribute("role").toString().toLowerCase();
        return "/WEB-INF/" + role + "/enrolledlist.jsp";
    }
}







//     return "/WEB-INF/common/enrolledlist.jsp";

//        System.out.println("students::");
//        for (Student student: enrolledStudents ) {
//            System.out.println(student.toString());
//        }