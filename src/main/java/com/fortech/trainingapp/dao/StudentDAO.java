package com.fortech.trainingapp.dao;

import java.util.List;

import com.fortech.trainingapp.model.Student;

public interface StudentDAO {

	public void addStudent(Student student);

	public void updateStudent(Student student);

	public List<Student> listStudents();

	public Student getStudentById(int id);

	public void removeStudent(int id);

}
