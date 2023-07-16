package com.finalwork.controller;


import com.finalwork.dto.CourseDTO;
import com.finalwork.service.ICourseService;
import com.finalwork.model.Course;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> reaAll() throws Exception{
        //ModelMapper mapper = new ModelMapper();
        List<CourseDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") Integer id) throws Exception{
        CourseDTO dto = this.convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody @Valid CourseDTO dto)throws Exception{
        Course object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(object), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id, @RequestBody @Valid CourseDTO dto)throws Exception{
        dto.setIdCourse(id);
        Course object = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception{
        service.detele(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<CourseDTO>>findByName(@PathVariable("name") String name){
        List<CourseDTO> list = service.findByName(name).stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/findlike/name/{name}")
    public ResponseEntity<List<CourseDTO>>findByNameLike(@PathVariable("name") String name){
        List<CourseDTO> list = service.findByNameContains(name).stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    private CourseDTO convertToDTO (Course object){
        return mapper.map(object, CourseDTO.class);
    }

    private Course convertToEntity (CourseDTO dto){
        return mapper.map(dto, Course.class);
    }
}
