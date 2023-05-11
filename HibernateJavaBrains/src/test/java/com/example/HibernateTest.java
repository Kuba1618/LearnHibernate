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
		
		Address address1 = new Address();
		address1.setCityName(faker.address().cityName());
		address1.setStreet(faker.address().streetName());
		address1.setState(faker.address().state());
		address1.setPinCode(faker.address().zipCode());
		
		Address address2 = new Address();
		address2.setCityName(faker.address().cityName());
		address2.setStreet(faker.address().streetName());
		address2.setState(faker.address().state());
		address2.setPinCode(faker.address().zipCode());
		
		user.getListOfAddresses().add(address1);
		user.getListOfAddresses().add(address2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
