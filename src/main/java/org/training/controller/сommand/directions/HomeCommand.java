package org.training.controller.сommand.directions;

import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.entity.Speciality;
import org.training.model.service.SpecialityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



/**
 * This class is responsible for forwarding
 * to home page from user-role or admin-role
 * personal cabinet.
 *
 * @author Stanislav Holovachuk
 */

public class HomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CommandUtility.defineSpecialitiesAttribute(request);
        return "/jsp/index.jsp";
    }
}















//        String path = request.getServletContext().getContextPath();
//        //System.out.println(path);
//        return "redirect@" + path + "/jsp/index.jsp";





//            Optional<Object> role = Optional.ofNullable(request.getSession().getAttribute("role"));
//            return role.map(o -> "redirect@" + o.toString().toLowerCase())
//                    .orElse("redirect@login");



//servlet jss - routes