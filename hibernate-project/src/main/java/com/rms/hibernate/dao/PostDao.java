package com.rms.hibernate.dao;

import java.util.List;

import com.rms.hibernate.model.Post;

public interface PostDao {

	public Post save(Post post);

	public Post findById(long seq);

	public List<Post> findAll();

	public Post update(Post post);

	public Post delete(Post post);

}
