package org.training.model.dao.mapper;

import org.training.model.entity.University;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UniversityMapper implements ObjectMapper<University> {
    @Override
    public University extractFromResultSet(ResultSet rs) throws SQLException {

        University university = new University();

        university.setId(rs.getInt("id_university"));

        university.setNameUniversity(rs.getString("name_university"));


        return university;
    }

    @Override
    public University makeUnique(Map<Long, University> existing, University entity) {
        throw new RuntimeException("makeUnique empty");
    }
}
