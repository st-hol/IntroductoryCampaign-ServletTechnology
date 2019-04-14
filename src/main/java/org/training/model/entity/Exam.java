package org.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Exam {


    private long id;

    //private double examScore;
    private String examName;

    private List<Student> students = new ArrayList<>();


    public Exam() {
    }

    public Exam(long id, String examName, List<Student> students) {
        this.id = id;
        this.examName = examName;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void print() {
        System.out.println("Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", students=" + students +
                '}');
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

}