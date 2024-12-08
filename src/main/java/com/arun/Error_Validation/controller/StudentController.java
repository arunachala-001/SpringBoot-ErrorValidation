package com.arun.Error_Validation.controller;

import com.arun.Error_Validation.exception.StudentNotfoundException;
import com.arun.Error_Validation.model.Student;
import com.arun.Error_Validation.request.StudentRequest;
import com.arun.Error_Validation.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> storeStudent(@RequestBody @Valid StudentRequest request) {
        studentService.saveStudent(request);
        return ResponseEntity.ok("Record created Successfully");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.fetchAllDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) throws StudentNotfoundException {
        return ResponseEntity.ok(studentService.findByStudentId(id));
    }
}
