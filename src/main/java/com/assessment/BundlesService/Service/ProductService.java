package com.assessment.BundlesService.Service;

import com.assessment.BundlesService.Entities.Product;
import com.assessment.BundlesService.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@Transactional

public class ProductService {

    @Autowired
    private ProductDao productDao;


    public void createProduct(Product product ){
        productDao.createProduct(product);
    }
}
