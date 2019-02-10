package com.rms.hibernate.service;

import java.util.List;

import com.rms.hibernate.dao.ClientDao;
import com.rms.hibernate.dao.ClientDaoImpl;
import com.rms.hibernate.model.Client;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao = new ClientDaoImpl();

	public Client save(Client client) {
		// TODO Auto-generated method stub
		return clientDao.save(client);
	}

	public Client findById(long seq) {
		// TODO Auto-generated method stub
		return clientDao.findById(seq);
	}

	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll();
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
