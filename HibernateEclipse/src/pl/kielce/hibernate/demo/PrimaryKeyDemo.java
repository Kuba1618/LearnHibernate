package pl.kielce.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
		
		System.out.println("Creating 3 student object ...");
		
		Student student = new Student("Paul","Low","paul.wall@gmail.com");
		Student student2 = new Student("Martin","Fowler","martin.fowler@gmail.com");
		Student student3 = new Student("John","Doe","john.doe@gmail.com");

		session.beginTransaction();
		System.out.println("Saving the students...");
		session.save(student);
		session.save(student2);
		session.save(student3);
		
		//commit transaction()
		session.getTransaction().commit();
		System.out.println("Done !");
		
		}finally {
			factory.close();
		}
	}

}
