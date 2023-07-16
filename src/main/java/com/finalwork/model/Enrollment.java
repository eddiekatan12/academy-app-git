package com.finalwork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Enrollment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollment;

    @Column(nullable = false, name = "registration_Date")
    private LocalDateTime datetime;

    @ManyToOne
    @JoinColumn(name="id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLL_STUDENT"))
    private Student student;

    @Column(nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "enrollment",cascade = CascadeType.ALL)
    private List<EnrollmentDetail> enrollmentDetails;

}
