package com.phi.studentreadservice.service;

import com.phi.studentreadservice.dto.Student;
import com.phi.studentreadservice.dto.StudentList;
import com.phi.studentreadservice.dto.StudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String baseUrl="http://STUDENT-REPO-SERVICE/api/v1/student";


    public List<Student> getAllStudents(){
        return restTemplate.getForObject(baseUrl, StudentList.class).getStudentList();
    }

    public Student findStudentById(Long studentId){
          StudentResponseDto responseDto=restTemplate.getForObject(baseUrl+"/id/"+studentId, StudentResponseDto.class);
          return responseDto.getStudent();
    }


    public Student findStudentByName(String name){
        StudentResponseDto responseDto=restTemplate.getForObject(baseUrl+"/name/"+name, StudentResponseDto.class);
        return responseDto.getStudent();
    }

    public Student findStudentByRegNumber(Long number){
        StudentResponseDto responseDto=restTemplate.getForObject(baseUrl+"/number/"+number, StudentResponseDto.class);
        return responseDto.getStudent();
    }
}
