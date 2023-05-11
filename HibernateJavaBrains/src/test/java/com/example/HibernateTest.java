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
		
		Address address = new Address();
		address.setCityName(faker.address().cityName());
		address.setStreet(faker.address().streetName());
		address.setState(faker.address().state());
		address.setPinCode(faker.address().zipCode());
		
		user.setAddress(address);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
