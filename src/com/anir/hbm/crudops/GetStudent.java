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
public class GetStudent {

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

		//Use Session object to save and get java object
		try{
			/*==========	Create Operation	==========*/
			System.out.println("create a Student Object");
			
			Student stud1 = new Student("Java", "HB", "jhb@java.com");

			//Start a transaction
			System.out.println("Start a transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("save the student object");
			session.save(stud1);
			
			//Commit the transaction 
			session.getTransaction().commit();
			System.out.println("commit trans done!");
			
			/* ==========	GET operation	==========*/
			System.out.println("Primary key for saved Student: "+ stud1.getId());
			
			// Get a New Session
			session = factory.getCurrentSession();
			//Start a transaction
			System.out.println("Start a new transaction for GET");
			session.beginTransaction();
			
			// Retrieve student based on id: primary key
			Student savedStud = session.get(Student.class, stud1.getId());
			
			System.out.println("Saved Student Details: " + savedStud);
			
			//commit transaction
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}

}
