package com.finalwork.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min= 3, max = 90)
    private String nameCourse;

    @NotNull
    @NotEmpty
    @Size(min= 3, max = 30)
    private String initialsCourse;

    @NotNull
    private Boolean statusCourse;
}
