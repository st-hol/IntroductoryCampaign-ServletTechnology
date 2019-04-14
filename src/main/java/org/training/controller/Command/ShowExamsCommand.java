package org.training.controller.Command;

import org.training.model.dao.ExamDao;
import org.training.model.dao.StudentDao;
import org.training.model.entity.Exam;
import org.training.model.service.ExamService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowExamsCommand implements Command {


    private ExamService examService;

    public ShowExamsCommand(ExamService examService) {
        this.examService = examService;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        List<Exam> exams = examService.getAllExams();


        System.out.println("exams::");
        for (Exam exam: exams ) {
            exam.print();
        }

        return "/index.jsp";
    }
}


//todo smth like
//// In AccountsServlet.java
//public class AccountsServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("accountid");
//        // do something
//        // REDIRECT to an JSP page, manually passing QUERYSTRING along.
//        resp.sendRedirect("/namedcounter.jsp?name=" + req.getParameter("name"));
//    }
//}
