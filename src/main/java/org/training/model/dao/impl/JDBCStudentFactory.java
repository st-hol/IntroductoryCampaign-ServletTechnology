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
    private int noOfRecords;

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

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.READ_ONE.getQUERY())) {

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


    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Student.ROLE getRoleByEmailPassword(final String email, final String password) {
        Student.ROLE result = Student.ROLE.UNKNOWN;

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.READ_BY_EMAIL_PASSWORD.getQUERY())) {

            ps.setString(1, email);
            ps.setString(2, password);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = Student.ROLE.getRoleById(rs.getInt("id_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
//        List<Student> students = findAll();
//
//        for (Student student : students) {
//            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
//                result = student.getRole();
//            }
//        }
//        return result;
    }

    @Override
    public boolean userIsExist(final String email, final String password) {

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.READ_BY_EMAIL_PASSWORD.getQUERY())) {

            ps.setString(1, email);
            ps.setString(2, password);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean emailAlreadyTaken(final String email) {

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.READ_BY_EMAIL.getQUERY())) {

            ps.setString(1, email);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public PaginationResult findByPagination(int offset, int noOfRecords) {

        PaginationResult paginationResult = new PaginationResult();

        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM application_for_admission as app " +
                "left join students as st on app.id_student = st.id_student " +
                "where app.is_enrolled = 1 " +
                "limit  "
                + offset + ", " + noOfRecords;

        Map<Long, Student> users = new HashMap<>();
        StudentMapper studentMapper = new StudentMapper();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = studentMapper.extractFromResultSet(rs);
                student = studentMapper.makeUnique(users, student);
            }
            rs.close();

            rs = ps.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                paginationResult.setNoOfRecords(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        paginationResult.setResultList(new ArrayList<>(users.values()));
        return paginationResult;
    }

    /**
     * just a container for returning result.
     */
    public class PaginationResult {
        private int noOfRecords;
        private List<Student> resultList;

        public int getNoOfRecords() {
            return noOfRecords;
        }

        public void setNoOfRecords(int noOfRecords) {
            this.noOfRecords = noOfRecords;
        }

        public List<Student> getResultList() {
            return resultList;
        }

        public void setResultList(List<Student> resultList) {
            this.resultList = resultList;
        }
    }


    public int getNoOfRecords() {
        return noOfRecords;
    }
}


