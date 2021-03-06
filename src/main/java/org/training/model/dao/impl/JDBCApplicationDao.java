package org.training.model.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.model.dao.ApplicationDao;
import org.training.model.dao.impl.queries.ApplicationSQL;
import org.training.model.dao.mapper.ApplicationMapper;
import org.training.model.entity.ApplicationForAdmission;

import java.sql.*;
import java.util.*;

public class JDBCApplicationDao implements ApplicationDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(JDBCApplicationDao.class);


    public JDBCApplicationDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ApplicationForAdmission applicationForAdmission) {
        try (PreparedStatement ps = connection.prepareStatement(ApplicationSQL.INSERT.getQUERY())) {

            ps.setLong(1, applicationForAdmission.getStudent().getId());
            ps.setLong(2, applicationForAdmission.getSpeciality().getId());
            ps.setInt(3, applicationForAdmission.getIsEnrolled());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.fatal("Caught SQLException exception", e);
        }
    }

    @Override
    public ApplicationForAdmission findById(long id) {

        ApplicationMapper applicationMapper = new ApplicationMapper();

        ApplicationForAdmission result = new ApplicationForAdmission();
        result.setId(-1);

        try (PreparedStatement ps = connection.prepareStatement(ApplicationSQL.READ_ONE.getQUERY())) {

            ps.setLong(1, id);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = applicationMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.fatal("Caught SQLException exception", e);
        }
        return result;
    }

    @Override
    public List<ApplicationForAdmission> findAll() {
        Map<Long, ApplicationForAdmission> applications = new HashMap<>();

        final String query = ApplicationSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(query);
            ApplicationMapper applicationMapper = new ApplicationMapper();

            while (rs.next()) {
                ApplicationForAdmission application = applicationMapper.extractFromResultSet(rs);
                application = applicationMapper.makeUnique(applications, application);
            }

            return new ArrayList<>(applications.values());

        } catch (SQLException e) {
            e.printStackTrace();
            logger.fatal("Caught SQLException exception", e);
            return null;
            //todo optional
        }
    }

    @Override
    public void update(ApplicationForAdmission applicationForAdmission) {

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
    public ApplicationForAdmission findByStudentId(long id) {
        ApplicationMapper applicationMapper = new ApplicationMapper();

        ApplicationForAdmission result = new ApplicationForAdmission();
        result.setId(-1);

        try (PreparedStatement ps = connection.prepareStatement("select * from application_for_admission where id_student=(?)")) {

            ps.setLong(1, id);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = applicationMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean recordAlreadyExist(long idStudent) {
        try (PreparedStatement ps = connection.prepareStatement(ApplicationSQL.IS_EXIST.getQUERY())) {

            ps.setLong(1, idStudent);

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
