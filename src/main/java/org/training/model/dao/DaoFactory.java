package org.training.model.dao;


import org.training.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;

    public abstract ExamDao createExamDao();

    public abstract StudentDao createStudentDao();

    public abstract ExamRegistrationDao createExamRegistrationDao();

    public abstract SpecialityDao createSpecialityDao();

    public abstract ApplicationDao createApplicationDao();

    public abstract UniversityDao createUniversityDao();

    public static DaoFactory getInstance() {

        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }

        return daoFactory;
    }

}
