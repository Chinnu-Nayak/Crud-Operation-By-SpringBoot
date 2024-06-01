package com.chinu.Util;

import com.chinu.Dto.RequstDto;
import com.chinu.Dto.ResponseDto;
import com.chinu.Entity.Course;

public class AppUtil {
    public static Course dtoToEntity(RequstDto courseRequestDto){
        Course course = new Course();

        course.setName(courseRequestDto.getName());
        course.setTrainerName(courseRequestDto.getTrainerName());
        course.setDuration(courseRequestDto.getDuration());
        course.setStartDate(courseRequestDto.getStartDate());
        course.setCourseType(courseRequestDto.getCourseType());
        course.setFees(courseRequestDto.getFees());
        course.setCertificateAvailable(courseRequestDto.isCertificateAvailable());
        course.setDescription(courseRequestDto.getDescription());
        course.setContact(courseRequestDto.getContact());
        course.setEmail(courseRequestDto.getEmail());

        return course;

    }


    public static ResponseDto entityToDto(Course course){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(course.getId());
        responseDto.setName(course.getName());
        responseDto.setTrainerName(course.getTrainerName());
        responseDto.setDuration(course.getDuration());
        responseDto.setStartDate(course.getStartDate());
        responseDto.setCourseType(course.getCourseType());
        responseDto.setFees(course.getFees());
        responseDto.setCertificateAvailable(course.isCertificateAvailable());
        responseDto.setDescription(course.getDescription());
        responseDto.setContact(course.getContact());
        responseDto.setEmail(course.getEmail());

        return responseDto;

    }
}
