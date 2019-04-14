package org.training.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//servlet jss - routes


public class HomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String path = request.getServletContext().getContextPath();
        //System.out.println(path);
        return "redirect@" + path;
    }
}




//            Optional<Object> role = Optional.ofNullable(request.getSession().getAttribute("role"));
//            return role.map(o -> "redirect@" + o.toString().toLowerCase())
//                    .orElse("redirect@login");