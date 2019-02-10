package com.rms.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries(
		@NamedQuery(name = "Client.getAll", query= "Select client from Client client")
		)
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CLIENT_SEQ_GEN")
	@SequenceGenerator(name = "CLIENT_SEQ_GEN",sequenceName = "CLIENT_SEQ" ,allocationSize = 1, initialValue= 1)
	private long user_id;
	private String name;
	private String description;

	// one to many
	@OneToMany(mappedBy = "client",cascade =  CascadeType.ALL)
	private List<Post> posts;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(long user_id, String name, String description, List<Post> posts) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.description = description;
		this.posts = posts;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Client [user_id=" + user_id + ", name=" + name + ", description=" + description + ", posts=" + posts
				+ "]";
	}

	

}
