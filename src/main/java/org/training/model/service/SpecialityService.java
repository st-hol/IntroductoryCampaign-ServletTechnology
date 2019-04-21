package org.training.model.service;

import org.training.model.dao.DaoFactory;
import org.training.model.dao.SpecialityDao;
import org.training.model.entity.Speciality;

import java.util.List;


/**
 * This class realize logic
 * for manipulation with db.
 *
 * @author Stanislav Holovachuk
 */
public class SpecialityService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * Obtains speciality record by id.
     *
     * @param id long.
     */
    public Speciality getSpecialityById(long id){
        try (SpecialityDao dao = daoFactory.createSpecialityDao()) {
            return dao.findById(id);
        }
    }

    /**
     * Obtains all specialities.
     *
     */
    public List<Speciality> getAllSpecialities(){
        try (SpecialityDao dao = daoFactory.createSpecialityDao()) {
            return dao.findAll();
        }
    }

}
