package com.rms.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rms.hibernate.model.Post;

public class PostDaoImpl implements PostDao {
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public Post save(Post post) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(post);
		session.getTransaction().commit();
		session.close();
		return post;
	}

	public Post findById(long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Post update(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post delete(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

}
