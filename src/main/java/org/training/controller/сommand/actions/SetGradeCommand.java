package org.training.controller.сommand.actions;

import org.training.controller.сommand.Command;
import org.training.model.entity.ExamRegistration;
import org.training.model.service.ExamRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetGradeCommand implements Command {

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
//            return "redirect@login.jsp?dataInvalid=true";
//        }

        ExamRegistration examRegistration = new ExamRegistration();
        examRegistration.setIdStudent(Long.parseLong(idStudent));
        examRegistration.setIdSubject(Long.parseLong(idSubject));
        examRegistration.setExamScore(Double.parseDouble(examScore));


        System.out.println(examRegistration.toString());

        examRegistrationService.setGrade(examRegistration);


//
//        сommand personalCabinet = new PersonalCabinetCommand();
//        return personalCabinet.execute(request, response);
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
