package com.rms.hibernate.service;

import java.util.List;

import com.rms.hibernate.model.Car;
import com.rms.hibernate.model.Client;

public interface ClientService {
	public Client save(Client client);
	public Client findById(long seq);
	public List<Client> findAll();
	public Client update(Client client);
	public Client delete(Client client);
	public Object save(Car car1);
	public void findClientByCarId(Long long1);
}
