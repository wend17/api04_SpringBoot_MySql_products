package com.demoapi.demo_api4.rest;

import com.demoapi.demo_api4.dao.ProductsDao;
import com.demoapi.demo_api4.entity.Product;
import com.demoapi.demo_api4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsRest {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        var products = productService.findAll();
        if (products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product>createProduct(@RequestBody Product product){
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
        return new ResponseEntity<>(productService.buscarPorId(productId),HttpStatus.OK);
    }

   @PutMapping("/update")
    public ResponseEntity<Product>updateProduct(@RequestBody Product product){
       return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
    }

  @DeleteMapping("/{productId}")
    public ResponseEntity<Product>deleteProduct(@PathVariable("productId") Long productId){
    productService.deleteById(productId);
    return ResponseEntity.ok(null);

    }



  /*http://localhost:8080/swagger-ui/index.html#/*/

}


