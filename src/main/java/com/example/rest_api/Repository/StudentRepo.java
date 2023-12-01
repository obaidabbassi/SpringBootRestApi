package com.example.rest_api.Repository;

import com.example.rest_api.Entities.Student;
import com.example.rest_api.controller.Student_Controller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
