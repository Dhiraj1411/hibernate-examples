package com.advanced.hibernate;

import com.advanced.hibernate.entity.*;
import com.advanced.hibernate.repository.StudentRepo;
import com.advanced.hibernate.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class HibernateApplication {

    StudentRepo studentRepo;
    UserRepo userRepo;

    @Autowired
    public HibernateApplication(StudentRepo studentRepo, UserRepo userRepo) {
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }


    @PostConstruct
    public void populateStudentDatabase() {
        StudentEntity student1 = new StudentEntity().setFirstName("test1").setLastName("test1_last").setEmail("test1@gmail.com").setStatus(Status.ACTIVE);
        StudentEntity student2 = new StudentEntity().setFirstName("test1").setLastName("test1_last").setEmail("test1@gmail.com").setStatus(Status.INACTIVE);


        Set<String> images =  student1.getImages();
        images.add("photo1.jpg");
        images.add("photo2.jpg");
        images.add("photo3.jpg");
        images.add("photo4.jpg");
        images.add("photo5.jpg");

        Set<String> images1 =  student2.getImages();
        images1.add("photo1.jpg");
        images1.add("photo2.jpg");
        images1.add("photo3.jpg");
        images1.add("photo4.jpg");
        images1.add("photo5.jpg");


        student1.setHomeAddress(new AddressEntity("Street","city", "zipcode"));
        student2.setHomeAddress(new AddressEntity("Street","city", "zipcode"));


        studentRepo.save(student1);
        studentRepo.save(student2);



    }

    @PostConstruct
    public void singleTableStrategyInheritance(){
        EngineerEntity entity =  new EngineerEntity("engineer", "lastname", "engineer@gmail.com", "CSE", "12000");
        DocotorEntity docotorEntity = new DocotorEntity("doctor", "lastname", "doctor@gmail.com", "heart", "15000");

        userRepo.save(entity);
        userRepo.save(docotorEntity);
    }

}
