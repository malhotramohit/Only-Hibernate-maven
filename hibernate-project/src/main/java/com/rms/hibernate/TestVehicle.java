package com.rms.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestVehicle {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Vehicle veh = new Vehicle();
		veh.setVehicleName("Car");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(veh);
		session.getTransaction().commit();
	}

}
