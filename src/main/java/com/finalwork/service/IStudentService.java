package com.finalwork.service;

import com.finalwork.model.Course;
import com.finalwork.model.Student;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface IStudentService extends ICRUD<Student, Integer>{

    List<Student> findByFirstName();
    List<Student> findByFirstNameAndStatus(String firstName, Boolean status);
    List<Student> findByLastNameContains(String lastName);
    Student findOneByDni(String dni);
    List<Student> findByFirstName2();

}
