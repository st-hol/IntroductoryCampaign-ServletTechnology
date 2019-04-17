package org.training.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;


/**
 * ContextListener put user loggedUsers to servlet context.
 */
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

       final ServletContext servletContext = servletContextEvent.getServletContext();

       servletContext.setAttribute("loggedUsers", new HashSet<String>());

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute("loggedUsers");
    }
}
