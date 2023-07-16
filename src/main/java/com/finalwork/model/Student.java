package com.finalwork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idStudent;

    @Column(nullable = false, length = 150)
    @EqualsAndHashCode.Include
    private String firstName;

    @Column(nullable = false, length = 150)
    @EqualsAndHashCode.Include
    private String lastName;

    @Column(nullable = false, length = 50, unique = true)
    @EqualsAndHashCode.Include
    private String dni;

    @Column(nullable = true)
    private LocalDate birthDate;

    @Column(length = 12, nullable = true)
    private String phone;

    @Column(nullable = true)
    private String email;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Boolean status;

    public Student(Integer idStudent, String firstName, String lastName, String email) {
        this.idStudent = idStudent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(Integer idStudent, LocalDate birthDate, String email) {
        this.idStudent = idStudent;
        this.birthDate = birthDate;
        this.email = email;
    }

}
