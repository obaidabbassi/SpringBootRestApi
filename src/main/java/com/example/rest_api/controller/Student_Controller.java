package com.example.rest_api.controller;


import com.example.rest_api.Entities.Student;
import com.example.rest_api.service.Student_Service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Student_Controller {




    @Autowired
    Student_Service service;
//save single student
    @PostMapping("/api/create")
    public ResponseEntity<String> createStd(@RequestBody Student std) {
        try {

            Student savedStudent = service.save(std);
            // Instead of printing, consider logging to a proper logging framework
            System.out.println("Student created: {}"+savedStudent);
            return ResponseEntity.ok("Student created successfully");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating student: " + e.getMessage());
        }
    }


//find student by id
@GetMapping("/api/find/{id}")
ResponseEntity <String> getStdByid(@PathVariable  Long id){
    Optional<Student> studentOptional = service.getStudentById(id);
    if (studentOptional.isPresent()) {
        // The student with the given ID is found
        Student student = studentOptional.get();
        return ResponseEntity.ok("You found a student with id " + id + ": " + student.toString());
    } else {
        // The student with the given ID is not found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student found with id " + id);
    }
}


//get All students

@GetMapping("/api/getAll")
    ResponseEntity<List<Student>>getAllStudents(){

        List<Student> allStudents = service.getAllStudents();

        return ResponseEntity.ok(allStudents);



    }









// Delete student by id
@DeleteMapping("/del/{id}")
ResponseEntity<String> deleteById(@PathVariable Long id){



    Optional<Student> studentOptional = service.getStudentById(id);

    if (studentOptional.isPresent()) {
        studentOptional.get();
        service.deleteStudentById(id);
        return ResponseEntity.ok("You successfully deleted student with ID " + id);
    } else {
        return ResponseEntity.ok("No student found with ID " + id);
    }


}


//Delete All Students
    @DeleteMapping("/api/delAll")
    ResponseEntity<String>deleteAllStudents(){


        service.deleteAllStudents();

        return ResponseEntity.ok("All students deleted...") ;
    }






//update student by id
@PatchMapping("api/update/{id}")
public ResponseEntity<String> UpdatebyId(@PathVariable long id,@RequestBody Student std){

        service.UpdateStudentById(id,std);


        return ResponseEntity.ok("Updated successfully...");
}



// Bulk creation
    @PostMapping("/api/createAll")
    public ResponseEntity<String> createAllStudents(@RequestBody List<Student> students) {
        List<Student> savedStudents = service.saveAllStudents(students);
        return ResponseEntity.ok("Students Created successfully: " + savedStudents.size());
    }



}
