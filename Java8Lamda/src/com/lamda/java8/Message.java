package com.lamda.java8;

public class Message {

	private int id;
	private String message;
	private String priority = "Default";
	private Author author;

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Message(int id, String message)
	{
		this.message=message;
		this.id=id;
	}
	public Message(int id, String message, String priority, Author author)
	{
		this.message=message;
		this.id=id;
		this.priority = priority; 
		this.author= author;
	}
	
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
