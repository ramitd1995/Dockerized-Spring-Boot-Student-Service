package com.startbuild.microservice.buildservice.entities;

import lombok.Data;

@Data
public class Student {

    int id;
    String name;
    int age;
    int avg_marks;

    public Student() {

    }

    public Student(int id, String name, int age, int avg_marks){

        this.id = id;
        this.name = name;
        this.age = age;
        this.avg_marks = avg_marks;
    }
}
