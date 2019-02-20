package com.rms.hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long carId;
	
	private String carName;
	
	@ManyToMany(mappedBy = "carList" )
	private List<Client> clientList;
	
	

	public Car(String carName, List<Client> clientList) {
		super();
		this.carName = carName;
		this.clientList = clientList;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	
	
	
	
}
