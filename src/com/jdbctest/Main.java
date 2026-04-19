package com.jdbctest;

import com.jdbctest.model.Student;
import com.jdbctest.service.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        studentService.create(new Student( "rahuld",  "Rahuld@outlook.com", 33));
    }
}
