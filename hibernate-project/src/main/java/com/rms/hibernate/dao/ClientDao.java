package com.rms.hibernate.dao;

import java.util.List;

import com.rms.hibernate.model.Client;

public interface ClientDao {
	public Client save(Client client);
	public Client findById(long seq);
	public List<Client> findAll();
	public Client update(Client client);
	public Client delete(Client client);

}
