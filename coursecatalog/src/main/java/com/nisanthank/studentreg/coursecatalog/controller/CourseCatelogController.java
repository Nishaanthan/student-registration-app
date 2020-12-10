package com.nisanthank.studentreg.coursecatalog.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nisanthank.studentreg.coursecatalog.entity.Course;
import com.nisanthank.studentreg.coursecatalog.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
public class CourseCatelogController {
    @Autowired
    EurekaClient client;

    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getCatalogHome(){
        String courseAppMessage="";
        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("studentreg-course-app",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppMessage = restTemplate.getForObject(courseAppURL,String.class);
        return("Course Catalog page: " + courseAppMessage);
    }

    public String displayDefaultHome(){
        return("Welcome to Course Catalog "+"please try after some time");
    }

    @GetMapping("/catalog")
    public String getCatalog(){
        String courses = "";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("studentreg-course-app",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/courses";
        RestTemplate  restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(courseAppURL,String.class);
        return ("our courses are " +courses);
    }

    @GetMapping("/{id}")
    public String GetSpecificourse(@PathVariable("id") BigInteger id){
        Course course = new Course();
        Student student = new Student();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("studentreg-course-app",false );
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/" + id;
        RestTemplate  restTemplate = new RestTemplate();
        course = restTemplate.getForObject(courseAppURL,Course.class);
        instanceInfo =client.getNextServerFromEureka("studentreg-student-app",false);
        String studentAppURL = instanceInfo.getHomePageUrl();
        studentAppURL = studentAppURL + "/course/" + course.getCourseid();
        String studentsList = restTemplate.getForObject(studentAppURL,String.class);
        return ("Course id is "+ course.getCourseid() +" and Course name is "+ course.getCoursename() + " and enrolled students are " + studentsList);
    }
}
