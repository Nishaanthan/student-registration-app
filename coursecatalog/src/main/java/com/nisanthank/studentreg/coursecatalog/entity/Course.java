package com.nisanthank.studentreg.coursecatalog.entity;

import java.math.BigInteger;

public class Course {
    private BigInteger courseid;
    private String coursename;
    private String lecturer;

    public Course(){

    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

}
