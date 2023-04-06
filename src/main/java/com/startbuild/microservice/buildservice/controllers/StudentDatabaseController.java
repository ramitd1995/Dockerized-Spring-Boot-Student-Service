package com.startbuild.microservice.buildservice.controllers;

import com.startbuild.microservice.buildservice.dao.StudentDao;
import com.startbuild.microservice.buildservice.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/student")
public class StudentDatabaseController {

    @Autowired
    StudentDao studentDao;

    @GetMapping("/data")
    public List<Student> getStudentData(){
        return studentDao.getStudentRecords();
    }

    @GetMapping("/data/{id}")
    public Student getStudentDataById(@PathVariable int id){
        return studentDao.getStudentRecordById(id);
    }

    @PostMapping("/add/data")
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        studentDao.insertData(student);
        return ResponseEntity.ok("Record added successfully : " + student);
    }

    @DeleteMapping("/delete/data")
    public ResponseEntity<String> deleteStudent(@RequestParam int id){

        studentDao.deleteStudentRecordById(id);
        return ResponseEntity.ok("Record deleted successfully for id : " + id);
    }

    @PutMapping("/update/data")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student){

        studentDao.updateStudentRecordById(student);
        return ResponseEntity.ok("Record updated successfully : " + student);
    }

}
