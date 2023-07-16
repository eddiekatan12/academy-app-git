package com.finalwork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @Column(nullable = false, length = 90, unique = true)
    private String name;

    @Column(nullable = false, length = 30)
    private String initials;

    @Column(nullable = false)
    private Boolean status;
}
