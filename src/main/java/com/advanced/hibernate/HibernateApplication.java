package com.advanced.hibernate;

import com.advanced.hibernate.entity.StudentEntity;
import com.advanced.hibernate.repository.StudentRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class HibernateApplication {


    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }


    @PostConstruct
    public void populateDatabase() {
        System.out.println("Post construct executing");
        StudentEntity student = new StudentEntity().setEmail("test1@gmail.com").setFirstName("test1").setLastName("test1_last");
        Set<String> images =  student.getImages();
        images.add("photo1.jpg");
        images.add("photo2.jpg");
        images.add("photo3.jpg");
        images.add("photo4.jpg");
        images.add("photo5.jpg");



    }


}
