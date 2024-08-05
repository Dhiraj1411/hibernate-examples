package com.advanced.hibernate.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.Accessors;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotEmpty(message = "First Name is required field")
    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email is required")
    @Column(name = "email")
    String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    /*
        @ElementCollection: The Data for the collection stored in a separate table.
        @CollectionTable: Here refer the table name and provide the join column attribute

     */
    @ElementCollection
    @CollectionTable(
            name = "image",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "file_name")
    private Set<String> images = new HashSet<String>();

    @Embedded // This annotation is optional even if we don't give it will be there for @Embeddable objects
    private AddressEntity homeAddress;

}


