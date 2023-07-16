package com.finalwork.repo;

import com.finalwork.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IStudentRepo extends IGenericRepo<Student, Integer> {

    @Query("SELECT new Student (s.idStudent, s.firstName, s.lastName, s.email) FROM Student s")
    List<Student> findByFirstName();
    @Query("FROM Student s WHERE s.firstName LIKE %:firstName% AND s.status = :status")
    List<Student> findByFirstNameAndStatus(@Param("firstName") String firstName, @Param("status") Boolean status);
    List<Student> findByLastNameContains(String lastName);
    Student findOneByDni(String dni);

    @Query("SELECT new Student (s.idStudent, s.firstName, s.lastName, s.dni, s.birthDate, s.email, s.phone, s.status) FROM Student s")
    List<Student> findByFirstName2();

}