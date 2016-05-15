package com.fortech.trainingapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fortech.trainingapp.model.Assignment;

@Repository
public class AssignmentDAOImpl implements AssignmentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addAssignment(Assignment assignment) {
		// TODO Auto-generated method stub

	}

}
