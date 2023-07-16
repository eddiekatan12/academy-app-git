package com.finalwork.service;

import com.finalwork.model.Course;
import com.finalwork.model.Enrollment;
import com.finalwork.model.Student;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer>{

    List<Student> findByFirstName2();

    Map<String, String>findByCourseStudentMap();
}
