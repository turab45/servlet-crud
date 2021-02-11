package com.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.*;
import com.dbmanager.DBConnection;
import com.model.Student;
import com.mysql.jdbc.PreparedStatement;

public class StudentDAOImpl implements StudentDAO {

	Connection conn = DBConnection.getConnection();

	@Override
	public Integer addStudent(Student student) {
		int row = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("insert into student(roll,name,contact,email) values(?,?,?,?)");
			
			pstmt.setString(1, student.getRollNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getContact());
			pstmt.setString(4, student.getEmail());
			
			row = pstmt.executeUpdate();
		

		} catch (Exception e) {

			e.printStackTrace();
		}

		return row;
	}

	@Override
	public List<Student> getAllStudent() {
		ResultSet rs = null;
		ArrayList<Student> allStudents = null;
		PreparedStatement pstmt = null;
		try {
			allStudents = new ArrayList<Student>();
			
			pstmt = (PreparedStatement) conn.prepareStatement("select * from student");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setRollNo(rs.getString("roll"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				
				
				allStudents.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allStudents;
	}
	
	public Student getStudentById(int id) {
		Student s = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			
			pstmt = (PreparedStatement) conn.prepareStatement("select * from student where id=?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				s = new Student();
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setRollNo(rs.getString("roll"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	
	public Integer updateStudent(Student student) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("update student set roll=?, name=?, contact=?, email=? where id=?");
			pstmt.setString(1, student.getRollNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getContact());
			pstmt.setString(4, student.getEmail());
			pstmt.setInt(5, student.getId());
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
		
	}
	public Integer deleteStudent(int id) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("delete from student where id=?");
			pstmt.setInt(1, id);
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	

	

	

	

}
