package com.arun.Error_Validation.service;


import com.arun.Error_Validation.exception.StudentNotfoundException;
import com.arun.Error_Validation.model.Student;
import com.arun.Error_Validation.repository.StudentRepository;
import com.arun.Error_Validation.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    Logger log = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepo;

    public void saveStudent(StudentRequest studentRequest) {
        try{
            Student student = mapToStudent(studentRequest);
            studentRepo.save(student);
        }
        catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public List<Student> fetchAllDetails() {
        return studentRepo.findAll();
    }

    public Student findByStudentId(long id) throws StudentNotfoundException {
        return studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotfoundException("Student not found with ID : " + id));
    }

    private Student mapToStudent(StudentRequest studentRequest) {
       Student student = new Student();
       student.setName(studentRequest.getName());
       student.setEmail(studentRequest.getEmail());
       student.setMobile(studentRequest.getMobile());
       student.setDepartment(studentRequest.getDepartment());
       student.setAge(studentRequest.getAge());
       return student;
    }
}
