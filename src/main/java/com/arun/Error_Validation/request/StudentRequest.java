package com.arun.Error_Validation.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class StudentRequest {

    @NotNull(message = "Name shouldn't be null")
    private String name;

    @Email(message = "Invalid Email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Enter a valid Mobile number")
    private String mobile;

    @NotBlank
    private String department;

    @Min(18)
    @Max(45)
    private int age;

    public StudentRequest() {}

    public StudentRequest(String name, String email, String mobile, String department, int age) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.department = department;
        this.age = age;
    }

    public @NotNull(message = "Name shouldn't be null") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name shouldn't be null") String name) {
        this.name = name;
    }

    public @Email(message = "Invalid Email address") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid Email address") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^\\d{10}$", message = "Enter a valid Mobile number") String getMobile() {
        return mobile;
    }

    public void setMobile(@Pattern(regexp = "^\\d{10}$", message = "Enter a valid Mobile number") String mobile) {
        this.mobile = mobile;
    }

    public @NotBlank String getDepartment() {
        return department;
    }

    public void setDepartment(@NotBlank String department) {
        this.department = department;
    }

    @Min(18)
    @Max(45)
    public int getAge() {
        return age;
    }

    public void setAge(@Min(18) @Max(45) int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }
}
