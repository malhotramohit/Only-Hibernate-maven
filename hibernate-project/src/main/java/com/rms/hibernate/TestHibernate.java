package com.rms.hibernate;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
	public static void main(String[] args) {

		// create userDetails object
		UserDetails userDetails = new UserDetails();
		// not setting id hibernate will set
		userDetails.setUserName("Mohit");
		userDetails.setDescription("Coder");

		// create userDetails object
		UserDetails userDetails1 = new UserDetails();
		// not setting id hibernate will set
		userDetails1.setUserName("Rohit");
		userDetails1.setDescription("CA");

		// create vehicle object 1
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bullet");

		vehicle.setUserDetailsList(Arrays.asList(userDetails, userDetails1));

		// create vehicle object 2
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Dzire");

		vehicle1.setUserDetailsList(Arrays.asList(userDetails, userDetails1));

		// setting list of vehicles
		userDetails.setVehicleList(Arrays.asList(vehicle, vehicle1));
		userDetails1.setVehicleList(Arrays.asList(vehicle, vehicle1));

		// get session factory and session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(vehicle1);
		session.save(userDetails);
		session.save(userDetails1);
		session.getTransaction().commit();
		session.close();

	}
}
