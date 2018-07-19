package com.anir.hbm.crudops.handler.queryingobject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anir.hbm.crudops.entity.Student;

public class QueryingObjectHandler {

	private SessionFactory factory;

	/**
	 * 
	 * @param factory
	 */
	public QueryingObjectHandler(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * GET All student Data
	 * 
	 */
	public void getAllStudents() {
		/* ========== GET All operation ========== */

		// Create a New Session
		Session session = factory.getCurrentSession();
		// Start a transaction
		System.out.println("Start a new transaction for GET All Students");
		session.beginTransaction();

		// Retrieve student based on id: primary key
		@SuppressWarnings("unchecked")
		List<Student> savedStuds = session.createQuery("from Student").getResultList();

		// Display the Students details
		displayStudents(savedStuds);

		// commit transaction
		session.getTransaction().commit();
	}

	/**
	 * GET a student Data based on the Last name Using WHERE Clause
	 * 
	 * @param lastName
	 */
	public void getStudentsBaseOnLastName(String lastName) {
		/* ========== GET All operation ========== */

		// Create a New Session
		Session session = factory.getCurrentSession();
		// Start a transaction
		System.out.println("Start a new transaction for GET Students by Last Name");
		session.beginTransaction();

		// Retrieve student based on id: primary key
		List<Student> savedStuds = session.createQuery("from Student s where s.lastName='" + lastName + "'")
				.getResultList();

		// Display the Students details
		displayStudents(savedStuds);

		// commit transaction
		session.getTransaction().commit();
	}

	/**
	 * GET a student Data based on the email a like Using LIKE Clause
	 * 
	 * @param emailALike
	 */
	public void getStudentsAlikeEmail(String emailALike) {
		/* ========== GET All operation ========== */

		// Create a New Session
		Session session = factory.getCurrentSession();
		// Start a transaction
		System.out.println("Start a new transaction for GET Students by Email ALIKE");
		session.beginTransaction();

		// Retrieve student based on id: primary key
		List<Student> getStuds = session.createQuery("from Student s where s.email LIKE '%" + emailALike + "'")
				.getResultList();

		// Display the Students details
		displayStudents(getStuds);

		// commit transaction
		session.getTransaction().commit();
	}
	
	/**
	 * GET a student Data based on the DOB value Using not operator Clause
	 * 
	 */
	public void getStudentsWithDOB() {
		/* ========== GET All operation ========== */

		// Create a New Session
		Session session = factory.getCurrentSession();
		// Start a transaction
		System.out.println("Start a new transaction for GET Students by DOB");
		session.beginTransaction();

		// Retrieve student based on id: primary key
		List<Student> getStuds = session.createQuery("from Student s where s.dateOfBirth <> '' ")
				.getResultList();

		// Display the Students details
		displayStudents(getStuds);

		// commit transaction
		session.getTransaction().commit();
	}

	/**
	 * @param savedStuds
	 */
	private void displayStudents(List<Student> savedStuds) {
		System.out.println("\n displayStudents:");
		if (savedStuds.size() > 0) {
			for (Student stud : savedStuds) {
				System.out.println("Saved Student Details: " + stud + "\n");
			}
		} else {
			System.out.println("No Student Details Available!! \n");
		}
	}

}
