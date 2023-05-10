package pl.kielce.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.hibernate.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object ...");
			Student student = new Student("Paul","Wall","paul.wall@gmail.com");
			
			session.beginTransaction();
			System.out.println("Saving the student...");
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Done !");
		
		}finally {
			factory.close();
		}
	}

}
