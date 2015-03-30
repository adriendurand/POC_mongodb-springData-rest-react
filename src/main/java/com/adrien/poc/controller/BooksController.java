package com.adrien.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrien.poc.bean.Books;
import com.adrien.poc.service.BooksService;

/**
 * This class is the controller class for the books {@link Books}. All the CRUD methods are reachable by REST service.
 * 
 * @author adurand
 */
@RestController
@RequestMapping("/api/books")
public class BooksController {

	/**
	 * The service related to the books
	 */
	private final BooksService booksService;

	/**
	 * Constructor of the class that initialize the booksService {@link BooksService}
	 * 
	 * @param booksService
	 */
	@Autowired
	BooksController(BooksService booksService) {
		this.booksService = booksService;
	}

	/**
	 * This method map a request to the service method for a book creation
	 * 
	 * @param title the title of the book
	 * @param author the author of the book
	 * @param nbPages the number of pages of the book
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/createBook/{title}/{author}/{nbPages}")
	Books createBook(@PathVariable String title, @PathVariable String author, @PathVariable int nbPages) throws Exception {
		return booksService.createBook(new Books(0L, title, author, nbPages));
	}

	/**
	 * This method map a request to the service method for the creation of books
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createBooks")
	List<Books> createBooks() throws Exception {
		return booksService.createBooks();
	}

	/**
	 * This method map a request to the service method for the deletion of all the books
	 */
	@RequestMapping("/deleteBooks")
	void deleteBooks() {
		booksService.deleteAll();
	}

	/**
	 * This method map a request to the service method for a book deletion
	 * 
	 * @param id the id of the book to delete
	 */
	@RequestMapping(value = "/deleteBook/{id}")
	void deleteBook(@PathVariable Long id) {
		booksService.deleteOne(id);
	}

	/**
	 * This method map a request to the service method to get a book
	 * 
	 * @param id the id of the book we want retrieve
	 * @return the book {@link Books}
	 */
	@RequestMapping(value = "/findBook/{id}")
	Books findBook(@PathVariable Long id) {
		return booksService.findOne(id);
	}

	/**
	 * This method map a request to the service method to get a book by his title
	 * 
	 * @param title the title of the book we want to retrieve
	 * @return the book {@link Books}
	 */
	@RequestMapping(value = "/findBook/title/{title}")
	private Books findBookByTitle(@PathVariable String title) {
		return booksService.findBookByTitle(title);
	}

	/**
	 * This method map a request to the service method to get a book by his author
	 * 
	 * @param author the author of the book we want to retrieve
	 * @return
	 */
	@RequestMapping(value = "/findBook/author/{author}")
	private List<Books> findBookByAuthor(@PathVariable String author) {
		return booksService.findBooksByAuthor(author);
	}

	/**
	 * This method map a request to the service method to get all books
	 * 
	 * @return a list {@link List} of books {@link Books}
	 */
	@RequestMapping("/findBooks")
	List<Books> findBooks() {
		return booksService.findAll();
	}

	/**
	 * This method map a request to the service method to update a book
	 * 
	 * @param id the id of the book to update
	 * @param title the new title
	 * @param author the new author
	 * @param nbPages the new nbPages
	 * @return the book {@link Books} updated
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateBook/{id}/{title}/{author}/{nbPages}")
	Books updateBook(@PathVariable long id, @PathVariable String title, @PathVariable String author,
			@PathVariable int nbPages) throws Exception {
		Books book = booksService.findOne(id);
		book.setId(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setNbPages(nbPages);
		return booksService.save(book);
	}

	/**
	 * This method map a request to the service method to update a book title
	 * 
	 * @param id the id of the book
	 * @param title the title of the book
	 * @return the book updated {@link Books}
	 */
	@RequestMapping(value = "/updateBookTitle/{id}/{title}")
	Books updateBookTitle(@PathVariable Long id, @PathVariable String title) {
		Books book = booksService.findOne(id);
		book.setTitle(title);

		return booksService.save(book);
	}

}
