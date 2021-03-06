package org.training.controller.filters;

import org.training.model.entity.Student;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


public class AccessFilter implements Filter {
    private Map<Student.ROLE, Set<String>> allowedRoutes;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowedRoutes = new HashMap<>();
        allowedRoutes.put(Student.ROLE.UNKNOWN,
                Stream.of("/", "/reg-me", "/log-me", "/login", "/registration", "/home")
                        .collect(collectingAndThen(
                                toCollection(HashSet::new), Collections::unmodifiableSet)));

        allowedRoutes.put(Student.ROLE.USER,
                Stream.of("/", "/logout", "/home", "/login", "/registration", "/show-all-exams", "/registrate-for-exam",
                "/apply-for-admission", "/list-of-enrolled", "/personal-cabinet", "/apply-admission", "/reg-exam")
                        .collect(collectingAndThen(
                                toCollection(HashSet::new), Collections::unmodifiableSet)));

        allowedRoutes.put(Student.ROLE.ADMIN,
                Stream.of("/", "/logout", "/home", "/login", "/registration", "/show-all-exams", "/list-of-enrolled", "/personal-cabinet",
                        "/set-grade", "/put-marks")
                        .collect(collectingAndThen(
                                toCollection(HashSet::new), Collections::unmodifiableSet)));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI()
                .replace(request.getContextPath(), "")
                .replace(request.getServletPath(), "");

        if (request.getSession().getAttribute("role") == null) {
            request.getSession().setAttribute("role", Student.ROLE.UNKNOWN);
        }
        Student.ROLE currentRole = ((Student.ROLE)request.getSession().getAttribute("role"));



        if ( allowedRoutes.get(currentRole).contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/jsp/error/403.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {}
}







////        if ( allowedRoutes.get(currentRole).contains(path)) {
////            filterChain.doFilter(servletRequest, servletResponse);
////        } else {
////            request.getRequestDispatcher("/jsp/error/403.jsp").forward(request,response);
////        }
//
//
//
////        if ( ! allowedRoutes.get(currentRole).contains(path)) {
////            //response.sendRedirect("/jsp/error/403.jsp");
////            request.getRequestDispatcher("/jsp/error/403.jsp").forward(request,response);
//////            response.sendError(HttpServletResponse.SC_GONE);
////        }
////        filterChain.doFilter(servletRequest, servletResponse);
//
//
//
//
//
////public class AuthFilter implements Filter {
////    @Override
////    public void init(FilterConfig filterConfig) throws ServletException {
////
////    }
////
////    @Override
////    public void doFilter(ServletRequest request,
////                         ServletResponse response,
////                         FilterChain filterChain)
////            throws IOException, ServletException {
////
////
////        final HttpServletRequest req = (HttpServletRequest) request;
////        final HttpServletResponse res = (HttpServletResponse) response;
////
////
//////        HttpSession session = req.getSession();
//////        ServletContext context = request.getServletContext();
////
//////        System.out.println(session);
//////        System.out.println(session.getAttribute("role"));
//////        System.out.println(context.getAttribute("loggedUsers"));
////
/////*
////
////<works by utility.setuserrole
////mb with sesssion getatr(role)
////
////if page contains "admin
////    if check role "admin
////        do filter
////    else
////        write access denied
//// */
////
////
////        filterChain.doFilter(request,response);
////    }
////
////    @Override
////    public void destroy() {
////
////    }
////}
////
////
//////role filter
/////*
////
////allowedRoutes.put...
//// */