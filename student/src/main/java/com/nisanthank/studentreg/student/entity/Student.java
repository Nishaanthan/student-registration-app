package com.nisanthank.studentreg.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigInteger;

@Entity
@IdClass(studentid.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Student {
    @Id
    @GeneratedValue
    private BigInteger studentid;
    @Id
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

