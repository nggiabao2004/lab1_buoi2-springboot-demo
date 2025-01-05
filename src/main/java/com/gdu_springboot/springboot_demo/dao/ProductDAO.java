//lab1_buoi2
package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product);
    void update(Product product);
    void delete(Product product);
    Product findById(int id);
    List<Product> findAll();
    List<Product> findByName(String name);
    int deleteAll();

}
