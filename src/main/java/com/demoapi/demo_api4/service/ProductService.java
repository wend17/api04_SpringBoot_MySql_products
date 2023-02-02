package com.demoapi.demo_api4.service;

import com.demoapi.demo_api4.dao.ProductsDao;
import com.demoapi.demo_api4.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductsDao productsDao;
    public ProductService(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }


    public List<Product> findAll() {
        return productsDao.findAll();
    }

    public Product save(Product product) {
        return productsDao.save(product);
    }

    public Product buscarPorId (Long id){
    Product productX= productsDao.findById(id).get();
    return productX;
    }

    public Product updateProduct (Product product){
    Optional<Product> optionalProduct =productsDao.findById(product.getId());
        if (optionalProduct.isPresent()) {
            Product updateProduct = optionalProduct.get();
            updateProduct.setName(product.getName());
            return productsDao.save(updateProduct);
        } else {
            return null;
        }
    }

    public  void  deleteById (Long id){
        productsDao.deleteById(id);
    }
}

