package com.adrien.poc.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the POJO related to the books collection of the mongo database
 * 
 * @author adurand
 */
@Document(collection = "books")
public class Books {

	@Id
	private long id;
	private String title;
	private String author;
	private int nbPages;

	/**
	 * The constructor of the class
	 * 
	 * @param id the id of the book
	 * @param title the title of the book
	 * @param author the author of the book
	 * @param nbPages the number of pages of the book
	 */
	public Books(long id, String title, String author, int nbPages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.nbPages = nbPages;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
