package com.nisanthank.studentreg.student.controller;

import com.nisanthank.studentreg.student.entity.Student;
import com.nisanthank.studentreg.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String getHomePage(){
        return " Students page working";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Student> getStudent(@PathVariable("id") BigInteger id){
        return studentRepository.findBystudentid(id);
    }

    @PostMapping("/")
    public void saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/")
    public void deleteStudent(@PathVariable BigInteger id){
        studentRepository.deleteById(id);
    }

    @PutMapping("/")
    public void updateStudent(@RequestBody Student student){
        Student existingStudent = studentRepository.findById(student.getCourseid()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setCourseid(student.getCourseid());
        studentRepository.save(existingStudent);
    }

    @GetMapping("/course/{id}")
    public List<Student> getStudentsForACourse(@PathVariable("id") BigInteger id){
        return studentRepository.findBycourseid(id);
    }
}
