package com.application.library;

import com.application.library.entity.Author;
import com.application.library.entity.Book;
import com.application.library.entity.Category;
import com.application.library.entity.Publisher;
import com.application.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	public CommandLineRunner initialCreate(BookService bookService) {
		return args -> {
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test name1",  "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC", "Book name", "My first book");
			Author author2 = new Author("Test name2",  "Test description");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second publisher");
			book1.addAuthor(author2);
			book1.addCategory(category2);
			book1.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC", "Book name", "My first book");
			Author author3 = new Author("Test name3",  "Test description");
			Category category3 = new Category("Fiction books");
			Publisher publisher3 = new Publisher("Third publisher");
			book1.addAuthor(author3);
			book1.addCategory(category3);
			book1.addPublisher(publisher3);
			bookService.createBook(book3);
		};
	}
}
