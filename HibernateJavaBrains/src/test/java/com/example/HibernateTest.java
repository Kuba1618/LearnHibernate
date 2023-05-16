package com.example;

import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.javafaker.Faker;

public class HibernateTest {

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("pl-PL"));
		
		UserDetails user = new UserDetails();
		user.setUserName(faker.artist().name());
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.persist(user);
		
		session.getTransaction().commit();
		
		session.close();

	}

}
