/**
 * 
 */
package com.anir.hbm.crudops;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anir.hbm.crudops.entity.Student;

/**
 * @author OPTLPTP219
 *
 */
public class UpdateStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		// Use Session object to save and get java object
		try {
			/* ========== Create Operation ========== */
			Student stud1 = createStudent(session);

			/* ==========  ========== */
			// Get a New Session for Update Ops
			session = factory.getCurrentSession();
			
			// Start a transaction
			System.out.println("Start a new transaction for GET");
			session.beginTransaction();
			
			
			// Get the data for saved student
			Student savedStud = getStudent(session, stud1);

			
			/* ========== UPDATE operation ========== */

			/*
			 * There's no hard requirement for us to call session.save or
			 * session.update because,
			 * 
			 * this student object is a persistent object that we retrieved from
			 * the database.
			 * 
			 * We can simply call the appropriate setters and then finally do a
			 * commit.
			 * 
			 * And that'll actually update the database.
			 */
			
			
			// Update the object data
			savedStud.setFirstName("JavaEE-Spring");
			savedStud.setLastName("HB_ORM");

			System.out.println("Saved Student Details: " + savedStud);

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}

	/**
	 * GET operation
	 * 
	 * @param factory
	 * @param stud1
	 * @return
	 */
	public static Student getStudent(Session session, Student stud1) {
		System.out.println("Primary key for saved Student: " + stud1.getId());

		// Retrieve student based on id: primary key
		return session.get(Student.class, stud1.getId());
	}

	/**
	 * @param session
	 * @return
	 */
	public static Student createStudent(Session session) {
		System.out.println("create a Student Object");

		Student stud1 = new Student("JavaEE", "HB", "jhb@java.com");

		// Start a transaction
		System.out.println("Start a transaction");
		session.beginTransaction();

		// save the student object
		System.out.println("save the student object");
		session.save(stud1);

		// Commit the transaction
		session.getTransaction().commit();
		System.out.println("commit trans done!");
		return stud1;
	}

}
