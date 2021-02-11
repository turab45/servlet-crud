package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {

	public Integer addStudent(Student student);
	public Integer updateStudent(Student student);
	public Integer deleteStudent(int id);
	public Student getStudentById(int id);
	public List<Student> getAllStudent();
}
