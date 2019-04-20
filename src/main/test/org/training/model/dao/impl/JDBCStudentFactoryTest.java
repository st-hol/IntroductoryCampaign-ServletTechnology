package org.training.model.dao.impl;

import org.junit.*;
import org.training.model.dao.DaoFactory;
import org.training.model.dao.StudentDao;
import org.training.model.entity.Student;
import org.training.model.service.StudentService;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCStudentFactoryTest {
    private static long id_student = 25;
    private static String first_name = "'test'";
    private static String last_name =  "'test'";
    private static int rating = 0;
    private static String email = "'test'";
    private static String password = "'1'";
    private static int id_role = 1;


    @BeforeClass
    public static void setUp() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/introductory_campaign", "root", "PASSWORD");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT IGNORE INTO students " +
                    "SET id_student = " + id_student +
                    ", first_name = " + first_name +
                    ", last_name = " + last_name +
                    ", rating = " + rating +
                    ", email = " + email +
                    ", password = " + password +
                    ", id_role = " + id_role + ";");
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void whenStudentIsExistThenReturnStudentWithId() {

        StudentService studentService = new StudentService();
        final Student result = studentService.getStudentById(id_student);

        assertEquals(result, new Student(id_student, "test", "test", rating, "test", "1", Student.ROLE.ADMIN));
    }

    @Test
    public void getRoleByEmailPassword() {

        StudentService studentService = new StudentService();
        Student student = studentService.getStudentById(id_student);
        Student.ROLE role = studentService.getRoleByEmailAndPass(student.getEmail(), student.getPassword());

        assertEquals(student.getRole().getRoleID(), role.getRoleID());
    }

    @Test
    public void userIsExist() {
        StudentService studentService = new StudentService();
        Student student = studentService.getStudentById(id_student);
        boolean isExistingUser = studentService.isExistingUser(student.getEmail(), student.getPassword());

        assertTrue(isExistingUser);
    }

    @Test
    public void emailAlreadyTaken() {
        StudentService studentService = new StudentService();
        Student student = studentService.getStudentById(id_student);

        DaoFactory  daoFactory = DaoFactory.getInstance();
        StudentDao  studentDao = daoFactory.createStudentDao();
        boolean isAlreadyTakenEmail = studentDao.emailAlreadyTaken(student.getEmail());

        assertTrue(isAlreadyTakenEmail);
    }


    /**
     * check the rating for property not growth
     */
    @Test
    public void findByPagination() {
        StudentService studentService = new StudentService();
        List<Student> studentList = studentService
                .getAllEnrolledStudentsByPagination(0, 3)
                .getResultList();

        boolean sorted = true;
        for (int i = 1; i < studentList.size(); i++) {
            if (studentList.get(i-1).getRating() - (studentList.get(i).getRating()) < 1e-1) {
                sorted = true;
            } else {
                sorted = false;
            }
        }
        assertTrue(sorted);
    }
}