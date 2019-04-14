package org.training.model.dao.impl;


import org.training.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public ExamDao createExamDao() {
        return new JDBCExamFactory(getConnection());
    }

    @Override
    public StudentDao createStudentDao() {
        return new JDBCStudentFactory(getConnection());
    }

    @Override
    public ExamRegistrationDao createExamRegistrationDao() {
        return new JDBCExamRegistrationFactory(getConnection());
    }

    @Override
    public SpecialityDao createSpecialityDao() {
        return new JDBCSpecialityFactory(getConnection());
    }

    @Override
    public ApplicationDao createApplicationDao() {
        return new JDBCApplicationFactory(getConnection());
    }


    @Override
    public UniversityDao createUniversityDao() {
        return new JDBCUniversityFactory(getConnection());
    }

    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
