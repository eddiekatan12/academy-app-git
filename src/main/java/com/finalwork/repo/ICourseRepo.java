package com.finalwork.repo;

import com.finalwork.model.Course;
import java.util.List;
public interface ICourseRepo extends IGenericRepo<Course, Integer> {

    //Derived Queries
    List<Course>findByName(String name);
    List<Course>findByNameContains(String name);
    //List<Course>findByStatus();
    //Course findOneByName(String name);
    //JPQL


    //Native Queries

}
