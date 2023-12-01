package com.example.rest_api.service;

import com.example.rest_api.Entities.Student;
import com.example.rest_api.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student_Service {

@Autowired
    StudentRepo studentRepo;

    public Student save(Student std){

return studentRepo.save(std);
    }


    public Optional<Student> getStudentById(Long id){
        Optional<Student> byId = studentRepo.findById(id);

return studentRepo.findById(id);
    }



    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    public void UpdateStudentById(Long id ,Student std) {


        Optional<Student> byId = studentRepo.findById(id);

        if (byId.isPresent()){

            Student std1 = byId.get();
            std1.setStdAddress(std.getStdAddress());
            std1.setStdName(std.getStdName());
            std1.setStdGrade(std.getStdGrade());
            std1.setStdEmail(std.getStdEmail());
            std1.setStdAge(std.getStdAge());
            std1.setStdPhone(std.getStdPhone());
            studentRepo.save(std1);
       }

    }


    public List<Student> saveAllStudents(List<Student> students) {
        return studentRepo.saveAll(students);
    }



}