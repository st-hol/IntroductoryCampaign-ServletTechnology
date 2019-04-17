package org.training.controller.сommand.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.model.entity.ExamRegistration;
import org.training.model.service.ExamRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetGradeCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SetGradeCommand.class);

    private ExamRegistrationService examRegistrationService;

    public SetGradeCommand(ExamRegistrationService examRegistrationService) {
        this.examRegistrationService = examRegistrationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        final String idStudent = request.getParameter("idStudent");
        final String idSubject = request.getParameter("idSubject");
        final String examScore = request.getParameter("examScore");


//        if ( ! (NumberValidator.validateNumber(examScore))) {
//           //forward
//            return "redirect@login.jsp?dataInvalid=true";
//        }

        ExamRegistration examRegistration = new ExamRegistration();
        examRegistration.setIdStudent(Long.parseLong(idStudent));
        examRegistration.setIdSubject(Long.parseLong(idSubject));
        examRegistration.setExamScore(Double.parseDouble(examScore));


        System.out.println(examRegistration.toString());

        logger.info("Student id#" + idStudent + " got exam score " + examScore
                + " for exam id#" + idSubject);
        examRegistrationService.setGrade(examRegistration);

        return "/WEB-INF/admin/adminbasis.jsp";
    }
}





//
//        сommand personalCabinet = new PersonalCabinetCommand();
//        return personalCabinet.execute(request, response);