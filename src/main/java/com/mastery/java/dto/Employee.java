package com.mastery.java.dto;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private int department_id;
    private String job_title;
    private String gender;
    private LocalDate date_of_bith;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate_of_bith() {
        return date_of_bith;
    }

    public void setDate_of_bith(LocalDate date_of_bith) {
        this.date_of_bith = date_of_bith;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", department_id=" + department_id +
                ", job_title='" + job_title + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_bith=" + date_of_bith +
                '}';
    }
}
