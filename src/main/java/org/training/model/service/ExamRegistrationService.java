package org.training.model.service;

import org.training.model.dao.DaoFactory;
import org.training.model.dao.ExamDao;
import org.training.model.dao.ExamRegistrationDao;
import org.training.model.entity.Exam;
import org.training.model.entity.ExamRegistration;
import org.training.model.exception.AlreadyExistingDBRecordException;


/**
 * This class realize logic
 * for manipulation with db.
 *
 * @author Stanislav Holovachuk
 */
public class ExamRegistrationService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * Creates examRegistration record if such not exist yet.
     *
     * @param examRegistration ExamRegistration.
     */
    public void registerForExam(ExamRegistration examRegistration) throws AlreadyExistingDBRecordException {
        try (ExamRegistrationDao examRegistrationDao = daoFactory.createExamRegistrationDao()) {

            final long idStudent = examRegistration.getIdStudent();
            final long idSubject = examRegistration.getIdSubject();

            if (examRegistrationDao.recordAlreadyExist(idStudent, idSubject)){
                throw new AlreadyExistingDBRecordException("Student "+idStudent+" is already registered to exam "+idSubject);
            }

            examRegistrationDao.create(examRegistration);
        }
    }

    /**
     * Admin sets grades by updating examScore field in db.
     *
     * @param examRegistration ExamRegistration.
     */
    public void setGrade(ExamRegistration examRegistration) {
        try (ExamRegistrationDao examRegistrationDao = daoFactory.createExamRegistrationDao()) {
            examRegistrationDao.update(examRegistration);
        }
    }

}
