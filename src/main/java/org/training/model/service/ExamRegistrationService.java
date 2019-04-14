package org.training.model.service;

import org.training.model.dao.DaoFactory;
import org.training.model.dao.ExamDao;
import org.training.model.dao.ExamRegistrationDao;
import org.training.model.entity.Exam;
import org.training.model.entity.ExamRegistration;

public class ExamRegistrationService {

    private DaoFactory daoFactory = DaoFactory.getInstance();


    public void registerForExam(ExamRegistration examRegistration) {
        try (ExamRegistrationDao examRegistrationDao = daoFactory.createExamRegistrationDao()) {
            examRegistrationDao.create(examRegistration);
        }
    }


    public void setGrade(ExamRegistration examRegistration) {
        try (ExamRegistrationDao examRegistrationDao = daoFactory.createExamRegistrationDao()) {
            examRegistrationDao.update(examRegistration);
        }
    }

}
