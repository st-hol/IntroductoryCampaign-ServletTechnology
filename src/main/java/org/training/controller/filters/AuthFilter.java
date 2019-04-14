package org.training.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;





public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {


        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;


//        HttpSession session = req.getSession();
//        ServletContext context = request.getServletContext();

//        System.out.println(session);
//        System.out.println(session.getAttribute("role"));
//        System.out.println(context.getAttribute("loggedUsers"));

/*

<works by utility.setuserrole
mb with sesssion getatr(role)

if page contains "admin
    if check role "admin
        do filter
    else
        write access denied
 */


        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}


//role filter
/*

ways.put...
 */