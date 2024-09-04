package com.tka.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.java.JavaLoggingSystem.Factory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

 
import com.tka.entity.Book;
import com.tka.entity.Bookstore;

import jakarta.transaction.Transactional;

@Repository
public class BookstoreDao {
	Bookstore bookstore;
	private List<Bookstore> bookstoreList = new ArrayList<>();
	private List<Book> bookList = new ArrayList<>();

	@Autowired
	SessionFactory factory;

	public List<Bookstore> fetchAllBookstores() {

		Session session = factory.openSession();
		List<Bookstore> bookstoreList = session.createQuery("from Bookstore", Bookstore.class).list();
		return bookstoreList;
	}

	public Bookstore saveBookstore(Bookstore bookstore) {
		Session session = factory.openSession();
		session.save(bookstore);
		session.beginTransaction().commit();
		return bookstore;

	}

	public Bookstore updateBookstore(Bookstore bookstore) {
		Session session = factory.openSession();
		session.update(bookstore);
		session.beginTransaction().commit();
		return bookstore;
		/*
		 * for (int i = 0; i < bookstoreList.size(); i++) { if
		 * (bookstoreList.get(i).getbId() == bookstore.getbId()) { bookstoreList.set(i,
		 * bookstore); return bookstore; } } return null;
		 */}

	public Bookstore removeBookstore(int bId) {
		Session session = factory.openSession();
		Bookstore bookstore = session.get(Bookstore.class, bId);
		if (bookstore != null) {
			session.delete(bookstore);
		}
		session.beginTransaction().commit();
		return bookstore;
		// return bookstoreList.removeIf(bookstore -> bookstore.getbId() == bId);

	}

	public Bookstore getBookstoreById(int bId) {
		Session session = factory.openSession();
		Bookstore bookstore = session.load(Bookstore.class, bId);

		return bookstore;

	}

	/*public Bookstore getBookstoreByName(String bName) {
		Session session=factory.openSession();

        String hql = "FROM Bookstore WHERE bName = :bName";
        Query<Bookstore>  query = session.createQuery(hql, Bookstore.class);
        query.setParameter("bName", bName);
       Bookstore bookstore = query.uniqueResult(); 
     
		return  bookstore;

	}*/
	public Bookstore getBookstoreByName(String bName) {
		Session session=factory.openSession();
	    List<Bookstore> results = session.createQuery("from Bookstore where bName = :bName")
	                                     .setParameter("bName",bName)
	                                     .setMaxResults(1) // Ensures only one result is fetched
	                                     .list();
	    if (results.isEmpty()) {
	        return null; // or throw an exception if that's more appropriate
	    } else {
	        return results.get(0); // Return the first result
	    }
	}


	public Bookstore getBookstoreByLocation(String blocation) {
	    Session session = factory.openSession();
	    
	     
	        String hql = "FROM Bookstore WHERE blocation = :blocation";
	        Query<Bookstore>  query = session.createQuery(hql, Bookstore.class);
	        query.setParameter("blocation", blocation);
	       Bookstore bookstore = query.uniqueResult(); 
	    
	    return  bookstore;
	}


	public int countBookstoresByLocation(String blocation) {
		return (int) bookstoreList.stream().filter(bookstore -> bookstore.getBlocation().equalsIgnoreCase(blocation))
				.count();

	}

	public Bookstore updateBookstoreContact(String bName, String contactNo, String email) {
		Bookstore bookstore = getBookstoreByName(bName);
		if (bookstore != null) {
			bookstore.setbContactNo(contactNo);
			bookstore.setbEmail(email);
		}
		return bookstore;

	}

	public List<Book> fetchAllBooks() {
		return bookList;
	}

	public Book saveBook(Book book) {
		bookList.add(book);
		return book;
	}

	public Book updateBook(Book book) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId() == book.getBookId()) {
				bookList.set(i, book);
				return book;
			}
		}
		return null;
	}

	public boolean removeBook(int bookId) {
		return bookList.removeIf(book -> book.getBookId() == bookId);
	}

	public Book getBookById(int bookId) {
		for (Book book : bookList) {
			if (book.getBookId() == bookId) {
				return book;
			}
		}
		return null;
	}

	public List<Book> getBooksByTitle(String title) {
		return bookList.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
	}

	public List<Book> getBooksByAuthor(String author) {
		return bookList.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
	}

	public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
		List<Book> booksInRange = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
				booksInRange.add(book);
			}
		}
		return booksInRange;
	}

	public List<Book> getBooksByBookstore(Bookstore bookstore) {
		return bookList.stream().filter(book -> book.getBookstore().equals(bookstore)).collect(Collectors.toList());
	}

	public double calculateTotalPriceOfBooks() {
		double totalPrice = 0.0;
		for (Book book : bookList) {
			totalPrice += book.getPrice();
		}
		return totalPrice;
	}

	public int countBooksByBookstore(Bookstore bookstore) {
		return (int) bookList.stream().filter(book -> book.getBookstore().equals(bookstore)).count();
	}

}
