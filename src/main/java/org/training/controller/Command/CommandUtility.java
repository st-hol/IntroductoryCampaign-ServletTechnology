package org.training.controller.Command;

import org.training.model.entity.Student;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {

    static void setUserRole(HttpServletRequest request, Student.ROLE role, String email) {

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        context.setAttribute("email", email);
        session.setAttribute("role", role);

    }

    static boolean checkUserIsLogged(HttpServletRequest request, String email, String password){

        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession()
                .getServletContext()
                .getAttribute("loggedUsers");

        //FIXME
        //if(loggedUsers.stream().anyMatch(login::equals) && loggedUsers.stream().anyMatch(password::equals)) {

        if(loggedUsers.stream().anyMatch(email::equals)) {
            return true;
        }

        loggedUsers.add(email);
        request.getSession()
                .getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }



    public static void unlogUser(HttpServletRequest request, String email) {

        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>)
                request.getSession().getServletContext().getAttribute("loggedUsers");

        loggedUsers.remove(email);

        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);

        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("password");
        session.removeAttribute("role");
    }


}
