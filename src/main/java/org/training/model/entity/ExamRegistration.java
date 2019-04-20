package org.training.model.entity;

public class ExamRegistration {

    private long idStudent;
    private long idSubject;
    private double examScore;


    public ExamRegistration() {
    }



    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(long idSubject) {
        this.idSubject = idSubject;
    }


    @Override
    public String toString() {
        return "ExamRegistration{" +
                "idStudent=" + idStudent +
                ", idSubject=" + idSubject +
                ", examScore=" + examScore +
                '}';
    }
}
