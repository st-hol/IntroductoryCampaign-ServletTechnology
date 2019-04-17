package org.training.controller.сommand.account;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.dao.StudentDao;
import org.training.model.entity.Student;
import org.training.model.service.StudentService;
import org.training.model.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {

    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private StudentService studentService;

    public LoginCommand(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        if (!(UserValidator.validateEmail(email) && UserValidator.validatePassword(password))) {
            //throw new RuntimeException("invalid input parameters");
            //return "redirect@" + path + "/jsp/login.jsp?dataInvalid=true";
            logger.info("User [" + email + "]" + "entered wrong data.");
            return "/jsp/login.jsp?dataInvalid=true";
        }

        StudentDao dao = studentService.getDaoFactory();

        if (dao.userIsExist(email, password)) {

            //never invokes due to access filter
            if (CommandUtility.checkUserIsLogged(request, email, password)) {
                String path = request.getServletContext().getContextPath();
                return "redirect@" + path + "/jsp/error/multilogin.jsp";
            }

            final Student.ROLE role = dao.getRoleByEmailPassword(email, password);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("role", role);
            logger.info("Student [" + email + "] role [" + role + "] signed in successfully.");

        } else {
            logger.info("Invalid attempt of login user: [" + email + "]");
            request.getSession().setAttribute("role", Student.ROLE.UNKNOWN);
        }

        Command personalCabinet = new PersonalCabinetCommand();
        return personalCabinet.execute(request, response);
    }












    //mb unlog user
    //todo validate
    //400

    //todo adduserlogged



            //todo mb get role and towards to
//    final HttpSession session = request.getSession();
//        //Logged user.
//        if (nonNull(session) &&
//                nonNull(session.getAttribute("email")) &&
//                nonNull(session.getAttribute("password"))) {
//
//            final Student.ROLE role = (Student.ROLE) session.getAttribute("role");
//
//            logger.info("Student from existing session [" + email + "] role [" + role + "] has entered successfully.");
//
//
//            //return moveToMenu(request, role);
//
//        } else

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */

//    //todo REDIRECT
//    private String moveToMenu( HttpServletRequest request, final Student.ROLE role) {
//
//        if (role.equals(Student.ROLE.ADMIN)) {
//
//            //return "redirect@admin/adminbasis.jsp";
//            return "/WEB-INF/admin/adminbasis.jsp";
//
//        } else if (role.equals(Student.ROLE.USER)) {
//            return "/WEB-INF/user/userbasis.jsp";
//
//        } else {
//
//            String path = request.getServletContext().getContextPath();
//            //System.out.println(path);
//            return "redirect@" + path + "/login.jsp?userExist=false";
//            //return "redirect@login.jsp?userExist=false";
//        }
//    }

}


//        if (name.equals("admin")){
//            CommandUtility.setUserRole(request, Student.ROLE.ADMIN, name);
//            return "/WEB-INF/admin/adminbasis.jsp";
//        } else if(name.equals("user")) {
//            CommandUtility.setUserRole(request, Student.ROLE.USER, name);
//            return "/WEB-INF/user/userbasis.jsp";
//        } else {
//            CommandUtility.setUserRole(request, Student.ROLE.UNKNOWN, name);
//            return "/login.jsp";
//        }






