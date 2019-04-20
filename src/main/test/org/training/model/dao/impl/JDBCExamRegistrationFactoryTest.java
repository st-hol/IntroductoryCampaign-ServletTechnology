package org.training.model.dao.impl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.training.model.dao.DaoFactory;
import org.training.model.dao.ExamRegistrationDao;
import org.training.model.entity.ExamRegistration;
import org.training.model.service.ExamRegistrationService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class JDBCExamRegistrationFactoryTest {

    private static long id_student = 25;
    private static long id_subject = 1;
    private static long exam_score = 101;


    @BeforeClass
    public static void setUp() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/introductory_campaign", "root", "PASSWORD");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT IGNORE INTO students_has_exams " +
                    "SET id_student = " + id_student +
                    ", id_subject = " + id_subject +
                    ", exam_score = " + exam_score + ";");
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void recordAlreadyExist() {

        DaoFactory daoFactory = DaoFactory.getInstance();
        ExamRegistrationDao examRegistrationDao = daoFactory.createExamRegistrationDao();
        boolean isAlreadyRegistered = examRegistrationDao.recordAlreadyExist(id_student, id_subject);

        assertTrue(isAlreadyRegistered);
    }
}