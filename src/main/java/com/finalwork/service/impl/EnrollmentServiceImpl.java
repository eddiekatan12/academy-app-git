package com.finalwork.service.impl;

import com.finalwork.model.Course;
import com.finalwork.model.Enrollment;
import com.finalwork.model.EnrollmentDetail;
import com.finalwork.model.Student;
import com.finalwork.repo.IEnrollmentRepo;
import com.finalwork.repo.IGenericRepo;
import com.finalwork.service.CRUDImpl;
import com.finalwork.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService{

    private final IEnrollmentRepo repo;
    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findByFirstName2() {
        return null;
    }

    @Override
    public Map<String, String> findByCourseStudentMap() {

        /*Stream<Enrollment> enrollmentStream = repo.findAll().stream();
        Stream<List<EnrollmentDetail>> enrollmentDetailStream = enrollmentStream.map(Enrollment::setEnrollmentDetails);*/

        Stream<List<EnrollmentDetail>> enrollmentStream = repo.findAll().stream().map(Enrollment::getEnrollmentDetails);

        enrollmentStream.toList().forEach(System.out::println);

        Map<String, String> test = new LinkedHashMap<>();

        test.put("UNO", "Esta es la info de value UNO");
        /*Stream<EnrollmentDetail> detailStream = enrollmentStream.flatMap(Collection::stream);

         Map<String, String> byCourse = detailStream.collect(e-> e.)*/
        return test;
    }

}
