package com.finalwork.service;

import com.finalwork.model.Course;

import java.util.List;

public interface ICourseService extends ICRUD<Course, Integer>{

    List<Course> findByName(String name);

    List<Course> findByNameContains(String name);

    /*Course save(Course course) throws Exception;
    Course update(Course course) throws Exception;
    List<Course> readAll() throws Exception;
    Course readById(Integer id) throws Exception;
    void detele(Integer id) throws Exception;*/



}
