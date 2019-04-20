package org.training.model.service;

import org.training.model.dao.ApplicationDao;
import org.training.model.dao.DaoFactory;
import org.training.model.entity.ApplicationForAdmission;
import org.training.model.exception.AlreadyExistingDBRecordException;

import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;



public class ApplicationService // extends Observable
{

    private final long IS_ENROLLED = 1;

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void applyForAdmission(ApplicationForAdmission applicationForAdmission) throws AlreadyExistingDBRecordException {

        try (ApplicationDao applicationDao = daoFactory.createApplicationDao()) {

            final long idStudent = applicationForAdmission.getStudent().getId();

            if (applicationDao.recordAlreadyExist(idStudent)){
                throw new AlreadyExistingDBRecordException("Student "+idStudent+" has already applied for admission");
            }

            applicationDao.create(applicationForAdmission);
        }

        //param - id student
//        setChanged();
//        notifyObservers(applicationForAdmission.getStudent().getId());
    }

    public ApplicationForAdmission getApplicationById(long id){
        try (ApplicationDao dao = daoFactory.createApplicationDao()) {
            return dao.findById(id);
        }
    }

    public ApplicationForAdmission getApplicationByStudentId(long id){
        try (ApplicationDao dao = daoFactory.createApplicationDao()) {
            return dao.findByStudentId(id);
        }
    }


    public List<ApplicationForAdmission> getAllConfirmedApplications(){

        try (ApplicationDao applicationDao = daoFactory.createApplicationDao()) {
            List<ApplicationForAdmission> applications = applicationDao.findAll();

            return applications.stream()
                    .filter(a -> a.getIsEnrolled() == IS_ENROLLED).collect(Collectors.toList());
        }
    }
}
