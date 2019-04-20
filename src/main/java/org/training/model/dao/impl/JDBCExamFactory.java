package org.training.model.dao.impl;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.training.model.dao.ExamDao;
import org.training.model.dao.impl.queries.ExamSQL;
import org.training.model.dao.mapper.ExamMapper;
import org.training.model.dao.mapper.StudentMapper;
import org.training.model.entity.Exam;
import org.training.model.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCExamFactory implements ExamDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(JDBCExamFactory.class);


    public JDBCExamFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Exam entity) {
    }

    @Override
    public Exam findById(long id) {
        return null;
    }


    @Override
    public List<Exam> findAll() {
        Map<Long, Exam> exams = new HashMap<>();

        final String query = ExamSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(query);
            ExamMapper examMapper = new ExamMapper();

            while (rs.next()) {
                Exam exam = examMapper.extractFromResultSet(rs);
                exam = examMapper.makeUnique(exams, exam);
            }

            return new ArrayList<>(exams.values());
        } catch (SQLException e) {
            logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
            return null;
            //todo optional
        }
    }

    @Override
    public void update(Exam exam) {

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







//many to many

//    @Override
//    public List<Exam> findAll() {
//
//        List<Exam> resultList = new ArrayList<>();
//
//        Map<Long, Student> students = new HashMap<>();
//        Map<Long, Exam> exams = new HashMap<>();
//
//        try (Statement ps = connection.createStatement()) {
//            ResultSet rs = ps.executeQuery(ExamSQL.READ_ALL.getQUERY());
//
//            StudentMapper studentMapper = new StudentMapper();
//            ExamMapper examMapper = new ExamMapper();
//
//            while (rs.next()) {
//                Exam exam = examMapper.extractFromResultSet(rs);
//                Student student = studentMapper.extractFromResultSet(rs);
//
//                exam = examMapper.makeUnique(exams, exam);
//                student = studentMapper.makeUnique(students, student);
//
//                exam.getStudents().add(student);
//                student.getExams().add(exam);
//
//                resultList.add(exam);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//
////        for (Student student: students.values()) {
////                System.out.println(student.getEmail());
////        }
//
//        return resultList;
//    }