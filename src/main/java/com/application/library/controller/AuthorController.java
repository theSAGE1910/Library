package com.application.library.controller;

import com.application.library.entity.Author;
import com.application.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/author/{id}")
    public String findAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute("author", author);
        return "list-author";
    }

    @GetMapping("remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model) {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }

    @GetMapping("add-author")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("author", author);
            return "add-author";
        }
        authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute("author", author);
        return "update-author";
    }

    @PostMapping("save-author/{id}")
    public String saveAuthor(@PathVariable Long id, Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("author", author);
            return "update-author";
        }

        Author existingAuthor = authorService.findAuthorById(id);
        existingAuthor.setId(author.getId());
        existingAuthor.setName(author.getName());

        authorService.updateAuthor(existingAuthor);
        return "redirect:/authors";
    }

}
