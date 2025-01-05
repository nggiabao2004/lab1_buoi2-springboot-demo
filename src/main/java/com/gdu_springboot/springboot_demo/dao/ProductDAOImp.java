//lab1_buoi2
package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class ProductDAOImp implements ProductDAO {

    private EntityManager em;

    public ProductDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    @Transactional
    public void delete(Product product) { em.remove(em.contains(product) ? product: em.merge(product));    }

    @Override
    public Product findById(int id) { return em.find(Product.class, id); }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product>query = em.createQuery("select p from Product p where p.name = :theName", Product.class);
        query.setParameter("theName", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRows = em.createQuery("delete from Product").executeUpdate();
        return numRows;
    }
}
