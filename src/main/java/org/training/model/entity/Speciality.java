package org.training.model.entity;


public class Speciality {

    private long id;

    private String nameSpeciality;
    //private String nameUniversity;
    private University university;


    public Speciality() {
    }


    public Speciality(long id, String nameSpeciality, University university) {
        this.id = id;
        this.nameSpeciality = nameSpeciality;
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", nameSpeciality='" + nameSpeciality + '\'' +
                ", university=" + university.toString() +
                '}';
    }
}
