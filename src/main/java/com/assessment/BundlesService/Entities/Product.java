package com.assessment.BundlesService.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "name can not be null")
    @Size(max = 100)
    @Column(name = "product_name")
    private String name;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;

    @NotBlank
    @Column(name = "product_code", unique = true)
    private String productCode;

    @FutureOrPresent
    @Column(name = "product_expiration_date")
    private LocalDate productExpirationDate;

    @NotNull
    @FutureOrPresent
    @Column(name = "availability_date")
    private LocalDate availabilityDate;

    public Product(String name, BigDecimal productPrice, String productCode, LocalDate productExpirationDate, LocalDate availabilityDate) {
        this.name = name;
        this.productPrice = productPrice;
        this.productCode = productCode;
        this.productExpirationDate = productExpirationDate;
        this.availabilityDate = availabilityDate;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public LocalDate getProductExpirationDate() {
        return productExpirationDate;
    }

    public void setProductExpirationDate(LocalDate productExpirationDate) {
        this.productExpirationDate = productExpirationDate;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }
}
