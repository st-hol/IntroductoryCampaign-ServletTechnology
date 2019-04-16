package org.training.controller.сommand.towards;

import org.training.controller.сommand.Command;
import org.training.model.entity.Exam;
import org.training.model.entity.Student;
import org.training.model.service.ExamService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToPutMarksCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getAllUsers();
        request.setAttribute("students", students);

        ExamService examService = new ExamService();
        List<Exam> exams = examService.getAllExams();
        request.setAttribute("exams", exams);

        return "/WEB-INF/admin/putmarks.jsp";
    }
}
