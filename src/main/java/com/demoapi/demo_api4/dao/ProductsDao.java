package com.demoapi.demo_api4.dao;

import com.demoapi.demo_api4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDao extends JpaRepository<Product,Long> {
}
