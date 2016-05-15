package com.fortech.trainingapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fortech.trainingapp.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);

	}

	@Override
	public void updateStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);

	}

	@Override
	public List<Student> listStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentsList = session.createQuery("from Student").list();

		return studentsList;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student = (Student) session.load(Student.class, new Integer(id));

		return student;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student = (Student) session.load(Student.class, new Integer(id));
		if (null != student) {
			session.delete(student);
		}

	}

}
