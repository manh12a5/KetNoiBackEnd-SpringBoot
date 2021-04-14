package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Category>> showAll() {
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Category> edit(@RequestBody Category category, @PathVariable Long id) {
        category.setId(id);
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("delete/[{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
