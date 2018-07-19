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
public class UpdateBulkStudent {

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
			
			/* ========== Bulk UPDATE operation ========== */
			
			// Get a New Session for Update Ops
			session = factory.getCurrentSession();

			// Start a transaction
			System.out.println("Start a new transaction for GET");
			session.beginTransaction();


			// Update Email for all Students where email id alike : @java.com

			session.createQuery("update Student s set s.email= 'jhb_spring@java.com' where s.email LIKE '%@java.com'")
					.executeUpdate();

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}
}
