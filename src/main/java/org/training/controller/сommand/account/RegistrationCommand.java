package org.training.controller.сommand.account;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.model.entity.Student;
import org.training.model.exception.AlreadyExistingDBRecordException;
import org.training.model.service.StudentService;
import org.training.model.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);

    private StudentService studentService;

    public RegistrationCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        final String email = request.getParameter("email");
        final String role = request.getParameter("role");
        final String password = request.getParameter("password");
        final String firstName = request.getParameter("firstName");
        final String lastName = request.getParameter("lastName");

        if ( ! (UserValidator.validateEmail(email) && UserValidator.validatePassword(password))) {
            logger.info("User [" + email + "]" + "entered wrong data.");
            return "/jsp/registration.jsp?dataInvalid=true";
        }

        final Student student = new Student();
        student.setRole(Student.ROLE.valueOf(role));
        student.setPassword(password);
        student.setEmail(email);
        student.setFirstName(firstName);
        student.setLastName(lastName);

        try {
            studentService.registerStudentInDB(student);
        } catch (AlreadyExistingDBRecordException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return "/jsp/registration.jsp?success=false";
        }

        logger.info("User [" + email + "]" + " role[" + role + "]" +" successfully registered.");
        return "/jsp/registration.jsp?success=true";
    }
}















//            return "redirect@" + path + "/jsp/registration.jsp?dataInvalid=true";
//return "redirect@" + path + "/jsp/registration.jsp?success=true";