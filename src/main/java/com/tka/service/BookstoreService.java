package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.BookstoreDao;
import com.tka.entity.Book;
import com.tka.entity.Bookstore;

@Service
public class BookstoreService {
	@Autowired
	BookstoreDao bookstoreDao;

	public List<Bookstore> fetchAllBookstores() {
		List<Bookstore> listBookstores = bookstoreDao.fetchAllBookstores();

		return listBookstores;

	}

	public Bookstore saveBookstore(Bookstore bookstore) {
		return bookstoreDao.saveBookstore(bookstore);

	}

	public Bookstore updateBookstore(int bId, Bookstore bookstore) {
		bookstore.setbId(bId);
		return bookstoreDao.updateBookstore(bookstore);
	}

	public Bookstore deleteBookstore(int id) {
		return bookstoreDao.removeBookstore(id);

	}
	 public Bookstore getBookstoreById(int bId) {
	        return bookstoreDao.getBookstoreById(bId);
	    }
	 public Bookstore getBookstoreByName(String bName) {
		return bookstoreDao.getBookstoreByName(bName);
		 
	 }
	 public Bookstore getBookstoreByLocation(String blocation){
		return bookstoreDao.getBookstoreByLocation(blocation);
		 
	 }
	 public int countBookstoresByLocation(String blocation) {
		 return bookstoreDao.countBookstoresByLocation(blocation);
	 }
	 public Bookstore updateBookstoreContact(String bName, String contactNo, String email) {
	        return bookstoreDao.updateBookstoreContact(bName, contactNo, email);
	    }
	 public List<Book> fetchAllBooks(){
		 return bookstoreDao.fetchAllBooks();
	 }
	  
	 public Book getBookById(int bookId) {
	        return bookstoreDao.getBookById(bookId);
	    }

	    public List<Book> getBooksByTitle(String title) {
	        return bookstoreDao.getBooksByTitle(title);
	    }

	    public List<Book> getBooksByAuthor(String author) {
	        return bookstoreDao.getBooksByAuthor(author);
	    }

	    public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
	        return bookstoreDao.getBooksByPriceRange(minPrice, maxPrice);
	    }

	    

	    public double calculateTotalPriceOfBooks() {
	        return bookstoreDao.calculateTotalPriceOfBooks();
	    }

	    public int countBooksByBookstore(Bookstore bookstore) {
	        return bookstoreDao.countBooksByBookstore(bookstore);
	    }

	    public Book saveBook(Book book) {
	        return bookstoreDao.saveBook(book);
	    }

	    public Book updateBook(Book book) {
	        return bookstoreDao.updateBook(book);
	    }

	    public boolean removeBook(int bookId) {
	        return bookstoreDao.removeBook(bookId);
	    }
	 }
		 
	 


