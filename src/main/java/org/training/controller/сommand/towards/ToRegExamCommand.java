package org.training.controller.сommand.towards;

import org.training.controller.сommand.Command;
import org.training.model.entity.Exam;
import org.training.model.service.ExamService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToRegExamCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ExamService examService = new ExamService();
        List<Exam> exams = examService.getAllExams();
        request.setAttribute("exams", exams);

        return "/WEB-INF/user/regforexam.jsp";
    }
}
