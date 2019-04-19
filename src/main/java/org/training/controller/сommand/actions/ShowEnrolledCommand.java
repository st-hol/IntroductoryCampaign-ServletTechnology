package org.training.controller.сommand.actions;

import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.dao.StudentDao;
import org.training.model.dao.impl.JDBCStudentFactory;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import org.training.model.service.ApplicationService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowEnrolledCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        //to prevent user coming back to cached pages after logout
        CommandUtility.disallowBackToCached(request, response);

        int page = 1;
        int recordsPerPage = 3;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        final StudentService studentService = new StudentService();

        JDBCStudentFactory.PaginationResult paginationResult =
                studentService.getAllEnrolledStudentsByPagination(
                        (page - 1) * recordsPerPage, recordsPerPage);


        List<Student> enrolledStudents = paginationResult.getResultList();
        int noOfRecords = paginationResult.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        request.setAttribute("enrolledStudents", enrolledStudents );
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);


        //todo make it pretty (.map)
        final String role = request.getSession().getAttribute("role").toString().toLowerCase();
        return "/WEB-INF/" + role + "/enrolledlist.jsp";
    }
}



//
//        StudentDao dao = studentService.getDaoFactory();
//        List<Student> list = dao.findByPagination((page-1)*recordsPerPage,
//                recordsPerPage);
//        dao.close();



//        System.out.println("records:" + noOfRecords);
//        System.out.println("pages:" + noOfPages);
//        System.out.println("cur:" + page);






//     return "/WEB-INF/common/enrolledlist.jsp";

//        System.out.println("students::");
//        for (Student student: enrolledStudents ) {
//            System.out.println(student.toString());
//        }