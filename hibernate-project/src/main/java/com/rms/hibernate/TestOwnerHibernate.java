package com.rms.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOwnerHibernate {
	public static void main(String[] args) {
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

//		Owner owner=new Owner();
//		owner.setName("mohit");
//		owner.setAddress("gh-1/276");
//		owner.setAge(24);
//		
//		Vehicle vehicle=new Vehicle();
//		vehicle.setVehicleName("Dzire");
//		
//		owner.setVehicle(vehicle);
//		
//		
//		//owner 2 
//		Owner owner2=new Owner();
//		owner2.setName("rohit");
//		owner2.setAddress("gh-1/276 lal mkt" );
//		owner2.setAge(25);
//		owner2.setVehicle(vehicle);
//		
//		
//		
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(owner);
//		session.save(owner2);
//		session.save(vehicle);
//		session.getTransaction().commit();
//		session.close();
		
		//use get
		Session s1=sessionFactory.openSession();
		Transaction tx=s1.beginTransaction();
		Owner o1=s1.get(Owner.class, 5);
		tx.commit();
		s1.close();
		
		Session s2=sessionFactory.openSession();
		s2.beginTransaction();
		Owner o2=s2.get(Owner.class,5);
		s2.getTransaction().commit();
		s2.close();


	}
}
