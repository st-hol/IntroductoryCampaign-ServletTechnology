package org.training.controller.сommand.directions;

import org.training.controller.сommand.Command;
import org.training.model.entity.Exam;
import org.training.model.entity.Student;
import org.training.model.service.ExamService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RegExamCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final HttpSession session = request.getSession();
        final Student.ROLE role = (Student.ROLE) session.getAttribute("role");

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


        ExamService examService = new ExamService();
        List<Exam> exams = examService.getAllExams();
        request.setAttribute("exams", exams);

        return "/WEB-INF/user/regforexam.jsp";
    }
}
