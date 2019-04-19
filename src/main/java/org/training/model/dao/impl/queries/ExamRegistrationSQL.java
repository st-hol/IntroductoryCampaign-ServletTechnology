package org.training.model.dao.impl.queries;


public enum ExamRegistrationSQL {

    READ_ONE(""),

    READ_ALL(""),

    INSERT("INSERT INTO students_has_exams " +
            "(id_student, id_subject, exam_score) " +
            "VALUES ((?),(?),(?));"),

    DELETE(""),

    UPDATE("UPDATE students_has_exams" +
            " SET exam_score = (?) " +
            " WHERE(id_student = (?)) and (id_subject = (?));"),


    IS_EXIST("SELECT * FROM students_has_exams where id_student = (?) and id_subject = (?);");

    String QUERY;

    ExamRegistrationSQL(String QUERY) {
        this.QUERY = QUERY;
    }
    public String getQUERY() {
        return QUERY;
    }
}