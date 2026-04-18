package com.application.library.controller;

import com.application.library.entity.Category;
import com.application.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String findCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "list-category";
    }

    @GetMapping("remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }

    @GetMapping("add-category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", category);
            return "add-category";
        }
        categoryService.createCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "update-category";
    }

    @PostMapping("save-category/{id}")
    public String saveCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", category);
            return "update-category";
        }

        Category existingCategory = categoryService.findCategoryById(id);
        existingCategory.setId(category.getId());
        existingCategory.setName(category.getName());

        categoryService.updateCategory(existingCategory);
        return "redirect:/categories";
    }
}
