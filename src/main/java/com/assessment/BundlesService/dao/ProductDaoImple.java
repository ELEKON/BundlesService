package com.assessment.BundlesService.dao;

import com.assessment.BundlesService.Entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProductDaoImple implements ProductDao {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void createProduct(Product product) {
        entityManager.persist(product);
    }
}
