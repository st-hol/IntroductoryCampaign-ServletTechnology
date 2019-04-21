package org.training.controller.сommand.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.entity.ExamRegistration;
import org.training.model.entity.Student;
import org.training.model.exception.AlreadyExistingDBRecordException;
import org.training.model.service.ExamRegistrationService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * This class is responsible for registering
 * exam from user-role personal cabinet.
 *
 * @author Stanislav Holovachuk
 */
public class RegisterExamCommand implements Command {

    private static final Logger logger = LogManager.getLogger(RegisterExamCommand.class);

    private ExamRegistrationService examRegistrationService;

    public RegisterExamCommand(ExamRegistrationService examRegistrationService) {
        this.examRegistrationService = examRegistrationService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CommandUtility.defineExamsAttribute(request);

        final Student currentSessionStudent = CommandUtility.getCurrentSessionStudent(request);

        final long currentStudentId = currentSessionStudent.getId();
        final long examId = Long.parseLong(request.getParameter("examId"));

        ExamRegistration examRegistration = new ExamRegistration();
        examRegistration.setIdStudent(currentStudentId);
        examRegistration.setIdSubject(examId);

        try {
            examRegistrationService.registerForExam(examRegistration);
        } catch (AlreadyExistingDBRecordException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return "/WEB-INF/user/regforexam.jsp?alreadyExist=true";
        }

        logger.info("Student " + currentSessionStudent.getFirstName() + " " + currentSessionStudent.getLastName()
                + "registered for exam id" + examId);

        return "/WEB-INF/user/regforexam.jsp";
    }

}
