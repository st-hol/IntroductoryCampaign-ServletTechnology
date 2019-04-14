package org.training.model.dao.mapper;


import org.training.model.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static org.training.model.entity.Student.ROLE.getRoleNameById;

public class StudentMapper implements ObjectMapper<Student>{

    //new User.Role(rs.getInt("rol_id")
    @Override
    public Student extractFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();

        student.setId(rs.getInt("id_student"));

        //todo smth
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setRating(rs.getDouble("rating"));


        student.setEmail(rs.getString("email"));
        student.setPassword(rs.getString("password"));
        student.setRole(getRoleNameById(
                rs.getInt("id_role")));


        return student;
    }

    @Override
    public Student makeUnique(Map<Long, Student> existing, Student entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
