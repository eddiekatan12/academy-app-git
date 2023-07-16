package com.finalwork.service.impl;

import com.finalwork.model.Course;
import com.finalwork.repo.ICourseRepo;
import com.finalwork.repo.IGenericRepo;
import com.finalwork.service.CRUDImpl;
import com.finalwork.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService{

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Course> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Course> findByNameContains(String name) {
        return repo.findByNameContains(name);
    }


}
