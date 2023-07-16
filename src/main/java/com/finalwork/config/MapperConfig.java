package com.finalwork.config;

import com.finalwork.dto.EnrollmentDTO;
import com.finalwork.dto.EnrollmentDetailDTO;
import com.finalwork.model.Enrollment;
import com.finalwork.model.EnrollmentDetail;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean("enrollmentMapper")
    public ModelMapper enrollmentMapper(){

        ModelMapper mapper = new ModelMapper();

        TypeMap<EnrollmentDTO, Enrollment> typeMap1 = mapper.createTypeMap(EnrollmentDTO.class, Enrollment.class);
        TypeMap<Enrollment, EnrollmentDTO> typeMap2 = mapper.createTypeMap(Enrollment.class, EnrollmentDTO.class);

        typeMap1.addMapping(EnrollmentDTO::getIdEnrollment, (dest, v)->dest.setIdEnrollment((Integer) v));
        typeMap2.addMapping(Enrollment::getIdEnrollment, (dest, v)-> dest.setIdEnrollment((Integer) v));

        typeMap1.addMapping(EnrollmentDTO::getDatetime, (dest, v)-> dest.setDatetime((LocalDateTime) v));
        typeMap2.addMapping(Enrollment::getDatetime, (dest, v) -> dest.setDatetime((LocalDateTime) v));

        typeMap1.addMapping(e-> e.getStudent().getIdStudent(), (dest, v)->dest.getStudent().setIdStudent((Integer) v));
        typeMap2.addMapping(e-> e.getStudent().getIdStudent(), (dest, v)->dest.getStudent().setIdStudent((Integer) v));

        TypeMap<EnrollmentDetailDTO, EnrollmentDetail> typeMap3 = mapper.createTypeMap(EnrollmentDetailDTO.class, EnrollmentDetail.class);
        TypeMap<EnrollmentDetail, EnrollmentDetailDTO> typeMap4 = mapper.createTypeMap(EnrollmentDetail.class, EnrollmentDetailDTO.class);

        typeMap3.addMapping(e->e.getCourse().getIdCourse(), (dest, v)-> dest.getCourse().setIdCourse((Integer) v));
        typeMap4.addMapping(e->e.getCourse().getIdCourse(), (dest,v)->dest.getCourse().setIdCourse((Integer) v));

        return mapper;
    }
}
