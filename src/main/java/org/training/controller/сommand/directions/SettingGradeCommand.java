package org.training.controller.сommand.directions;

import org.training.controller.сommand.Command;
import org.training.controller.сommand.CommandUtility;
import org.training.model.entity.Exam;
import org.training.model.entity.Student;
import org.training.model.service.ExamService;
import org.training.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SettingGradeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //to prevent user coming back to cached pages after logout
        CommandUtility.disallowBackToCached(request, response);

        CommandUtility.defineStudentsAttribute(request);
        CommandUtility.defineExamsAttribute(request);

        return "/WEB-INF/admin/putmarks.jsp";
    }
}
