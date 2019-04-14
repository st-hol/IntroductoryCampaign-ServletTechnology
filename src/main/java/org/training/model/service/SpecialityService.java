package org.training.model.service;

import org.training.model.dao.DaoFactory;
import org.training.model.dao.SpecialityDao;
import org.training.model.entity.Speciality;

import java.util.List;

public class SpecialityService {

    private DaoFactory daoFactory = DaoFactory.getInstance();


    public Speciality getSpecialityById(long id){
        try (SpecialityDao dao = daoFactory.createSpecialityDao()) {
            return dao.findById(id);
        }
    }

    public List<Speciality> getAllSpecialities(){
        try (SpecialityDao dao = daoFactory.createSpecialityDao()) {
            return dao.findAll();
        }
    }

}
