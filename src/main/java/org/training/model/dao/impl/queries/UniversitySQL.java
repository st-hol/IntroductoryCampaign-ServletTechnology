package org.training.model.dao.impl.queries;


public enum UniversitySQL {
    READ_ONE("SELECT * FROM universities where id_university=(?)"),
    READ_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    String QUERY;

    UniversitySQL(String QUERY) {
        this.QUERY = QUERY;
    }


    public String getQUERY() {
        return QUERY;
    }
}