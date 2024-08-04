package com.advanced.hibernate.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "student")
public class StudentEntity {

    @NotEmpty(message = "First Name is required field")
    @Column(name = "first_name", unique = true)
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email is required")
    @Column(name = "email", unique = true)
    String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name = "image",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "file_name")
    private Set<String> images = new HashSet<String>();

}


