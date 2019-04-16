package org.training.controller;

import org.training.controller.сommand.*;
import org.training.controller.сommand.towards.ToHomeCommand;
import org.training.controller.сommand.account.LoginCommand;
import org.training.controller.сommand.account.LogoutCommand;
import org.training.controller.сommand.account.PersonalCabinetCommand;
import org.training.controller.сommand.actions.*;
import org.training.controller.сommand.towards.*;
import org.training.model.service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//fixme there was a bug. when putting a mark. server hung

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();



    public void init(ServletConfig servletConfig){

//        servletConfig.getServletContext()
//                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("registration",
                new RegistrationCommand(new StudentService()));
        commands.put("login",
                new LoginCommand(new StudentService()));
        commands.put("logout",
                new LogoutCommand());
        commands.put("home",
                new ToHomeCommand());
        commands.put("show-all-exams",
                new ShowExamsCommand(new ExamService()));
        commands.put("registrate-for-exam",
                new RegisterForTheExamCommand(new ExamRegistrationService(), new StudentService()));
        commands.put("set-grade",
                new SetGradeCommand(new ExamRegistrationService()));

        commands.put("apply-for-admission",
                new ApplyForAdmissionCommand(new SpecialityService(), new StudentService(), new ApplicationService()));

        commands.put("list-of-enrolled",
                new ListOfEnrolledCommand());

        commands.put("personal-cabinet",
                new PersonalCabinetCommand());

        commands.put("apply-admission",
                new ToApplyingCommand());

        commands.put("put-marks",
                new ToPutMarksCommand());

        commands.put("reg-exam",
                new ToRegExamCommand());

        commands.put("reg-me",
                new ToRegistrationCommand());
        commands.put("log-me",
                new ToLoginCommand());
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
        //System.out.println("1" + path);
        path = path.replaceAll(".*/introductory-campaign/" , "");
        //System.out.println("2" + path);

        Command command = commands.getOrDefault(path , (req, resp)->"/welcome.jsp");

        String page = command.execute(request, response);
        //System.out.println("3"+page);

        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect@", ""));
           // System.out.println(page.replace("redirect@", ""));
        } else {
            request.getRequestDispatcher(page).forward(request,response);
        }
        //request.getRequestDispatcher(page).towards(request,response);
    }
}











//todo disable autocommit and make double transaction
//for example for update two tables

//todo pagination


//todo many-to-many
