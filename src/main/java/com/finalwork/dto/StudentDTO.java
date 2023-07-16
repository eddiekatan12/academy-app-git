package com.finalwork.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @Size(min= 3, max = 150)
    private String firstNameStudent;

    @NotNull
    @Size(min= 3, max = 150)
    private String lastNameStudent;

    @NotNull(message = "DNI Student is obligatory")
    @Size(min= 5, max = 150)
    private String dniStudent;

    @Past(message="the date of birth must be in the past")
    private LocalDate birthDateStudent;

    @Size(max = 12, message = "phone number should not be longger than 12 characters")
    @Pattern(regexp="[0-9]*",message = "the phone number should only contain numbers")
    private String phoneStudent;

    @Email(message = "Email should be valid")
    private String emailStudent;

    @NotNull
    private Boolean statusStudent;


}
