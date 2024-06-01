package com.chinu.Dto;

import com.chinu.Anootation.CourseTypeAnnotation;
import jakarta.validation.constraints.*;


import java.util.Date;

public class RequstDto {
    @NotBlank(message = "Course name is a mandatory field")
    private String name;
    @NotBlank(message = "you must have to give trainer name")
    private String trainerName;
    private String duration;

    private Date startDate;
    @CourseTypeAnnotation(message = "you can give only online or offline")
    private String courseType;
    @Min(value = 1500,message = "course value can't be less than1500")
    @Max(value = 5000,message = "course value can't be more than 5000")
    private double fees;
    private boolean isCertificateAvailable;
    @NotEmpty(message = "please give a short description about your course minimum 20characters")

    private String description;

    public String getName() {
        return name;
    }
    @Pattern(regexp = "^[0-9]{10}$")
    private String contact;
    @Email(message = "give  a valid emailId")
    private String email;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isCertificateAvailable() {
        return isCertificateAvailable;
    }

    public void setCertificateAvailable(boolean certificateAvailable) {
        isCertificateAvailable = certificateAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
