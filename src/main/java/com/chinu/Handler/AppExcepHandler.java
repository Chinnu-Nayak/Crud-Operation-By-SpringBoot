package com.chinu.Handler;

import com.chinu.Dto.ErrorDto;
import com.chinu.Dto.PostManReponse;
import com.chinu.Exception.CourseServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppExcepHandler {
    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PostManReponse<?> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){

        List<ErrorDto> errorDtos=new ArrayList<>();
       methodArgumentNotValidException.getBindingResult().getFieldErrors()
               .forEach(error -> errorDtos.add(new ErrorDto(error.getDefaultMessage())));
        PostManReponse<?> postManReponse=new PostManReponse<>(HttpStatus.BAD_REQUEST,null);
        postManReponse.setErrorDtos(errorDtos);

       return postManReponse;
    }
    @ExceptionHandler(CourseServiceException.class)
    public PostManReponse<?> handleServiceException(CourseServiceException courseServiceException){
        PostManReponse<?> postManReponse=new PostManReponse(HttpStatus.INTERNAL_SERVER_ERROR,null);
        List<ErrorDto> errorDtos=new ArrayList<>();
        errorDtos.add(new ErrorDto(courseServiceException.getMessage()));
        postManReponse.setErrorDtos(errorDtos);
        return postManReponse;
    }
}
