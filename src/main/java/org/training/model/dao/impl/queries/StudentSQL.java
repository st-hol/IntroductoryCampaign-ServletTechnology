package org.training.model.dao.impl.queries;

/**
 * SQL queries for students table.
 */
public enum StudentSQL {
    READ_ONE("select * from students where id_student=(?)"),

    READ_ALL("select * from students"),

    INSERT("INSERT INTO students " +
            "(first_name, last_name, rating, email, password, id_role) " +
            "VALUES ((?),(?),(?),(?), (?), (?))"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    StudentSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}