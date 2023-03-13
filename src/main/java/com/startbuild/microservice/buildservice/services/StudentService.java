package com.startbuild.microservice.buildservice.services;

import com.startbuild.microservice.buildservice.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentService {

    List<Student> data = new ArrayList<>();

    StudentService(){

        data.add(new Student(001, "John", 25, 90));
        data.add(new Student(002, "Reed", 35, 80));
        data.add(new Student(003, "Mike", 45, 70));
        data.add(new Student(004, "Harvey", 55, 60));
    }

    public List<Student> getStudentsData(){
        return data;
    }

    public Student getStudentDataById(int id){

        Student student = null;
        student = data.stream().filter(e->e.getId()==id).findFirst().get();
        return student;
    }

    public List<Student> addStudentData(Student student){

        data.add(student);
        return data;
    }

    public List<Student> deleteStudentByID(int id){

        Student student=null;
        student = data.stream().filter(e->e.getId()==id).findFirst().get();
        data.remove(student);
        return data;
    }

    public List<Student> updateStudentByID(Student student, int id){

        data = data.stream().map(e->{
            if(e.getId()==id)
            {
                e.setAvg_marks(student.getAvg_marks());
                e.setAge(student.getAge());
                e.setName(student.getName());
            }
            return e;
        }).collect(Collectors.toList());

        return data;
    }





}
