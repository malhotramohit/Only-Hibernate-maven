package com.rms.hibernate.service;

import java.util.List;

import com.rms.hibernate.dao.PostDao;
import com.rms.hibernate.dao.PostDaoImpl;
import com.rms.hibernate.model.Post;

public class PostServiceImpl implements PostService{
	private PostDao postDao = new PostDaoImpl();

	public Post save(Post post) {
		// TODO Auto-generated method stub
		return postDao.save(post);
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
