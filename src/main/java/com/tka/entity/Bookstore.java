package com.tka.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Bookstore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;
	private String bName;
	private String bContactNo;
	private String bEmail;
	private String blocation;
	 @OneToMany(mappedBy = "bookstore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @JsonManagedReference
	private List<Book> book;

	public Bookstore() {
		super();
	}

	public Bookstore(String bName, String bContactNo, String bEmail, String blocation, List<Book> book) {
		super();
		this.bName = bName;
		this.bContactNo = bContactNo;
		this.bEmail = bEmail;
		this.blocation = blocation;
		this.book = book;
	}

	public Bookstore(String bName, String bContactNo, String bEmail, String blocation) {
		super();
		this.bName = bName;
		this.bContactNo = bContactNo;
		this.bEmail = bEmail;
		this.blocation = blocation;
	}

	 

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbContactNo() {
		return bContactNo;
	}

	public void setbContactNo(String bContactNo) {
		this.bContactNo = bContactNo;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getBlocation() {
		return blocation;
	}

	public void setBlocation(String blocation) {
		this.blocation = blocation;
	}

	@Override
	public String toString() {
		return "Bookstore [bId=" + bId + ", bName=" + bName + ", bContactNo=" + bContactNo + ", bEmail=" + bEmail
				+ ", blocation=" + blocation + "]";
	}

}
