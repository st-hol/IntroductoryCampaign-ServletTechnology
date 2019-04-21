package org.training.model.service;

import org.training.model.dao.DaoFactory;
import org.training.model.dao.UniversityDao;
import org.training.model.entity.University;



/**
 * This class realize logic
 * for manipulation with db.
 *
 * @author Stanislav Holovachuk
 */
public class UniversityService {

    private DaoFactory daoFactory = DaoFactory.getInstance();


    public University getUniversityById(long id){
        try (UniversityDao dao = daoFactory.createUniversityDao()) {
            return dao.findById(id);
        }
    }

}
