package org.training.controller.сommand.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.entity.Exam;
import org.training.model.entity.ExamRegistration;
import org.training.model.entity.Student;
import org.training.model.service.ExamRegistrationService;
import org.training.model.service.ExamService;
import org.training.model.service.StudentService;
import org.training.model.validator.NumberValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * This class is responsible for rating
 * students for concrete exam
 * from admin-role personal cabinet.
 *
 * @author Stanislav Holovachuk
 */
public class SetGradeCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SetGradeCommand.class);

    private ExamRegistrationService examRegistrationService;

    public SetGradeCommand(ExamRegistrationService examRegistrationService) {
        this.examRegistrationService = examRegistrationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CommandUtility.defineStudentsAttribute(request);
        CommandUtility.defineExamsAttribute(request);

        final String idStudent = request.getParameter("idStudent");
        final String idSubject = request.getParameter("idSubject");
        final String examScore = request.getParameter("examScore");

        if ( ! (NumberValidator.validateExamScore(examScore))) {
            return "/WEB-INF/admin/putmarks.jsp?dataInvalid=true";
        }

        ExamRegistration examRegistration = new ExamRegistration();
        examRegistration.setIdStudent(Long.parseLong(idStudent));
        examRegistration.setIdSubject(Long.parseLong(idSubject));
        examRegistration.setExamScore(Double.parseDouble(examScore));
        examRegistrationService.setGrade(examRegistration);

        logger.info("Student id#" + idStudent + " got exam score " + examScore
                + " for exam id#" + idSubject);

        return "/WEB-INF/admin/putmarks.jsp";
    }
}


//
//        сommand personalCabinet = new PersonalCabinetCommand();
//        return personalCabinet.execute(request, response);