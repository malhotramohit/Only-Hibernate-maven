package com.rms.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "POST_SEQ_GEN")
	@SequenceGenerator(name = "POST_SEQ_GEN" , sequenceName = "POST_SEQ", allocationSize = 1, initialValue= 1)
	private long seq;
	private String content;
	private Date postDate;

	@ManyToOne
	@JoinColumn(name ="user_id")
	private Client client;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(long seq, String content, Date postDate, Client client) {
		super();
		this.seq = seq;
		this.content = content;
		this.postDate = postDate;
		this.client = client;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Post [seq=" + seq + ", content=" + content + ", postDate=" + postDate + "]";
	}

}
