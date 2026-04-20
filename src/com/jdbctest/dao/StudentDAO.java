package com.jdbctest.dao;

import com.jdbctest.model.Student;

import java.util.List;

public interface StudentDAO {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    Student findStudentById(int id);
    List<Student> findAllStudent();
}
