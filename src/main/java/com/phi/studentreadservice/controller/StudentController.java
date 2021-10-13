package com.phi.studentreadservice.controller;

import com.phi.studentreadservice.dto.Student;
import com.phi.studentreadservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/read/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents(){
     return studentService.getAllStudents();
    }

    @GetMapping("/id/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student=studentService.findStudentById(studentId);
        if(student==null){
            return new  ResponseEntity<>(Optional.ofNullable(student).orElse(null),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        Student student=studentService.findStudentByName(name);

        if(student==null){
            return ResponseEntity.of(Optional.ofNullable(null));
        }
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @GetMapping("/number/{number}")
    public ResponseEntity<Student> getStudentByRegNumber(@PathVariable Long number) {
        Student student=studentService.findStudentByRegNumber(number);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

}
