package com.nisanthank.studentreg.student.repository;

import com.nisanthank.studentreg.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, BigInteger> {
    List<Student> findBystudentid(BigInteger id);
    List<Student> findBycourseid(BigInteger id);
}
