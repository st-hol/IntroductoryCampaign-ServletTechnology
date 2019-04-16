package org.training.controller.сommand.actions;

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

public class ApplyForAdmissionCommand implements Command {

    private SpecialityService specialityService;
    private StudentService studentService;
    private ApplicationService applicationService;


    public ApplyForAdmissionCommand(SpecialityService specialityService, StudentService studentService, ApplicationService applicationService) {
        this.specialityService = specialityService;
        this.studentService = studentService;
        this.applicationService = applicationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Student currentSessionStudent = studentService.getCurrentSessionStudent(request);

        final long currentStudentId = currentSessionStudent.getId();

        if (currentSessionStudent.getRating() != 0) {

            //todo here can be trash/null user input
            long specialityId = Long.parseLong(request.getParameter("idSpeciality"));

            ApplicationForAdmission applicationForAdmission = new ApplicationForAdmission();
            //StudentNotificator studentNotificator = new StudentNotificator(applicationService);

            applicationForAdmission.setStudent(
                    studentService.getStudentById(currentStudentId));
            applicationForAdmission.setSpeciality(
                    specialityService.getSpecialityById(specialityId));

            applicationService.applyForAdmission(applicationForAdmission);
            studentService.notifyStudentByEmail(applicationForAdmission);
        }
        else {
            System.out.println("You did not pass all the exams! Pass all three exams, then you can apply for admission.");
        }


        return "/WEB-INF/user/applyforadmission.jsp";
    }

}
