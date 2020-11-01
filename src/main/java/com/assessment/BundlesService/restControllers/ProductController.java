package com.assessment.BundlesService.restControllers;

import com.assessment.BundlesService.Entities.Product;
import com.assessment.BundlesService.Service.ProductService;
import com.assessment.BundlesService.dao.ProductDao;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("product")
@Validated
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(
    value = "/create",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduct( @RequestBody @Valid Product product){
        JSONObject response = new JSONObject();
        try{
            productService.createProduct(product);
            response.put("response", "successfully inserted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ep){
            response.put("response", "server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
