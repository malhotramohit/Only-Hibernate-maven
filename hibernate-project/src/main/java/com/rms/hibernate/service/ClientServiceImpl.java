package com.rms.hibernate.service;

import java.util.List;

import com.rms.hibernate.dao.ClientDao;
import com.rms.hibernate.dao.ClientDaoImpl;
import com.rms.hibernate.model.Car;
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

	public Object save(Car car1) {
		// TODO Auto-generated method stub
		return clientDao.save(car1);
	}

	public void findClientByCarId(Long long1) {
		// TODO Auto-generated method stub
		clientDao.findClientByCarId(long1);
	}

}
