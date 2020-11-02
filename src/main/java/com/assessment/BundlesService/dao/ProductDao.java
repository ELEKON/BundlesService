package com.assessment.BundlesService.dao;

import com.assessment.BundlesService.Entities.Product;
import java.util.List;

public interface ProductDao {

    void createProduct(Product product);
    void deleteProduct(String code);
    List<Product> getProductByName(String name);
    Product getProductByCode(String code);
    boolean checkProductCodeAvailability(String code);
    List<Product> getProductByAscendingPrice();
    List<Product> getProductByDiscendingPrice();

}
