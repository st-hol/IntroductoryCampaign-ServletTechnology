package org.training.controller;

import org.training.controller.Command.*;
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
                new LogOutCommand());
        commands.put("home",
                new HomeCommand());
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

        Command command = commands.getOrDefault(path , (req, resp)->"/index.jsp");

        String page = command.execute(request, response);

        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect@", ""));
           // System.out.println(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request,response);
        }
        //request.getRequestDispatcher(page).forward(request,response);
    }
}
