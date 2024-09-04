package com.tka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Book;
import com.tka.entity.Bookstore;
import com.tka.service.BookstoreService;

@RestController
public class BookstoreController {
	@Autowired
	BookstoreService bookstoreService;

	@GetMapping("fetch")
	public List<Bookstore> fetchAllBookstores() {
		return bookstoreService.fetchAllBookstores();
	}

	@PostMapping("add")
	public Bookstore saveBookstore(@RequestBody Bookstore bookstore) {
		return bookstoreService.saveBookstore(bookstore);

	}

	@PutMapping("update/{bId}")
	public Bookstore updateBookstore(@PathVariable int bId,@RequestBody Bookstore bookstore) {
		bookstore.setbId(bId);
		return bookstoreService.updateBookstore(bId, bookstore);
	}

	@DeleteMapping("remove/{bId}")
	public Bookstore deleteBookstore(@PathVariable int bId) {
		return bookstoreService.deleteBookstore(bId);
	}

	@GetMapping("getbyid/{bId}")
	public Bookstore getBookstoreById(@PathVariable("bId") int bId) {
		return bookstoreService.getBookstoreById(bId);
	}

	@GetMapping("getbyname/{bName}")
	public Bookstore getBookstoreByName(@PathVariable String bName) {
		return bookstoreService.getBookstoreByName(bName);

	}

	@GetMapping("getbylocation/{blocation}")
	public Bookstore getBookstoreByLocation(@PathVariable("blocation") String blocation) {
		return bookstoreService.getBookstoreByLocation(blocation);

	}

	@GetMapping("countbylocation")
	public int countBookstoresByLocation(
			@RequestParam(value = "blocation", defaultValue = "Unknown") String blocation) {
		return bookstoreService.countBookstoresByLocation(blocation);

	}
	 @PutMapping("{bName}/updateContact")
	    public Bookstore updateBookstoreContact(@PathVariable String bName, @RequestParam(value="bContactNo") String contactNo, @RequestParam(value="bEmail") String email) {
	        return bookstoreService.updateBookstoreContact(bName, contactNo, email);
	    }
	 @GetMapping("fetchbook")
	 public List<Book> fetchAllBooks() {
	        return bookstoreService.fetchAllBooks();
	    }
	  
	 @GetMapping("/books/{bookId}")
	    public Book getBookById(@PathVariable int bookId) {
	        return bookstoreService.getBookById(bookId);
	    }

	    @GetMapping("/books/title/{title}")
	    public List<Book> getBooksByTitle(@PathVariable String title) {
	        return bookstoreService.getBooksByTitle(title);
	    }

	    @GetMapping("/books/author/{author}")
	    public List<Book> getBooksByAuthor(@PathVariable String author) {
	        return bookstoreService.getBooksByAuthor(author);
	    }

	    @GetMapping("/books/price-range")
	    public List<Book> getBooksByPriceRange( @RequestParam(name = "minPrice", required = false, defaultValue = "0") double minPrice,
	    	    @RequestParam(name = "maxPrice", required = false, defaultValue = "Double.MAX_VALUE") double maxPrice) {
	        return bookstoreService.getBooksByPriceRange(minPrice, maxPrice);
	    }

	    

	    @GetMapping("/books/total-price")
	    public double calculateTotalPriceOfBooks() {
	        return bookstoreService.calculateTotalPriceOfBooks();
	    }

	    @GetMapping("/bookstores/{bId}/book-count")
	    public int countBooksByBookstore(@PathVariable int bId) {
	        Bookstore bookstore = new Bookstore();
	        bookstore.setbId(bId); // Assuming Bookstore has an ID field
	        return bookstoreService.countBooksByBookstore(bookstore);
	    }

	    @PostMapping("/books")
	    public Book saveBook(@RequestBody Book book) {
	        return bookstoreService.saveBook(book);
	    }
 

	    @DeleteMapping("/books/{bookId}")
	    public boolean removeBook(@PathVariable int bookId) {
	        return bookstoreService.removeBook(bookId);
	    }

	     

}
