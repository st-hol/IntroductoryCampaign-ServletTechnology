package org.training.model.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.model.dao.ExamRegistrationDao;
import org.training.model.dao.impl.queries.ExamRegistrationSQL;
import org.training.model.entity.ExamRegistration;

import java.sql.*;
import java.util.List;

public class JDBCExamRegistrationDao implements ExamRegistrationDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(JDBCExamRegistrationDao.class);


    public JDBCExamRegistrationDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ExamRegistration examRegistration) {
        try (PreparedStatement ps = connection.prepareStatement(ExamRegistrationSQL.INSERT.getQUERY())) {

            ps.setLong(1, examRegistration.getIdStudent());
            ps.setLong(2, examRegistration.getIdSubject());
            ps.setDouble(3, examRegistration.getExamScore());
            ps.execute();

        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
    }

    @Override
    public ExamRegistration findById(long id) {
        return null;
    }

    @Override
    public List<ExamRegistration> findAll() {
return null;
    }

    @Override
    public void update(ExamRegistration examRegistration) {
        try (PreparedStatement ps = connection.prepareStatement(ExamRegistrationSQL.UPDATE.getQUERY())) {

            ps.setDouble(1, examRegistration.getExamScore());
            ps.setLong(2, examRegistration.getIdStudent());
            ps.setLong(3, examRegistration.getIdSubject());


            ps.execute();
            //ps.executeUpdate();

        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {}

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean recordAlreadyExist(long idStudent, long idSubject) {

        try (PreparedStatement ps = connection.prepareStatement(ExamRegistrationSQL.IS_EXIST.getQUERY())){

            ps.setLong(1, idStudent);
            ps.setLong(2, idSubject);

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
}
