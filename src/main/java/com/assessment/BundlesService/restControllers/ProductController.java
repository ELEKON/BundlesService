package com.assessment.BundlesService.restControllers;

import com.assessment.BundlesService.Entities.Product;
import com.assessment.BundlesService.SelectionEnum;
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
import java.util.List;

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
            response.put("response", "Product code already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(
            value="/getProductByName",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProductByName( @RequestParam(name = "name") @NotNull String name){
        try{
            List<Product> productByName = productService.getProductByName(name);
            return new ResponseEntity<>(productByName, HttpStatus.OK);
        }catch (Exception ep){
            JSONObject response = new JSONObject();
            response.put("response", "server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(
            value="/getProductByCode",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProductByCode( @RequestParam(name = "code") @NotNull String code){
        try{
            Product productByCode = productService.getProductByCode(code);
            return new ResponseEntity<>(productByCode, HttpStatus.OK);
        }catch (Exception ep){
            JSONObject response = new JSONObject();
            response.put("response", "server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(
            value="/deleteProductByCode",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProductByCode( @RequestParam(name = "code") @NotNull String code){
        JSONObject response = new JSONObject();
        try{
            productService.deleteProduct(code);
            response.put("response", "successfully deactivated");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ep){
            response.put("response", "server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(
            value="/getProductByPrice",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProductByPrice(@RequestParam(name = "choice")SelectionEnum selectionEnum){

        try{
            List<Product> productByPrice = productService.getProductByPrice(selectionEnum.getChoice());
            return new ResponseEntity<>(productByPrice, HttpStatus.OK);
        }catch (Exception ep){
            JSONObject response = new JSONObject();
            response.put("response", "server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
