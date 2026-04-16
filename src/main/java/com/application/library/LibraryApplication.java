package com.application.library;

import com.application.library.entity.Author;
import com.application.library.entity.Book;
import com.application.library.entity.Category;
import com.application.library.entity.Publisher;
import com.application.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return args -> {
			// Book 1: Science Fiction
			Book book1 = new Book("978-0441172719", "Dune", "Epic science fiction novel set on the desert planet Arrakis.");
			Author author1 = new Author("Frank Herbert", "American science fiction author best known for the Dune universe.");
			Category category1 = new Category("Science Fiction");
			Publisher publisher1 = new Publisher("Chilton Books");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			// Book 2: Fantasy
			Book book2 = new Book("978-0547928227", "The Hobbit", "A beloved classic fantasy adventure following Bilbo Baggins.");
			Author author2 = new Author("J.R.R. Tolkien", "English writer, poet, philologist, and academic.");
			Category category2 = new Category("Fantasy");
			Publisher publisher2 = new Publisher("George Allen & Unwin");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			// Book 3: Programming / Technology
			Book book3 = new Book("978-0132350884", "Clean Code", "A Handbook of Agile Software Craftsmanship.");
			Author author3 = new Author("Robert C. Martin", "Software engineer, instructor, and best-selling author.");
			Category category3 = new Category("Technology");
			Publisher publisher3 = new Publisher("Prentice Hall");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

			// Book 4: Business
			Book book4 = new Book("978-0307887894", "The Lean Startup", "How Today's Entrepreneurs Use Continuous Innovation to Create Radically Successful Businesses.");
			Author author4 = new Author("Eric Ries", "American entrepreneur, blogger, and author.");
			Category category4 = new Category("Business");
			Publisher publisher4 = new Publisher("Crown Business");
			book4.addAuthor(author4);
			book4.addCategory(category4);
			book4.addPublisher(publisher4);
			bookService.createBook(book4);
		};
	}
}
