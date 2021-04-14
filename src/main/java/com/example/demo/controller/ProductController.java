package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("category")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> showAll() {
        List<Product> productList = productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> view(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
