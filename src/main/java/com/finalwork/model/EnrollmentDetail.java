package com.finalwork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class EnrollmentDetail {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollmentDetail;

    @Column(length = 50, nullable = false)
    private String classroom;

    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLDETAIL_ENROLL"))
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name="id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLDETAIL_COURSE"))
    private Course course;

}
