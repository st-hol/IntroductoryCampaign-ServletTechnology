package org.training.model.dao;


import org.training.model.entity.ApplicationForAdmission;
import org.training.model.entity.Student;
import java.util.Optional;

public interface ApplicationDao extends GenericDao<ApplicationForAdmission> {

    ApplicationForAdmission findByStudentId(long id);
}
