package org.training.controller.сommand.account;

import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.entity.Exam;
import org.training.model.entity.Speciality;
import org.training.model.entity.Student;
import org.training.model.service.ExamService;
import org.training.model.service.SpecialityService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Move user to menu.
 * If access 'admin' move to admin menu.
 * If access 'user' move to user menu.
 *
 * @author Stanislav Holovachuk
 */
public class PersonalCabinetCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final HttpSession session = request.getSession();
        final Student.ROLE role = (Student.ROLE) session.getAttribute("role");



        if ( session.getAttribute("role") != Student.ROLE.UNKNOWN) {
            //to prevent user coming back to cached pages after logout
            CommandUtility.disallowBackToCached(request, response);
        }


        if (role.equals(Student.ROLE.ADMIN)) {
            return "/WEB-INF/admin/adminbasis.jsp";
        } else if (role.equals(Student.ROLE.USER)) {
            return "/WEB-INF/user/userbasis.jsp";
        } else {
            return "/jsp/login.jsp?userExist=false";
        }
    }
}






//String path = request.getServletContext().getContextPath();
//System.out.println("redirect@" + path + "/jsp/login.jsp?userExist=false");
//return "redirect@" + path + "/jsp/login.jsp?userExist=false";