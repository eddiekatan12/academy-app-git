package com.finalwork.service.impl;

import com.finalwork.model.Student;
import com.finalwork.repo.IGenericRepo;
import com.finalwork.repo.IStudentRepo;
import com.finalwork.service.CRUDImpl;
import com.finalwork.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService{

    private final IStudentRepo repo;
    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findByFirstName() {
        return repo.findByFirstName();
    }

    @Override
    public List<Student> findByFirstNameAndStatus(String firstName, Boolean status) {
        return repo.findByFirstNameAndStatus(firstName, status);
    }

    @Override
    public List<Student> findByLastNameContains(String lastName) {
        return repo.findByLastNameContains(lastName);
    }

    @Override
    public Student findOneByDni(String dni) {
        return repo.findOneByDni(dni);
    }

    @Override
    public List<Student> findByFirstName2() {
        List<Student> list = repo.findByFirstName2();
        /*Comparator<Student>byAge = (Student s1, Student s2) -> s1.getBirthDate().compareTo(s2.getBirthDate());
        list.stream().sorted(byAge).forEach(System.out::println);*/
                list.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .collect(Collectors.toList());
//                .forEach(System.out::println);


                ;
        return list;
    }


}
