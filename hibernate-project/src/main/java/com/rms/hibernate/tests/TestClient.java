package com.rms.hibernate.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rms.hibernate.model.Car;
import com.rms.hibernate.model.Client;
import com.rms.hibernate.model.Job;
import com.rms.hibernate.model.Post;
import com.rms.hibernate.service.ClientService;
import com.rms.hibernate.service.ClientServiceImpl;
import com.rms.hibernate.service.PostService;
import com.rms.hibernate.service.PostServiceImpl;

/*
 * Hibernate named queries:

Entities :
1. Client
2. Job
3. Post
4. Vehicle

R1: One client can have only one Job (OneToOne)
(Client to Job —> One to One).

R2: One client can add multiple posts (OneToMany)
(Client to Post —> One to Many).

R3: One client can get many vehicles on rent , One vehicle can be rented by many Clients (ManyToMany).
(Client to Vehicle —> ManyToMany )

Possible Queries :

1. save
2. Update
3. Delete
4. findById
5. findBySpecificAttribute
6. findAll
7. findClientAndJob
8. findJobAndClient
9. findClientAndPost
10. findPostAndClient
11. findClientAndCar
12. findCarAndClient
13. findClientAndJobByJobName
14. findClientAndPostByClientName
15. findVehicleAndClientByCarName
16. findClientJobPostCar
17. findClientJobPostCarByClientNameAndPostName
 * */
public class TestClient {
	static ClientService clientService = new ClientServiceImpl();
	static PostService postService = new PostServiceImpl();

	public static void main(String[] args) {

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

		Job job1 = new Job();
		job1.setJobName("job1");
		client.setJob(job1);

		Job job2 = new Job();
		job2.setJobName("job1");
		client1.setJob(job2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.saveOrUpdate((post1));

		session.saveOrUpdate((post2));
		session.saveOrUpdate((post11));
		session.saveOrUpdate((post22));
		session.saveOrUpdate((job1));
		session.saveOrUpdate((job2));
		session.saveOrUpdate((client));
		session.saveOrUpdate((client1));
		session.saveOrUpdate((client2));
		session.saveOrUpdate((client3));
		session.saveOrUpdate((client4));
		session.saveOrUpdate((client1));
		session.saveOrUpdate((client2));
		session.saveOrUpdate((client3));
		session.saveOrUpdate((client4));
		session.saveOrUpdate((car1));
		session.saveOrUpdate((car2));
		session.saveOrUpdate((car3));
		session.saveOrUpdate((car4));
		tx.commit();
		session.close();

		// findClientByClientId, select client from client where client.user_id =
		// :user_id
		// findJobByJobId, select job from Job where job.jobId = :jobId
		// findPostByPostId , select post from Post where post.seq = :seq
		// findCarByCarId , select car from Car where car.carId = :carId
		session = sessionFactory.openSession();

		Query query = session.createNamedQuery("Client.findClientByClientId");
		query.setParameter("user_id", new Long(1));
		System.out.println(query.getSingleResult());

		query = session.createNamedQuery("Job.findJobByJobId");
		query.setParameter("jobId", new Long(1));
		System.out.println(query.getSingleResult());

		query = session.createNamedQuery("Post.findPostByPostId");
		query.setParameter("seq", new Long(1));
		System.out.println(query.getSingleResult());

		query = session.createNamedQuery("Car.findCarByCarId");
		query.setParameter("carId", new Long(3));
		System.out.println(query.getSingleResult());

		query = session.createNamedQuery("Client.findClientAndJob");
		List<Object[]> list = query.getResultList();
		Object[] objArr = list.get(0);
		System.out.println(objArr[0] + "--" + objArr[1]);

		query = session.createNamedQuery("Post.findPostAndClientByPostId");
		query.setParameter("seq", new Long(1));
		List<Object[]> resultList = query.getResultList();
		Object[] resArr = resultList.get(0);
		System.out.println(resArr[0] + "--" + resArr[1]);

		// 1)
		// query = session.createNamedQuery("Client.findClientAndPostByUserId");

		// 2) findCarAndClientByCarId, select car,client from Car car join
		// car.clientList car where car.carId = :carId
		query = session.createNamedQuery("Car.findCarAndClientByCarId");
		query.setParameter("carId", new Long(5));
		List<Object[]> list2 = query.getResultList();
		for (int i = 0; i < list2.size(); i++) {
			Object[] objArr2 = list2.get(i);
			System.out.println(objArr2[i] + "--" + objArr2[i]);
		}

		session.close();

		session = sessionFactory.openSession();
		// String str = "select cl from client cl where cl.user_id = :user_id";
		Query query1 = session.createNativeQuery("select job from Job job");
		List<Object[]> list3 = query1.getResultList();

		session.close();

		// Client.findClientAndJob

		// will not work becoz of transaction or cascade type
		// System.out.println(postService.save(post1));
		// System.out.println(postService.save(post2));
		// System.out.println(clientService.save(client));
		// System.out.println(clientService.save(client1));
		// // UPDATING DATA FOR CLIENT 1
		// client1.setName("Mohit");
		// System.out.println(clientService.save(client1));
		//
		// Client clientRec1 = clientService.findById(1);
		// System.out.println(clientRec1.getPosts().get(1).getContent());

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

		// findClientByCarId()
		// select client from Client client where Car_client.car.car_id = :car_id
		clientService.findClientByCarId(new Long(1));

	}
}
