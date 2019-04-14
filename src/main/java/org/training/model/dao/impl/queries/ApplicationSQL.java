package org.training.model.dao.impl.queries;


public enum ApplicationSQL {

    READ_ONE("select * from application_for_admission where id_application=(?)"),

    READ_ALL("select * from application_for_admission "),

    INSERT("INSERT INTO application_for_admission " +
            "(id_student, id_speciality, is_enrolled) " +
            "VALUES ((?),(?),(?));"),

    DELETE(""),

    UPDATE("");



    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    ApplicationSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}