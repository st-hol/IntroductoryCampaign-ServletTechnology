package org.training.controller.сommand.actions;

import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.dao.impl.JDBCStudentDao;
import org.training.model.entity.Student;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * This class is responsible for
 * showing all enrolled students list.
 *
 * @author Stanislav Holovachuk
 */
public class ShowEnrolledCommand implements Command {

    private StudentService studentService;


    public ShowEnrolledCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Here pagination is provided.
     *
     * Has hardcoded quantity of displayed records(recordsPerPage).
     * Operates by getting page-number from request and delegates it to service
     * which returns certain records.
     *
     *
     * @author Stanislav Holovachuk
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        //to prevent user coming back to cached pages after logout
        CommandUtility.disallowBackToCached(request, response);


        int page = 1;
        int recordsPerPage = 3;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));


        JDBCStudentDao.PaginationResult paginationResult =
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