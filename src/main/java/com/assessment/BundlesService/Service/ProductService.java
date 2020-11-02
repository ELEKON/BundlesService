package com.assessment.BundlesService.Service;

import com.assessment.BundlesService.Entities.Product;
import com.assessment.BundlesService.SelectionEnum;
import com.assessment.BundlesService.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public void createProduct(Product product) {
        productDao.createProduct(product);

    }
    public void deleteProduct(String code) {
        productDao.deleteProduct(code);

    }


    public List<Product> getProductByName(String name) {
        return productDao.getProductByName(name);
    }

    public List<Product> getProductByPrice(String choice) {
        if (choice.equals(SelectionEnum.ASCENDING.getChoice())) {
            return productDao.getProductByAscendingPrice();
        } else if (choice.equals(SelectionEnum.DISCENDING.getChoice())) {
            return productDao.getProductByDiscendingPrice();
        } else {
            return null;
        }
    }

    public Product getProductByCode(String code) {
        return productDao.getProductByCode(code);
    }
}
