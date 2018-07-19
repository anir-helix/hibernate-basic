/**
 * 
 */
package com.anir.hbm.crudops;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anir.hbm.crudops.entity.Student;
import com.anir.hbm.crudops.handler.queryingobject.QueryingObjectHandler;

/**
 * @author OPTLPTP219
 *
 */
public class HBQueryingStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();


		//Use Hibernate Querying object get java objects
		try{
			 QueryingObjectHandler queryingObjectHandler = new QueryingObjectHandler(factory);
			 
			 //GET All student Data
			 queryingObjectHandler.getAllStudents();
			 
			 //GET a student Data based on the Last name
			//Using WHERE Clause
			 queryingObjectHandler.getStudentsBaseOnLastName("DC");
			 
			 // GET a student Data based on the email a like
			 // Using LIKE Clause
			 System.out.println("\n\n should return data");
			 queryingObjectHandler.getStudentsAlikeEmail("@email.com"); // should return data
			 
			 System.out.println("\n\n should return one data");
			 queryingObjectHandler.getStudentsAlikeEmail("@java.com"); // should return one data
			 
			 System.out.println("\n\n should not return any data");
			 queryingObjectHandler.getStudentsAlikeEmail("@gmail.com"); // should not return any data
			 
			 System.out.println("\n\n should return any data with DOB");
			 queryingObjectHandler.getStudentsWithDOB();	//should return any data with DOB
			 
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
			System.out.println("finally block, factory closed!");
		}

	}

}
