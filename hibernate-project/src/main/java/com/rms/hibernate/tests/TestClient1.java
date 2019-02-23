package com.rms.hibernate.tests;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestClient1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session = sessionFactory.openSession();
		String str = "select job from Job job";
		Query query = session.createNativeQuery(str);
		query.getResultList();

	}
}
