package com.startbuild.microservice.buildservice.controllers;

import com.startbuild.microservice.buildservice.entities.Student;
import com.startbuild.microservice.buildservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/data")
    public List<Student> studentsData(){
        return studentService.getStudentsData();
    }

    @GetMapping("/data/{id}")
    public Student studentsDataById(@PathVariable int id){
        return studentService.getStudentDataById(id);
    }

    @PostMapping("/add/data")
    public List<Student> addStudent(@RequestBody Student student){

        List<Student> s = studentService.addStudentData(student);
        return s;
    }

    @DeleteMapping("/delete/data")
    public List<Student> deleteStudent(@RequestParam int id){

        List<Student> s = studentService.deleteStudentByID(id);
        return s;
    }

    @PutMapping("/update/data")
    public List<Student> updateStudent(@RequestBody Student student, @RequestParam int id){

        List<Student> s = studentService.updateStudentByID(student,id);
        return s;
    }

    @GetMapping("/handle/data")
    public ResponseEntity<List<Student>> studentsDataWithResponseHandle(@RequestParam boolean throwError){

        if(throwError)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(studentService.getStudentsData());
    }



}
