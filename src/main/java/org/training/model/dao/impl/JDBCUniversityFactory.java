package org.training.model.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.model.dao.SpecialityDao;
import org.training.model.dao.UniversityDao;
import org.training.model.dao.impl.queries.UniversitySQL;
import org.training.model.dao.mapper.SpecialityMapper;
import org.training.model.dao.mapper.UniversityMapper;
import org.training.model.entity.Speciality;
import org.training.model.entity.University;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCUniversityFactory implements UniversityDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(JDBCUniversityFactory.class);


    public JDBCUniversityFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(University entity) {

    }



    @Override
    public University findById(long id) {
        UniversityMapper universityMapper = new UniversityMapper();

        University result = new University();
        result.setId(-1);

        try (PreparedStatement ps = connection.prepareStatement(UniversitySQL.READ_ONE.getQUERY())){

            ps.setLong(1, id);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = universityMapper.extractFromResultSet(rs);
            }

        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public List<University> findAll() {
        return null;
    }

    @Override
    public void update(University university) {

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
}
