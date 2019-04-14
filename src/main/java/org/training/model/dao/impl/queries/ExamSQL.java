package org.training.model.dao.impl.queries;


public enum ExamSQL {
    READ_ONE(""),

    READ_ALL("select * from exams"),

    INSERT(""),

    DELETE(""),

    UPDATE("");



    String QUERY;

    ExamSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}






//"select * from exams left join students_has_exams " +
//            "on exams.id_subject = students_has_exams.id_subject " +
//            "left join students " +
//            "on students_has_exams.id_student = students.id_student"