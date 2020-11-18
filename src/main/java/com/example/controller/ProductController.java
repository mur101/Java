package com.example.controller;

import com.example.domain.Products;
import com.example.repository.ProductRepository;
import com.example.services.ProductServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value="Контроллер управления продуктами")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Вывод всех продуктов")
    @GetMapping("/show_products")
    public List getAllProducts(){
        return productRepository.findAll();
    }

    @ApiOperation(value = "Вывод информации об одном продукте")
    @GetMapping("/show_product_id/{id}")
    public List getProductId(@PathVariable("id") Long ProductId){
        LOGGER.info("Информация о продукте загружена");
        return productRepository.findByProductId(ProductId);
    }

    @ApiOperation(value = "Поиск продукта")
    @GetMapping("/find_products/{product_name}")
    public List<Products> getProductName(@PathVariable("product_name") String ProductName){
        LOGGER.info("Информация о продукте загружена");
        return productRepository.findByProductNameStartingWithIgnoreCase(ProductName);
    }
}
