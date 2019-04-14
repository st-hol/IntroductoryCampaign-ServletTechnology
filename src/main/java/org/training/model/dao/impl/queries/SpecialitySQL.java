package org.training.model.dao.impl.queries;
/**
 * SQL queries for specialities table.
 */
public enum SpecialitySQL {
    READ_ONE("SELECT * FROM specialities where id_speciality=(?)"),
    READ_ALL("select * from specialities"),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    String QUERY;

    SpecialitySQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}
