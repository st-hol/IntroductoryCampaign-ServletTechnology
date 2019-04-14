package org.training.model.dao.impl;

import org.training.model.dao.StudentDao;
import org.training.model.dao.impl.queries.StudentSQL;
import org.training.model.dao.mapper.StudentMapper;
import org.training.model.entity.Student;

import javax.validation.constraints.NotNull;
import java.sql.*;
import java.util.*;

public class JDBCStudentFactory implements StudentDao {

    private Connection connection;

    public JDBCStudentFactory(Connection connection) {
        this.connection = connection;
    }


    /**
     * Create Student(user/admin) in database.
     *
     * @param student for create.
     */
    @Override
    public void create(@NotNull final Student student) {

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.INSERT.getQUERY())) {

            //fixme can be null
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDouble(3, student.getRating());

            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPassword());
            ps.setInt(6, student.getRole().getRoleID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(long id) {
        StudentMapper studentMapper = new StudentMapper();

        Student result = new Student();
        result.setId(-1);

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.READ_ONE.getQUERY())){

            ps.setLong(1, id);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = studentMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public List<Student> findAll() {
        Map<Long, Student> users = new HashMap<>();

        final String query = StudentSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(query);
            StudentMapper studentMapper = new StudentMapper();

            while (rs.next()) {
                Student student = studentMapper.extractFromResultSet(rs);
                student = studentMapper.makeUnique(users, student);
            }
//            for (Student u: users.values()) {
//                System.out.println(u.getEmail());
//            }
            return new ArrayList<>(users.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            //todo optional
        }
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(long id) {

    }

//    @Override
//    public Optional<Student> findByEmail(String email) {
//        Optional<Student> result = Optional.empty();
//
//        String query = "SELECT * FROM user WHERE email = ?";
//
//        try(PreparedStatement ps = connection.prepareCall(query)) {
//
//            ps.setString(1, email);
//            ResultSet rs = ps.executeQuery();
//
//            StudentMapper studentMapper = new StudentMapper();
//
//            if (rs.next()) {
//                result = Optional.of(studentMapper.extractFromResultSet(rs));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }



    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Student.ROLE getRoleByEmailPassword(final String email, final String password) {
        Student.ROLE result = Student.ROLE.UNKNOWN;

        List<Student> students = findAll();

        for (Student student : students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                result = student.getRole();
            }
        }
        return result;
    }


    public boolean userIsExist(final String email, final String password) {
        boolean result = false;

        List<Student> students = findAll();

        for (Student student : students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }







}
