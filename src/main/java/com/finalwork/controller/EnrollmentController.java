package com.finalwork.controller;


import com.finalwork.dto.EnrollmentDTO;
import com.finalwork.model.Enrollment;
import com.finalwork.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    @Qualifier("enrollmentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> reaAll() throws Exception{
    List<EnrollmentDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        EnrollmentDTO dto = this.convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@Valid @RequestBody EnrollmentDTO dto)throws Exception{
        Enrollment object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(object), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable("id") Integer id, @RequestBody @Valid EnrollmentDTO dto)throws Exception{
        dto.setIdEnrollment(id);
        Enrollment object = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception{
        service.detele(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/enrollmentreport")
    public ResponseEntity<Map<String, String>> reaAllRepo() throws Exception{
        Map<String, String> byUser = service.findByCourseStudentMap();
        return new ResponseEntity<>(byUser, HttpStatus.OK);
    }
    private EnrollmentDTO convertToDTO (Enrollment object){
        return mapper.map(object, EnrollmentDTO.class);
    }
    private Enrollment convertToEntity (EnrollmentDTO dto){
        return mapper.map(dto, Enrollment.class);
    }

}
