package org.training.controller.сommand.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import org.training.model.service.ApplicationService;
import org.training.model.service.SpecialityService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplyAdmissionCommand implements Command {

    private static final Logger logger = LogManager.getLogger(ApplyAdmissionCommand.class);


    private SpecialityService specialityService;
    private StudentService studentService;
    private ApplicationService applicationService;


    public ApplyAdmissionCommand(SpecialityService specialityService, StudentService studentService, ApplicationService applicationService) {
        this.specialityService = specialityService;
        this.studentService = studentService;
        this.applicationService = applicationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final Student currentSessionStudent = studentService.getCurrentSessionStudent(request);

        final long currentStudentId = currentSessionStudent.getId();
        final long specialityId = Long.parseLong(request.getParameter("idSpeciality"));

        ApplicationForAdmission applicationForAdmission = new ApplicationForAdmission();
        //StudentNotificator studentNotificator = new StudentNotificator(applicationService);

        applicationForAdmission.setStudent(
                studentService.getStudentById(currentStudentId));
        applicationForAdmission.setSpeciality(
                specialityService.getSpecialityById(specialityId));

        logger.info("Student " + currentSessionStudent.getFirstName() + " " + currentSessionStudent.getLastName()
                + "applied for admission.");

        applicationService.applyForAdmission(applicationForAdmission);
        studentService.notifyStudentByEmail(applicationForAdmission);


        return "/WEB-INF/user/applyforadmission.jsp";
    }

}
