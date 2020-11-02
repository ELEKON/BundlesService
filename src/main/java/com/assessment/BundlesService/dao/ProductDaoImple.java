package com.assessment.BundlesService.dao;

import com.assessment.BundlesService.Entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDaoImple implements ProductDao {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void createProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void deleteProduct(String code) {
        entityManager.createQuery("delete from Product p where p.productCode=: code")
                .setParameter("code", code).executeUpdate();
    }

    @Override
    public List<Product> getProductByName(String searchName) {
        return entityManager.createQuery("select p from Product p where p.name =: searchName", Product.class)
                .setParameter("searchName", searchName).getResultList();
    }


    public List<Product> getProductByAscendingPrice() {
        return entityManager.createQuery("select p from Product p order by p.productPrice", Product.class)
                .getResultList();

    }

    public List<Product> getProductByDiscendingPrice() {
        return entityManager.createQuery("select p from Product p order by p.productPrice desc", Product.class)
                .getResultList();
    }

    public Product getProductByCode(String searchCode) {
        return entityManager.createQuery("select p from Product p where p.productCode =:searchCode", Product.class)
                .setParameter("searchCode", searchCode).getSingleResult();

    }

    @Override
    public boolean checkProductCodeAvailability(String code) {
        return entityManager.createQuery("select p from Product p where p.productCode =:searchCode", Product.class)
                .setParameter("searchCode", code).getResultList().isEmpty();
    }

}

