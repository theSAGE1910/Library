package com.application.library.controller;

import com.application.library.entity.Book;
import com.application.library.service.AuthorService;
import com.application.library.service.BookService;
import com.application.library.service.CategoryService;
import com.application.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBookById(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("add-book")
    public String addBook(Book book, Model model) {
        bookService.createBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "update-book";
    }
}
