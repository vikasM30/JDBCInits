package com.jdbctest.dao;

import com.jdbctest.config.DBConnection;
import com.jdbctest.model.Student;
import com.jdbctest.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
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
                ps.executeUpdate();
                System.out.println("Record has been created");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DBUtil.close(ps);
                DBUtil.close(conn);
            }
    }

    @Override
    public void updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("update students set name=?, email=?, age=? WHERE id=?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setInt(4, student.getId());
            int count = ps.executeUpdate();
            System.out.println("Record has been updated: " + count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }

    @Override
    public void deleteStudent(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("delete from students where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Record has been deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }

    @Override
    public Student findStudentById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setAge(rs.getInt("age"));
                students.add(student);
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }

        return students;
    }
}
