package com.application.library.controller;

import com.application.library.entity.Publisher;
import com.application.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllCategories(Model model) {
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("/category/{id}")
    public String findCategory(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "list-publisher";
    }

    @GetMapping("remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        publisherService.deletePublisherById(id);
        return "redirect:/publishers";
    }

    @GetMapping("add-publisher")
    public String addCategory(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String saveCategory(Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publisher", publisher);
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("save-update/{id}")
    public String saveCategory(@PathVariable Long id, Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publisher", publisher);
            return "update-publisher";
        }

        Publisher existingPublisher = publisherService.findPublisherById(id);
        existingPublisher.setId(publisher.getId());
        existingPublisher.setName(publisher.getName());

        publisherService.updatePublisher(existingPublisher);
        return "redirect:/publishers";
    }
}