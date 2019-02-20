package com.rms.hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rms.hibernate.model.Car;
import com.rms.hibernate.model.Client;

public class ClientDaoImpl implements ClientDao {

	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public Client save(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(client);
		session.getTransaction().commit();
		session.close();
		return client;
	}

	public Client findById(long seq) {
		Session session = sessionFactory.openSession();
		Client client = session.get(Client.class, seq);
		session.close();
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAll() {
		Session session = sessionFactory.openSession();
		List<Client> clients = session.createNamedQuery("Client.getAll").getResultList();
		session.close();
		return clients;
	}

	public Client update(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client delete(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object save(Car car1) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(car1);
		session.getTransaction().commit();
		session.close();
		return car1;
	}

	public void findClientByCarId(Long long1) {
		Session session = sessionFactory.openSession();
		Query query = session.createNamedQuery("Client.findClientByCarId");
		query.setParameter("car_id", long1);
		System.out.println("-----test------");
		System.out.println(query.getResultList());
	}

}
