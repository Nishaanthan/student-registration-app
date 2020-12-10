package com.nisanthank.course.controller;

import com.nisanthank.course.entity.Course;
import com.nisanthank.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String getHomePage(){
        return " Course page is working";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id") BigInteger id){
        return courseRepository.getOne(id);
    }

    @PostMapping("/")
    public void saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @DeleteMapping("/")
    public void deleteCourse(@PathVariable BigInteger id){
        courseRepository.deleteById(id);
    }

    @PutMapping("/")
    public void updateCourse(@RequestBody Course course){
        Course existingCourse = courseRepository.findById(course.getCourseid()).orElse(null);
        existingCourse.setCoursename(course.getCoursename());
        existingCourse.setLecturer(course.getLecturer());
        courseRepository.save(existingCourse);
    }
}
