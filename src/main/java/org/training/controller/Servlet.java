package org.training.controller;

import org.training.controller.сommand.*;
import org.training.controller.сommand.account.RegistrationCommand;
import org.training.controller.сommand.directions.HomeCommand;
import org.training.controller.сommand.account.LoginCommand;
import org.training.controller.сommand.account.LogoutCommand;
import org.training.controller.сommand.account.PersonalCabinetCommand;
import org.training.controller.сommand.actions.*;
import org.training.controller.сommand.directions.*;
import org.training.model.service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//directory "c"omand starts from cyrillic "c"... refactor it

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();


    public void init(ServletConfig servletConfig){

        commands.put("registration",
                new RegistrationCommand(new StudentService()));
        commands.put("login",
                new LoginCommand(new StudentService()));
        commands.put("logout",
                new LogoutCommand());
        commands.put("personal-cabinet",
                new PersonalCabinetCommand());


//        commands.put("show-all-exams",
//                new ShowExamsCommand(new ExamService()));
        commands.put("registrate-for-exam",
                new RegisterExamCommand(new ExamRegistrationService(), new StudentService()));
        commands.put("set-grade",
                new SetGradeCommand(new ExamRegistrationService()));

        commands.put("apply-for-admission",
                new ApplyAdmissionCommand(new SpecialityService(), new StudentService(), new ApplicationService()));
        commands.put("list-of-enrolled",
                new ShowEnrolledCommand());

        commands.put("home",
                new HomeCommand());
        commands.put("apply-admission",
                new ApplyingCommand());
        commands.put("put-marks",
                new SettingGradeCommand());
        commands.put("reg-exam",
                new RegExamCommand());
        commands.put("reg-me",
                new RegMeCommand());
        commands.put("log-me",
                new LogMeCommand());
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        path = path.replaceAll(".*/introductory-campaign/" , "");

        Command command = commands.getOrDefault(path , (req, resp)->"/welcome.jsp");
        String page = command.execute(request, response);

        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect@", ""));
        } else {
            request.getRequestDispatcher(page).forward(request,response);
        }
    }
}









//todo disable autocommit and make double transaction / for example for update two tables
//todo pagination
//todo many-to-many
