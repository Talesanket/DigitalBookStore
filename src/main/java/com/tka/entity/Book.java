package com.tka.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	private String title;
	private String author;
	private double price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookstore_id")
	@JsonBackReference
	private Bookstore bookstore;

	public Book() {
		super();
	}

	public Book(String title, String author, double price, Bookstore bookstore) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.bookstore = bookstore;
	}

	public Bookstore getBookstore() {
		return bookstore;
	}

	public void setBookstore(Bookstore bookstore) {
		this.bookstore = bookstore;
	}

	public Book(String title, String author, double price) {
		super();

		this.title = title;
		this.author = author;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [ title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
