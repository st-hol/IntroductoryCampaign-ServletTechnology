package org.training.model.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.model.dao.SpecialityDao;

import org.training.model.dao.impl.queries.SpecialitySQL;
import org.training.model.dao.impl.queries.StudentSQL;
import org.training.model.dao.mapper.SpecialityMapper;
import org.training.model.dao.mapper.StudentMapper;
import org.training.model.entity.Speciality;
import org.training.model.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCSpecialityFactory  implements SpecialityDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(JDBCSpecialityFactory.class);


    public JDBCSpecialityFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Speciality entity) {
    }


    @Override
    public Speciality findById(long id) {
        SpecialityMapper specialityMapper = new SpecialityMapper();

        Speciality result = new Speciality();
        result.setId(-1);

        try (PreparedStatement ps = connection.prepareStatement(SpecialitySQL.READ_ONE.getQUERY())){

            ps.setLong(1, id);

            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = specialityMapper.extractFromResultSet(rs);
            }

        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Speciality> findAll() {
        Map<Long, Speciality> specialities = new HashMap<>();

        final String query = SpecialitySQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(query);
            SpecialityMapper specialityMapper = new SpecialityMapper();

            while (rs.next()) {
                Speciality speciality = specialityMapper.extractFromResultSet(rs);
                speciality = specialityMapper.makeUnique(specialities, speciality);
            }

            return new ArrayList<>(specialities.values());
        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
            return null;
            //todo optional
        }
    }

    @Override
    public void update(Speciality speciality) {

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
