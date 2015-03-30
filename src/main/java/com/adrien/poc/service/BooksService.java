package com.adrien.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrien.poc.bean.Books;
import com.adrien.poc.bean.Sequence;
import com.adrien.poc.repository.BookRepository;
import com.adrien.poc.repository.SequenceRepository;

/**
 * This class is the service for the books {@link Books}
 * 
 * @author adurand
 */
@Service
public class BooksService extends BaseService<Books, BookRepository> {

	// The sequence key name for the books
	private static final String BOOKS_SEQ_KEY = "book";

	/**
	 * The constructor of the class that initialize the repository and the logger of the class
	 * 
	 * @param repository the repository for the books
	 */
	@Autowired
	public BooksService(BookRepository repository) {
		super(repository, LoggerFactory.getLogger(BooksService.class));
	}

	/**
	 * The repository for the sequence {@link Sequence}
	 */
	@Autowired
	private SequenceRepository sequenceRepo;

	/**
	 * This method create a few books {@link Books}
	 * 
	 * @return a list {@link List} of books created {@link Books}
	 * @throws Exception
	 */
	public List<Books> createBooks() throws Exception {
		logger.debug("Books creation");
		List<Books> books = new ArrayList<Books>();
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "50 Nuances de grey", "Dorcel", 600)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "Meurtre sur le nil",
				"Agatha Christie", 560)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "Harry Potter à l'école des sorciers",
				"J.K Roling", 400)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "50 Nuances plus sombres", "Dorcel",
				800)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY),
				"Harry Potter et le prince de sang mélé", "J.K Roling", 653)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "Harry Potter et la prison d'azkaban",
				"J.K Roling", 497)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "L'homme qui voulait être heureux",
				"Nicolas Gounelle", 187)));
		books.add(repo.save(new Books(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY), "L'homme qui voulait être heureux",
				"Nicolas Gounelle", 187)));

		return books;
	}

	/**
	 * This method is the service for the creation of a book {@link Books}
	 * 
	 * @param book the book to create {@link Books}
	 * @return the book created {@link Books}
	 * @throws Exception
	 */
	public Books createBook(Books book) throws Exception {
		book.setId(sequenceRepo.getNextSequenceId(BOOKS_SEQ_KEY));
		return repo.save(book);
	}

	/**
	 * This method find a book by his title
	 * 
	 * @param title of the book looked for
	 * @return a book {@link Books}
	 */
	public Books findBookByTitle(String title) {
		logger.debug("Book with title: {}", title);
		return repo.findByTitle(title);
	}

	/**
	 * This method find a list of books by an author
	 * 
	 * @param author of the books looked for
	 * @return a list of books {@link List} {@link Books}
	 */
	public List<Books> findBooksByAuthor(String author) {
		logger.debug("All books for author: {}", author);
		return repo.findByAuthor(author);
	}
}
