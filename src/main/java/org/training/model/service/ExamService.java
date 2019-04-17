package org.training.model.service;

import org.training.model.dao.DaoFactory;
import org.training.model.dao.ExamDao;

import org.training.model.entity.Exam;
import org.training.model.entity.ExamRegistration;
import org.training.model.entity.Student;

import java.util.List;
import java.util.Optional;




public class ExamService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public ExamDao getDaoFactory() {
        return daoFactory.createExamDao();
    }


    public List<Exam> getAllExams() {
        try (ExamDao dao = daoFactory.createExamDao()) {
            return dao.findAll();
        }
    }


}
