package com.fortech.trainingapp.service;

import org.springframework.stereotype.Service;

import com.fortech.trainingapp.dao.StudentDAO;
import com.fortech.trainingapp.model.Assignment;

@Service
public class AssignmentServiceImpl  implements AssignmentService{

	private StudentDAO studentDAO;
	
	@Override
	public void addAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
