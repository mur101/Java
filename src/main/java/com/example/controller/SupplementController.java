package com.example.controller;

import com.example.domain.Supplements;
import com.example.repository.SupplementRepository;
import com.example.services.SupplementServices;
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
@Api(value="Контроллер управления пищевыми добавками")
public class SupplementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    SupplementRepository supplementRepository;

    @Autowired
    SupplementServices supplementServices;

    @ApiOperation(value = "Вывод пищевых добавок")
    @GetMapping("/show_supplements")
    public List getAllProducts(){
        return supplementRepository.findAll();
    }

    @ApiOperation(value = "Вывод информации об одной пищевой добавке")
    @GetMapping("/show_supplement_id/{id}")
    public List getSupplementId(@PathVariable("id") Long SupplementId){
        return supplementRepository.findBySupplementId(SupplementId);
    }
    @ApiOperation(value = "Поиск добавки")
    @GetMapping("/find_supplement/{supplement_name}")
    public List<Supplements> findSupplement(@PathVariable("supplement_name") String SupplementCode){
        return supplementServices.findSupplements(SupplementCode);
    }
}

