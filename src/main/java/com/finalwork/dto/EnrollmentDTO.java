package com.finalwork.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {

    private Integer idEnrollment;

    @FutureOrPresent(message="the registration date must be present or future")
    private LocalDateTime datetime;

    @JsonIncludeProperties(value = {"idStudent"})
    @NotNull
    private StudentDTO student;

    @NotNull
    private Boolean status;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;
}
