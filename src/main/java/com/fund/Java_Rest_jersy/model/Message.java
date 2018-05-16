package com.fund.Java_Rest_jersy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Message {

		private long id;
		private String message;
		private Date created;
		private String author;
		private Map<Long, Comments> comments = new HashMap<>();
		private List<Links> links = new ArrayList<>();
		
		
		public Message() {
			
		}

		public Message(long id, String message, String author) {
			
			this.id = id;
			this.message = message;
			this.created = new Date();
			this.author = author;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String authro) {
			this.author = authro;
		}

		@Override
		public String toString() {
			return "Message [id=" + id + ", message=" + message + ", created=" + created + ", author=" + author + "]";
		}

		@XmlTransient
		public Map<Long, Comments> getComments() {
			return comments;
		}

		public void setComments(Map<Long, Comments> comments) {
			this.comments = comments;
		}

		public List<Links> getLinks() {
			return links;
		}

		public void setLinks(List<Links> links) {
			this.links = links;
		}
		
		public void addLink(String url, String rel) {
				Links li = new Links();
				li.setLink(url);
				li.setRel(rel);
				links.add(li);
		}
		
	}


