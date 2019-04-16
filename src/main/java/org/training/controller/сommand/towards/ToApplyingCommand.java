package org.training.controller.сommand.towards;

import org.training.controller.сommand.Command;
import org.training.model.entity.Speciality;
import org.training.model.service.SpecialityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToApplyingCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SpecialityService specialityService = new SpecialityService();
        List<Speciality> specialities = specialityService.getAllSpecialities();
        request.setAttribute("specialities", specialities);

        return "/WEB-INF/user/applyforadmission.jsp";
    }
}
