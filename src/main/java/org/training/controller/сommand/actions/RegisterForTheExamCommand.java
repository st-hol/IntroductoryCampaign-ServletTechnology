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

public class RegisterForTheExamCommand implements Command {

    private static final Logger logger = LogManager.getLogger(RegisterForTheExamCommand.class);

    private ExamRegistrationService examRegistrationService;
    private StudentService studentService;

    public RegisterForTheExamCommand(ExamRegistrationService examRegistrationService, StudentService studentService) {
        this.examRegistrationService = examRegistrationService;
        this.studentService = studentService;
    }


    //todo getparam ?id=
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Student currentSessionStudent = studentService.getCurrentSessionStudent(request);

        final long currentStudentId = currentSessionStudent.getId();

        //todo isNotDigit
        long examId = Long.parseLong(request.getParameter("examId"));

        //System.out.println("curID:" + currentSessionStudent + "        examID" + examId);
        ExamRegistration examRegistration = new ExamRegistration();
        examRegistration.setIdStudent(currentStudentId);
        examRegistration.setIdSubject(examId);
        examRegistrationService.registerForExam(examRegistration);

        logger.info("Student " + currentSessionStudent.getFirstName() + " " + currentSessionStudent.getLastName()
                + "registered for exam id" + examId);

        return "/WEB-INF/user/userbasis.jsp";
    }


    //fixme  Duplicate entry '1-3' for key 'PRIMARY'
}
