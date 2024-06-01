package com.chinu.Dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class PostManReponse<T> {
    private HttpStatus status;
    private T response;



    public List<ErrorDto> getErrorDtos() {
        return errorDtos;
    }

    public PostManReponse(HttpStatus status, T response) {
        this.status = status;
        this.response = response;

    }

    public void setErrorDtos(List<ErrorDto> errorDtos) {
        this.errorDtos = errorDtos;
    }

    private List<ErrorDto> errorDtos;
    public HttpStatus getStatus() {
        return status;
    }



    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
