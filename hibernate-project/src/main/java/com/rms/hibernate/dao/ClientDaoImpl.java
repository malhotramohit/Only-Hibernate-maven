package com.rms.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		Client client =session.get(Client.class, seq);
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAll() {
		Session session = sessionFactory.openSession();
		List<Client>  clients = session.createNamedQuery("Client.getAll").getResultList();
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

}
