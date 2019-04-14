package org.training.model.entity;

import java.util.Observable;


public class ApplicationForAdmission   {

    private long id;
    private Student student;
    private Speciality speciality;

    //boolean
    private int isEnrolled;

    public ApplicationForAdmission() {
    }

    public ApplicationForAdmission(long id, Student student, Speciality speciality, int isEnrolled) {
        this.id = id;
        this.student = student;
        this.speciality = speciality;
        this.isEnrolled = isEnrolled;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }


    public int getIsEnrolled() {
        return isEnrolled;
    }

    public void setIsEnrolled(int isEnrolled) {
        this.isEnrolled = isEnrolled;
    }


    @Override
    public String toString() {
        return "ApplicationForAdmission{" +
                "id=" + id +
                ", student=" + student.toString() +
                ", speciality=" + speciality.toString() +
                ", isEnrolled=" + isEnrolled +
                '}';
    }
}
