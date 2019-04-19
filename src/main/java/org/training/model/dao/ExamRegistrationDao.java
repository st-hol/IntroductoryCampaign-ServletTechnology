package org.training.model.dao;

import org.training.model.entity.ExamRegistration;

public interface ExamRegistrationDao extends GenericDao<ExamRegistration> {

    boolean recordAlreadyExist(long idStudent, long idSubject);
}
