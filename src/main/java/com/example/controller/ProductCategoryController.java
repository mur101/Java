package com.example.controller;

import com.example.repository.ProductCategoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value="Контроллер управления категориями продуктами")
public class ProductCategoryController {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @ApiOperation(value = "Вывод категорий продуктов")
    @GetMapping("/show_product_category")
    public List getAllProducts(){
        return productCategoryRepository.findAll();
    }

    @ApiOperation(value = "Вывод категории продукта")
    @GetMapping("/show_product_category_id/{id}")
    public List getProductCategory(@PathVariable("id") Long ProductCategoryId){
        return productCategoryRepository.findByProductCategoryId(ProductCategoryId);
    }

}