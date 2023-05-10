package pl.kielce.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
				//start a transaction
				session.beginTransaction();
				
				List<Student> theStudents = session.createQuery("from Student").list();
			
				//display Students
				displayStudents(theStudents);
				
				//query students: lastName='Daniels'
				theStudents = session.createQuery("from Student s where s.lastName='Daniels'").list();
				
				//display Students
				System.out.println("\n\nAll students who have last name od Daniels");
				displayStudents(theStudents);
				
				
				//commit transaction
				session.getTransaction().commit();
				System.out.println("Done !");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
