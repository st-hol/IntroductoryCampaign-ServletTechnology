package org.training.model.dao.mapper;

import org.training.model.entity.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class ExamMapper implements ObjectMapper<Exam> {
    @Override
    public Exam extractFromResultSet(ResultSet rs) throws SQLException {

        Exam exam = new Exam();

        exam.setId(rs.getInt("id_subject"));
        exam.setExamName(rs.getString("name_subject"));

        return exam;
    }

    @Override
    public Exam makeUnique(Map<Long, Exam> existing, Exam entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
