/**
 * 
 */
package com.anir.hbm.crudops;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anir.hbm.crudops.entity.Student;
import com.anir.hbm.crudops.utils.DateUtils;

/**
 * @author OPTLPTP219
 *
 */
public class CreateStudent {

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

		//Use Session object to save java object
		try{
			//create a Student Object
			System.out.println("create a Student Object");
			
			Student stud1 = new Student("Anir", "M", "am@email.com");
			
			//Create another Student with DOB
			String theDateOfBirthStr = "31/12/1989";
			 
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
 
            Student studWithDOB = new Student("Jhon", "Doe", "jhd@email.com", theDateOfBirth);

			//Start a transaction
			System.out.println("Start a transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("save the student object for Student 1");
			session.save(stud1);
			
			//Save the student object for Student with DOB
			System.out.println("save the student object for Student with DOB");
			session.save(studWithDOB);
			
			//Commit the transaction 
			session.getTransaction().commit();
			System.out.println("commit trans done. Success!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}

}
