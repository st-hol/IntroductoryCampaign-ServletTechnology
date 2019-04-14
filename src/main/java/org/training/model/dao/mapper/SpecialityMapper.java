package org.training.model.dao.mapper;

import org.training.model.entity.Speciality;
import org.training.model.entity.University;
import org.training.model.service.UniversityService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;



public class SpecialityMapper implements ObjectMapper<Speciality>
{
    @Override
    public Speciality extractFromResultSet(ResultSet rs) throws SQLException {
        UniversityService universityService = new UniversityService();

        Speciality speciality = new Speciality();

        speciality.setId(rs.getInt("id_speciality"));

        speciality.setNameSpeciality(rs.getString("name_speciality"));

        speciality.setUniversity(universityService.getUniversityById(
                rs.getLong("id_university")
        ));

        return speciality;
    }

    @Override
    public Speciality makeUnique(Map<Long, Speciality> existing, Speciality entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}