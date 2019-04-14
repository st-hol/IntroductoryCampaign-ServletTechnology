package org.training.controller.Command;

import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import org.training.model.mail.MailBuilder;
import org.training.model.mail.MailProperty;
import org.training.model.mail.MailTemplatePath;
import org.training.model.mail.MailThread;
import org.training.model.service.ApplicationService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListOfEnrolledCommand implements Command {

    private StudentService studentService = new StudentService();
    private ApplicationService applicationService = new ApplicationService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        List<ApplicationForAdmission> applications = applicationService.getAllConfirmedApplications();

        List<Student> students = studentService.getAllEnrolledStudents(applications);

        System.out.println("students::");
        for (Student student: students ) {
            System.out.println(student.toString());
        }


        return "/index.jsp";
    }

}


