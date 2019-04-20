package org.training.model.entity;

public class University {

    private long id;
    private String nameUniversity;


    public University() {
    }

    public University(long id, String nameUniversity) {
        this.id = id;
        this.nameUniversity = nameUniversity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }


    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", nameUniversity='" + nameUniversity + '\'' +
                '}';
    }
}
