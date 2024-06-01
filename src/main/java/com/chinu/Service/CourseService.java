package com.chinu.Service;

import com.chinu.Dto.RequstDto;
import com.chinu.Dto.ResponseDto;
import com.chinu.Entity.Course;
import com.chinu.Exception.CourseServiceException;
import com.chinu.Repo.CourseRepo;
import com.chinu.Util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo userRepo;

    public ResponseDto addCourse(RequstDto requstDto) throws CourseServiceException {


        Course course = AppUtil.dtoToEntity(requstDto);
        Course save=null;
        try {
            save= userRepo.save(course);
            ResponseDto courseResponseDto = AppUtil.entityToDto(save);

            return courseResponseDto;

        }
        catch (Exception e){
            throw new CourseServiceException("add Course mehod is not working");
        }



    }

    public List<ResponseDto> getAllCource() throws CourseServiceException {
        List<Course> all=null;
        try {


            all = userRepo.findAll();
            List<ResponseDto> a = new ArrayList<>();
            for (Course x : all) {
                a.add(AppUtil.entityToDto(x));
            }
            return a;
        }
        catch (Exception e){
            throw new CourseServiceException("get all Course mehod is not working");
        }

    }

    public ResponseDto getCourseById(int id) throws CourseServiceException {
        try {


            Course course = userRepo.findById(id).orElseThrow(() -> new CourseServiceException(id + " " + " doesn't exist"));
            return AppUtil.entityToDto(course);
        }
        catch (Exception e){
            throw new CourseServiceException("get  Course by  id mehod is not working");
        }

    }

    public void deleteByid(int id)throws CourseServiceException{
        try {
            userRepo.deleteById(id);

        }
        catch (Exception e){
            throw new CourseServiceException("delete Course mehod is not working");
        }

    }

    public ResponseDto update(int id,RequstDto requstDto) throws CourseServiceException {
        Course course = null;
        try {
            course = userRepo.findById(id).orElse(null);

            if (course != null) {
                course.setName(requstDto.getName());
                course.setTrainerName(requstDto.getTrainerName());
                course.setDuration(requstDto.getDuration());
                course.setCourseType(requstDto.getCourseType());
                course.setTrainerName(requstDto.getTrainerName());
                course.setFees(requstDto.getFees());
                course.setDescription(requstDto.getDescription());
                course.setCertificateAvailable(requstDto.isCertificateAvailable());
                course.setContact(requstDto.getContact());
                course.setEmail(requstDto.getEmail());
                Course save = userRepo.save(course);
                return AppUtil.entityToDto(save);
            }
            else
                return null;
        }
        catch (Exception e){
            throw new CourseServiceException("update course  method is not working");
        }


    }
}
