package org.training.model.dao;


import org.training.model.entity.Student;

import java.util.Optional;

public interface StudentDao extends GenericDao<Student> {

   // Optional<Student> findByEmail(String email);

   Student.ROLE getRoleByEmailPassword(final String email, final String password);

   boolean userIsExist(final String email, final String password);

}
