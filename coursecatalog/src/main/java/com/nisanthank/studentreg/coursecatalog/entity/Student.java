package com.nisanthank.studentreg.coursecatalog.entity;

import java.math.BigInteger;

public class Student {
    private BigInteger studentid;
    private BigInteger courseid;
    private String name;

    public Student(){

    }

    public BigInteger getStudentid() {
        return studentid;
    }

    public void setStudentid(BigInteger studentid) {
        this.studentid = studentid;
    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
