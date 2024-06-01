package com.chinu.Controller;

import com.chinu.Dto.PostManReponse;
import com.chinu.Dto.RequstDto;
import com.chinu.Dto.ResponseDto;
import com.chinu.Exception.CourseServiceException;
import com.chinu.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public PostManReponse<ResponseDto> addCource(@Valid @RequestBody RequstDto courseRequestDto)throws CourseServiceException{
        ResponseDto responseDto = courseService.addCourse(courseRequestDto);
        return new PostManReponse<>(HttpStatus.CREATED,responseDto);
    }
    @GetMapping
    public  PostManReponse<List<ResponseDto>> getCourse()throws CourseServiceException{
        List<ResponseDto> allCources = courseService.getAllCource();
        return new PostManReponse<>(HttpStatus.OK,allCources);

    }
    @DeleteMapping("/search/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id)throws CourseServiceException{
        courseService.deleteByid(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public PostManReponse<?> getById(@PathVariable Integer id) throws CourseServiceException {
        ResponseDto byId = courseService.getCourseById(id);
        if(byId !=null){
            return new PostManReponse<>(HttpStatus.OK,byId);

        }
        return new PostManReponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"your id is not present in database");

    }

    @PutMapping("/{id}")
    public PostManReponse<ResponseDto>update(@PathVariable int id,@RequestBody @Valid RequstDto requstDto)throws CourseServiceException{
        ResponseDto update = courseService.update(id, requstDto);
        
        return new PostManReponse<>(HttpStatus.CREATED,update);
    }


}
