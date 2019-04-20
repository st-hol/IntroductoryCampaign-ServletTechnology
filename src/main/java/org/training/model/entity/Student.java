package org.training.model.entity;

import java.util.*;

public class Student {

    private long id;

    private String firstName;
    private String lastName;
    private double rating;

    private List<Exam> exams =  new ArrayList<>();

    private String email;

    private String password;
    private ROLE role;



    public Student() {
    }


    public Student(long id, String email, String password, ROLE role) {
        this.id = id;

        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.rating = -1;

        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Student(long id, String firstName, String lastName, int rating, String email, String password, ROLE role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                //", exams=" + exams +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.rating, rating) == 0 &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(exams, student.exams) &&
                Objects.equals(email, student.email) &&
                Objects.equals(password, student.password) &&
                role == student.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, rating, exams, email, password, role);
    }

    public enum ROLE {
        ADMIN, USER, UNKNOWN;

        public int getRoleID(){
            return ordinal() + 1;
        }

        public static Student.ROLE getRoleById(int id){
            int index = id - 1;
            return values()[index];
        }




    }
}