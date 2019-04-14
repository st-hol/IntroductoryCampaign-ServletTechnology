package org.training.controller.listener;

//import org.training.model.daoo.UserDAO;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;


/**
 * ContextListener put user daoo to servlet context.
 */
@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * Fake database connector.
     */
    //private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {


       final ServletContext servletContext = servletContextEvent.getServletContext();

       servletContext.setAttribute("loggedUsers", new HashSet<String>());

//        dao = new AtomicReference<>(new UserDAO());
//        dao.get().add(new Student(1, "admin", "1", ADMIN));
//        dao.get().add(new Student(2, "user", "1", USER));
//        final ServletContext servletContext =
//                servletContextEvent.getServletContext();
//        servletContext.setAttribute("accounts_dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        //final ServletContext servletContext = servletContextEvent.getServletContext();
        //servletContext.removeAttribute("loggedUsers");
    }
}
