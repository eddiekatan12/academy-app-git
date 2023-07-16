package com.finalwork.controller;

import com.finalwork.dto.StudentDTO;
import com.finalwork.model.Student;
import com.finalwork.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    //@Autowired
    private final IStudentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    /*@GetMapping
    public ResponseEntity<List<StudentDTO>> reaAll() throws Exception{
        /*ModelMapper mapper = new ModelMapper();
        List<StudentDTO> list = service.readAll().stream().map(e -> mapper.map(e, StudentDTO.class)).toList();*/
/*
        List<StudentDTO> list = service.readAll().stream().map(e->{
            StudentDTO dto = new StudentDTO();
            dto.setIdStudent(e.getIdStudent());
            dto.setFirstNameStudent(e.getFirstName());
            dto.setLastNameStudent(e.getLastName());
            dto.setDniStudent(e.getDni());
            dto.setPhoneStudent(e.getPhone());
            dto.setBirthDateStudent(e.getBirthDate());
            dto.setEmailStudent(e.getEmail());
            dto.setStatusStudent(e.getStatus());
            return dto;
        }).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.detele(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/


    @GetMapping
    public ResponseEntity<List<StudentDTO>> reaAll() throws Exception{
        //ModelMapper mapper = new ModelMapper();
        List<StudentDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        StudentDTO dto = this.convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody @Valid StudentDTO dto)throws Exception{
        Student object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(object), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestBody @Valid StudentDTO dto)throws Exception{
        dto.setIdStudent(id);
        Student object = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception{
        service.detele(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/student/information")
    public ResponseEntity<List<StudentDTO>>findByFirstNameAndStatus(@RequestParam("firstname") String firstName, @RequestParam("status") Boolean status){
        List<StudentDTO> list = service.findByFirstNameAndStatus(firstName, status).stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/get/student/partialinformation")
    public ResponseEntity<List<StudentDTO>>findByFirstName(){
        List<StudentDTO> list = service.findByFirstName().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/findstudent/likename/{lastname}")
    public ResponseEntity<List<StudentDTO>>findByLastNameContains(@PathVariable("lastname") String lastName){
        List<StudentDTO> list = service.findByLastNameContains(lastName).stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/findstudent/likedni/{dni}")
    public ResponseEntity<StudentDTO> findByOneDNI(@PathVariable("dni") String dni)throws Exception{
        StudentDTO dto = this.convertToDTO(service.findOneByDni(dni));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/findstudent1/ageorderby")
    public ResponseEntity<List<StudentDTO>>findByFirstName2() throws Exception{
        List<StudentDTO> list = service.findByFirstName2().stream().map(this::convertToDTO)
                .sorted(Comparator.comparing(StudentDTO::getBirthDateStudent))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findstudent2/orderbyage")
    public ResponseEntity<List<StudentDTO>> reaAllOrder() throws Exception{
        List<StudentDTO> list = service.readAll().stream().map(this::convertToDTO)
                .sorted(Comparator.comparing(StudentDTO::getBirthDateStudent))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    private StudentDTO convertToDTO (Student object){
        return mapper.map(object, StudentDTO.class);
    }

    private Student convertToEntity (StudentDTO dto){
        return mapper.map(dto, Student.class);
    }
}
