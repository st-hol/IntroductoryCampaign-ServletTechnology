package org.training.model.dao.impl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.training.model.dao.ApplicationDao;
import org.training.model.dao.DaoFactory;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.service.ApplicationService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class JDBCApplicationDaoTest {

    private static long id_student = 25;
    private static long id_application = 33;
    private static long id_speciality = 1;
    private static long is_enrolled = 0;

    @BeforeClass
    public static void setUp() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/introductory_campaign", "root", "PASSWORD");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT IGNORE INTO application_for_admission " +
                    "SET id_application = " + id_application +
                    ", id_student = " + id_student +
                    ", id_speciality = " + id_speciality +
                    ", is_enrolled = " + is_enrolled + ";");
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByStudentId() {

        ApplicationService applicationService = new ApplicationService();
        ApplicationForAdmission application = applicationService.getApplicationById(id_application);

        assertEquals(application.getStudent().getId(), id_student);
    }

    @Test
    public void recordAlreadyExist() {

        DaoFactory daoFactory = DaoFactory.getInstance();
        ApplicationDao examRegistrationDao = daoFactory.createApplicationDao();
        boolean hasAlreadyApplied = examRegistrationDao.recordAlreadyExist(id_student);

        assertTrue(hasAlreadyApplied);
    }
}