package com.advanced.hibernate;

import com.advanced.hibernate.entity.AddressEntity;
import com.advanced.hibernate.entity.StudentEntity;
import com.advanced.hibernate.repository.StudentRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class HibernateApplication {

    StudentRepo studentRepo;

    @Autowired
    public HibernateApplication(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }


    @PostConstruct
    public void populateDatabase() {
        StudentEntity student = new StudentEntity().setFirstName("test1").setLastName("test1_last").setEmail("test1@gmail.com");
        Set<String> images =  student.getImages();
        images.add("photo1.jpg");
        images.add("photo2.jpg");
        images.add("photo3.jpg");
        images.add("photo4.jpg");
        images.add("photo5.jpg");

        AddressEntity homeAddress = new AddressEntity("Street","city", "zipcode");
        student.setHomeAddress(homeAddress);

        studentRepo.save(student);

    }


}
