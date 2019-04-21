package org.training.model.dao;


import org.training.model.dao.impl.JDBCStudentDao;
import org.training.model.entity.Student;

public interface StudentDao extends GenericDao<Student> {


   Student.ROLE getRoleByEmailPassword(final String email, final String password);

   boolean userIsExist(final String email, final String password);

   boolean emailAlreadyTaken(final String email);

   JDBCStudentDao.PaginationResult findByPagination(int offset, int noOfRecords);

}
