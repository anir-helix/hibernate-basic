package com.anir.hbm.crudops;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anir.hbm.crudops.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		// Use Session object to save and get java object
		try {
			/* ========== Create Operation ========== */
			Student stud1 = UpdateStudent.createStudent(session);
			// get Current Session
			session = factory.getCurrentSession();
			Student stud2 = UpdateStudent.createStudent(session);

			// get Current Session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Get the data for saved student
			Student savedStud1 = UpdateStudent.getStudent(session, stud1);
			Student savedStud2 = UpdateStudent.getStudent(session, stud2);

			/* ========== DELETE operation ========== */

			// commit prev transaction
			session.getTransaction().commit();

			// delete Student By Session Delete()
			deleteStudentBySessionDelete(factory, savedStud1);

			// Delete Student By using Session query with Query Object
			deleteStudentBySessionQuery(factory, savedStud2);
			
			//Delete Student By Custom Query For Email Alike
			deleteStudentByCustomQueryForEmailAlike(factory, "java.com");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}
	
	
	/**
	 * delete Student By using Session Delete()
	 * 
	 * @param savedStud1
	 * @param factory
	 * @param session
	 * @param stud1
	 */
	public static void deleteStudentBySessionDelete(final SessionFactory factory, final Student savedStud1) {

		// open a new session for DELETE
		System.out.println("\n\n deleteStudentBySessionDelete: Student to be DELETE: id= " + savedStud1.getId());
		Session sessionDel = factory.getCurrentSession();
		System.out.println("\n\ndeleteStudentBySessionDelete: Start a new transaction for DELETE");
		sessionDel.beginTransaction();

		// Delete the object data via session delete()
		// ======================================================================
		sessionDel.delete(savedStud1);

		System.out.println("Check for the deleted Student-");
		if (UpdateStudent.getStudent(sessionDel, savedStud1) != null) {
			System.out.println("\n\n Student Not Deleted!! \n");
		} else {
			System.out.println("\n \n Student Deleted. \n");
		}

		// ======================================================================

		// commit transaction
		sessionDel.getTransaction().commit();
	}
	

	/**
	 * Delete Student By Session Query In this section executeUpdate will enact
	 * as update and delete function in a generic way
	 * 
	 * @param factory
	 * @param savedStud2
	 */
	public static void deleteStudentBySessionQuery(final SessionFactory factory, final Student savedStud2) {
		// open a new session for DELETE
		System.out.println("\n\ndeleteStudentBySessionQuery: Student to be DELETE: id= " + savedStud2.getId());
		Session sessionDel = factory.getCurrentSession();
		System.out.println("\n\ndeleteStudentBySessionQuery: Start a new transaction for DELETE");
		sessionDel.beginTransaction();

		// ======================================================================
		
		// Delete the object data via session query
		sessionDel.createQuery("delete from Student where id=" + Integer.toString(savedStud2.getId())).executeUpdate();
		
		// ======================================================================

		System.out.println("deleteStudentBySessionQuery: Check for the deleted Student-");
		if (UpdateStudent.getStudent(sessionDel, savedStud2) != null) {
			System.out.println("\n\n deleteStudentBySessionQuery: Student Not Deleted!! \n");
		} else {
			System.out.println("\n \n deleteStudentBySessionQuery: Student Deleted. \n");
		}

		// commit transaction
		sessionDel.getTransaction().commit();
	}


	/**
	 * Delete Student By Session Query For Email alike In this section executeUpdate will enact
	 * as update and delete function in a generic way
	 * 
	 * @param factory
	 * @param savedStud2
	 */
	public static void deleteStudentByCustomQueryForEmailAlike(final SessionFactory factory, final String emailALike) {
		System.out.println("\n\n deleteStudentByCustomQueryForEmailAlike: Student to be DELETE: email alike: " + emailALike);
		Session sessionDel = factory.getCurrentSession();
		System.out.println("\n\n deleteStudentByCustomQueryForEmailAlike: Start a new transaction for DELETE");
		sessionDel.beginTransaction();

		// ======================================================================
		
		// Delete the object data via session query
		sessionDel.createQuery("delete from Student s where s.email LIKE '%" + emailALike + "'").executeUpdate();
		
		// ======================================================================

		// commit transaction
		sessionDel.getTransaction().commit();
	}


}
