package com.startbuild.microservice.buildservice.controllers;

import com.startbuild.microservice.buildservice.entities.Student;
import com.startbuild.microservice.buildservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student/response")
public class ResponseHandlerController {

    @Autowired
    StudentService studentService;

    @GetMapping("/handle/data")
    public ResponseEntity<List<Student>> studentsDataWithResponseHandle(@RequestParam boolean throwError){

        if(throwError)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(studentService.getStudentsData());
    }

    @PutMapping("/handle/update/data")
    public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student, @RequestParam int id){

        try{
            List<Student> list = studentService.updateStudentByID(student,id);
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }
}
