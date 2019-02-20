package com.rms.hibernate.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rms.hibernate.model.Car;
import com.rms.hibernate.model.Client;
import com.rms.hibernate.model.Post;
import com.rms.hibernate.service.ClientService;
import com.rms.hibernate.service.ClientServiceImpl;
import com.rms.hibernate.service.PostService;
import com.rms.hibernate.service.PostServiceImpl;

public class TestClient {
	static ClientService clientService = new ClientServiceImpl();
	static PostService postService = new PostServiceImpl();

	public static void main(String[] args) {
		
		
		validateManyToMany();

		 Client client = new Client();
		 client.setDescription("desc 1");
		 client.setName("client 1");
		
		 Post post1 = new Post();
		 post1.setContent("content 1");
		 post1.setPostDate(new Date());
		 post1.setClient(client);
		
		 Post post2 = new Post();
		 post2.setContent("content 2");
		 post2.setPostDate(new Date());
		 post2.setClient(client);
		
		 ArrayList<Post> posts = new ArrayList<Post>();
		
		 posts.add(post1);
		 posts.add(post2);
		
		 client.setPosts(posts);
		
		 Client client1 = new Client();
		 client1.setDescription("desc 2");
		 client1.setName("client 2");
		
		 Post post11 = new Post();
		 post11.setContent("content 111");
		 post11.setPostDate(new Date());
		 post11.setClient(client1);
		
		 Post post22 = new Post();
		 post22.setContent("content 22");
		 post22.setPostDate(new Date());
		 post22.setClient(client1);
		
		 ArrayList<Post> postsxx = new ArrayList<Post>();
		
		 postsxx.add(post11);
		 postsxx.add(post22);
		
		 client1.setPosts(postsxx);
		 // will not work becoz of transaction or cascade type
		 // System.out.println(postService.save(post1));
		 // System.out.println(postService.save(post2));
		 System.out.println(clientService.save(client));
		 System.out.println(clientService.save(client1));
		 // UPDATING DATA FOR CLIENT 1
		 client1.setName("Mohit");
		 System.out.println(clientService.save(client1));
		
		 Client clientRec1 = clientService.findById(1);
		 System.out.println(clientRec1.getPosts().get(1).getContent());

	}

	private static void validateManyToMany() {
		Client client1 = new Client("Client 1", "desc 1", null, null);
		Client client2 = new Client("Client 2", "desc 2", null, null);
		Client client3 = new Client("Client 3", "desc 3", null, null);
		Client client4 = new Client("Client 4", "desc 4", null, null);

		Car car1 = new Car("car 1", null);
		Car car2 = new Car("car 2", null);
		Car car3 = new Car("car 3", null);
		Car car4 = new Car("car 4", null);

		/*
		 * c1:car1,c1:car2,c1:car3 c2:car3,c2:car4 c3:car4 c4:car2,c4:car4
		 * 
		 * 
		 */

		List<Car> carListForCLient1 = new ArrayList<Car>();

		carListForCLient1.add(car1);
		carListForCLient1.add(car2);
		carListForCLient1.add(car3);
		client1.setCarList(carListForCLient1);

		List<Car> carListForCLient2 = new ArrayList<Car>();

		carListForCLient2.add(car3);
		carListForCLient2.add(car4);
		client2.setCarList(carListForCLient2);

		List<Car> carListForCLient3 = new ArrayList<Car>();

		carListForCLient3.add(car4);
		client3.setCarList(carListForCLient3);

		List<Car> carListForCLient4 = new ArrayList<Car>();

		carListForCLient4.add(car2);
		carListForCLient4.add(car4);
		client4.setCarList(carListForCLient4);

		List<Client> clientListForCar1 = new ArrayList<Client>();
		clientListForCar1.add(client1);

		List<Client> clientListForCar2 = new ArrayList<Client>();
		clientListForCar2.add(client1);
		clientListForCar2.add(client4);

		List<Client> clientListForCar3 = new ArrayList<Client>();
		clientListForCar3.add(client1);
		clientListForCar3.add(client2);

		List<Client> clientListForCar4 = new ArrayList<Client>();
		clientListForCar4.add(client2);
		clientListForCar4.add(client4);

		clientService.save(car1);
		clientService.save(car2);
		clientService.save(car3);
		clientService.save(car4);

		clientService.save(client1);
		clientService.save(client2);
		clientService.save(client3);
		clientService.save(client4);
		
		//findClientByCarId()
		//select client from Client client where Car_client.car.car_id = :car_id 
		clientService.findClientByCarId(new Long(1));

	}
}
