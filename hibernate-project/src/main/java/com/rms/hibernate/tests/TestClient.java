package com.rms.hibernate.tests;

import java.util.ArrayList;
import java.util.Date;

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
		//UPDATING DATA FOR CLIENT 1
		client1.setName("Mohit");
		System.out.println(clientService.save(client1));

	}
}
