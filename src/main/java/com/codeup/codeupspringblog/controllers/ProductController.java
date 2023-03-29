package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Model.Product;
import com.codeup.codeupspringblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ProductController {
    private ProductRepository productsDao;
    public ProductController(ProductRepository productsDao) {
        this.productsDao = productsDao;
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        List<Product> products = productsDao.findAll();
        System.out.println(products);
        model.addAttribute("products", products);
        return "products/products";
    }

    @GetMapping("/products/create")
    public String createProduct(){
        Product product = new Product("A cap", 20020);
       Product product1 = new Product ("A TV", 3030);
        productsDao.save(product);
        productsDao.save(product1);
        return "redirect:/products";
    }
}
