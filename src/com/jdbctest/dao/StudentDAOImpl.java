package com.jdbctest.dao;

import com.jdbctest.config.DBConnection;
import com.jdbctest.model.Student;
import com.jdbctest.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void createStudent(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
            try {
                conn = DBConnection.getConnection();
                ps = conn.prepareStatement("INSERT INTO students(name, email, age) VALUES (?, ?, ?)");
                ps.setString(1, student.getName());
                ps.setString(2, student.getEmail());
                ps.setInt(3, student.getAge());
//                ps.setInt(4, student.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DBUtil.close(ps);
                DBUtil.close(conn);
            }
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        return List.of();
    }
}
