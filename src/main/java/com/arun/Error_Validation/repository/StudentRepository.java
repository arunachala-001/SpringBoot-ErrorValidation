package com.arun.Error_Validation.repository;

import com.arun.Error_Validation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
