package org.training.model.dao.mapper;

import org.training.model.entity.ApplicationForAdmission;
import org.training.model.service.SpecialityService;
import org.training.model.service.StudentService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ApplicationMapper implements ObjectMapper<ApplicationForAdmission> {

    @Override
    public ApplicationForAdmission extractFromResultSet(ResultSet rs) throws SQLException {

        StudentService studentService = new StudentService();
        SpecialityService specialityService = new SpecialityService();

        ApplicationForAdmission applicationForAdmission = new ApplicationForAdmission();

        applicationForAdmission.setId(rs.getLong("id_application"));

        applicationForAdmission.setStudent(studentService.getStudentById(
                rs.getLong("id_student")));


        applicationForAdmission.setSpeciality(specialityService.getSpecialityById(
                rs.getLong("id_speciality")));

        applicationForAdmission.setIsEnrolled(rs.getInt("is_enrolled"));

        return applicationForAdmission;
    }

    @Override
    public ApplicationForAdmission makeUnique(Map<Long, ApplicationForAdmission> existing, ApplicationForAdmission entity) {

        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
