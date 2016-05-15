package com.fortech.trainingapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.trainingapp.dao.StudentDAO;
import com.fortech.trainingapp.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		this.studentDAO.addStudent(student);

	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		this.studentDAO.updateStudent(student);

	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		this.studentDAO.removeStudent(id);

	}

}
