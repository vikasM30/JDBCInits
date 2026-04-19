package com.jdbctest.service;

import com.jdbctest.dao.StudentDAO;
import com.jdbctest.dao.StudentDAOImpl;
import com.jdbctest.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentService {
    StudentDAO studentDAO = new StudentDAOImpl();

    public void create(Student student){
        studentDAO.createStudent(student);
    }
}
