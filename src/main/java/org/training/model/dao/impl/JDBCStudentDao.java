package org.training.model.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.model.dao.StudentDao;
import org.training.model.dao.impl.queries.StudentSQL;
import org.training.model.dao.mapper.StudentMapper;
import org.training.model.entity.Student;

import javax.validation.constraints.NotNull;
import java.sql.*;
import java.util.*;

public class JDBCStudentDao implements StudentDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(JDBCStudentDao.class);

    public JDBCStudentDao(Connection connection) {
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

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDouble(3, student.getRating());

            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPassword());
            ps.setInt(6, student.getRole().getRoleID());

            ps.execute();

        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
    }

    /**
     * finds Student in database.
     *
     * @param id student id.
     */
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
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * obtains all Students from database.
     *
     */
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
            logger.fatal("Caught SQLException exception", e);
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


    /**
     * Uses for obtaining user's role.
     *
     * @param email String
     * @param  password String
     * @return Student.ROLE
     */
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
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * searches Student in database by email and password
     *
     * @param email String
     * @param password String
     * @return boolean
     */
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
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return false;
    }


    /**
     * checks if email in database is already taken
     *
     * @param email String
     * @return boolean
     */
    @Override
    public boolean emailAlreadyTaken(final String email) {

        try (PreparedStatement ps = connection.prepareStatement(StudentSQL.READ_BY_EMAIL.getQUERY())) {

            ps.setString(1, email);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return false;
    }


    /**
     * SQL query obtains all Students limited by lower and upper bounds ordered by descent according to rating
     * and quantity of all records got from database.
     *
     * @param lowerBound integer value.
     * @param upperBound integer value.
     * @return object of user-defined class PaginationResult. Which contains of two fields:
     * 1)the List of obtained Students.
     * 2)number of records was read.
     */
    @Override
    public PaginationResult findByPagination(int lowerBound, int upperBound) {

        PaginationResult paginationResult = new PaginationResult();

        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM application_for_admission as app " +
                "left join students as st on app.id_student = st.id_student " +
                "where app.is_enrolled = 1 order by st.rating DESC " +
                "limit  "
                + lowerBound + ", " + upperBound;

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
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        paginationResult.setResultList(new ArrayList<>(users.values()));
        return paginationResult;
    }

    /**
     * It is user-defined class just for returning result from findByPagination() method.
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


}


