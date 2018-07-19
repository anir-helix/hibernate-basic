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
public class CreateStudentsForPrimarykeyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		// Use Session object to save java object
		try {
			// create 3 Student Objects
			System.out.println("creating Student Objects");

			Student stud1 = new Student("Jhon", "Doe", "jd@email.com");
			Student stud2 = new Student("Anirban", "Chak", "ac@email.com");
			Student stud3 = new Student("Anirban", "DC", "adc@email.com");

			// Start a transaction
			System.out.println("Start a transaction");
			session.beginTransaction();

			// save the student object
			System.out.println("save the student objects");
			session.save(stud1);
			session.save(stud2);
			session.save(stud3);

			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("commit trans done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}

}
