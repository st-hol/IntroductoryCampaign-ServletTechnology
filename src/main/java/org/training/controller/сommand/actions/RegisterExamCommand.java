package org.training.controller.сommand.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.model.entity.ExamRegistration;
import org.training.model.entity.Student;
import org.training.model.service.ExamRegistrationService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterExamCommand implements Command {

    private static final Logger logger = LogManager.getLogger(RegisterExamCommand.class);

    private ExamRegistrationService examRegistrationService;
    private StudentService studentService;

    public RegisterExamCommand(ExamRegistrationService examRegistrationService, StudentService studentService) {
        this.examRegistrationService = examRegistrationService;
        this.studentService = studentService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final Student currentSessionStudent = studentService.getCurrentSessionStudent(request);

        final long currentStudentId = currentSessionStudent.getId();
        final long examId = Long.parseLong(request.getParameter("examId"));

        ExamRegistration examRegistration = new ExamRegistration();
        examRegistration.setIdStudent(currentStudentId);
        examRegistration.setIdSubject(examId);
        examRegistrationService.registerForExam(examRegistration);

        logger.info("Student " + currentSessionStudent.getFirstName() + " " + currentSessionStudent.getLastName()
                + "registered for exam id" + examId);

        return "/WEB-INF/user/regforexam.jsp";
    }

//catch
    //fixme  Duplicate entry '1-3' for key 'PRIMARY'
}
