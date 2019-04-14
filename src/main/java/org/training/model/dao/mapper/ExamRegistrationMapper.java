package org.training.model.dao.mapper;

import org.training.model.entity.ExamRegistration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ExamRegistrationMapper implements ObjectMapper<ExamRegistration> {

    @Override
    public ExamRegistration extractFromResultSet(ResultSet rs) throws SQLException {
        ExamRegistration examRegistration = new ExamRegistration();

        examRegistration.setIdStudent(rs.getLong("id_student"));
        examRegistration.setIdSubject(rs.getLong("id_subject"));
        examRegistration.setExamScore(rs.getDouble("exam_score"));

        return examRegistration;
    }

    @Override
    public ExamRegistration makeUnique(Map<Long, ExamRegistration> existing, ExamRegistration entity) {
        return null;
        //todo bad
    }
}
