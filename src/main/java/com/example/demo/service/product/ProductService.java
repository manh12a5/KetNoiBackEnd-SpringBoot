package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

}
