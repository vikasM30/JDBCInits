package com.jdbctest.service;

import com.jdbctest.dao.StudentDAO;
import com.jdbctest.dao.StudentDAOImpl;
import com.jdbctest.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO = new StudentDAOImpl();

    public void create(Student student){
        studentDAO.createStudent(student);
    }

    public void update(Student student){
        studentDAO.updateStudent(student);
    }

    public Student get(int id){
        return studentDAO.findStudentById(id);
    }

    public List<Student> getAll(){
        return studentDAO.findAllStudent();
    }

    public void delete(int id){
        studentDAO.deleteStudent(id);
    }
}
