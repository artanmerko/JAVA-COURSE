package com.codingdojo.productsandcategories.controllers;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productService.allProducts();
        List<Category> categories = categoryService.allCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "newCat";
    }

    @PostMapping("/categories/new")
    public String addCategory(@ModelAttribute("category") Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/";
        }
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("/categories/{id}")
    public String viewCategory(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("assignedProducts", productService.getAssignedProducts(category));
        model.addAttribute("unassignedProducts", productService.getUnassignedProducts(category));
        return "showCat";
    }

    @PostMapping("/categories/{id}")
    public String updateCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
        Category category = categoryService.findById(id);
        Product product = productService.findById(productId);
        category.getProducts().add(product);
        categoryService.updateCategory(category);
        return "redirect:/categories/"+id;
    }

    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "newPro";
    }

    @PostMapping("/products/new")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/";
        }
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/{id}")
    public String viewProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("assignedCategories", categoryService.getAssignedCategories(product));
        model.addAttribute("unassignedCategories", categoryService.getUnassignedCategories(product));
        return "showPro";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId, Model model) {
        Product product = productService.findById(id);
        Category category = categoryService.findById(categoryId);
        product.getCategories().add(category);
        productService.updateProduct(product);
        return "redirect:/products/"+id;
    }

}