package com.finalwork.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {

    private Integer idEnrollmentDetail;

    @JsonIncludeProperties(value = {"idEnrollment"})
    @JsonBackReference
    private EnrollmentDTO enrollment;

    @JsonIncludeProperties(value = {"idCourse"})
    @NotNull
    private CourseDTO course;

    @NotNull
    @Size(min= 3, max = 10)
    private String classroom;

}
