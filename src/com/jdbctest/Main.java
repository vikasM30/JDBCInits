package com.jdbctest;

import com.jdbctest.model.Student;
import com.jdbctest.service.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        // create
//        studentService.create(new Student( "ravid",  "Ravis@outlook.com", 33));

        // update
//        studentService.update(new Student(1, "Vikas Mishra", "vikas@gmail.com", 31));

        // get student by id
//        System.out.println(studentService.get(1));

        // get all students
        studentService.getAll().forEach(System.out::println);

        // delete
        studentService.delete(7);
    }
}
