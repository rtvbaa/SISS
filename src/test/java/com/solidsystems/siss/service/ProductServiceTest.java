package com.solidsystems.siss.service;

import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;


    @MockBean
    ProductRepository productRepository;

    ProductEntity productEntity1 = new ProductEntity("Meat", 1000, Arrays.asList(new SaleEntity(), new SaleEntity()));
    ProductEntity productEntity2 = new ProductEntity("Fish", 900, Arrays.asList(new SaleEntity(), new SaleEntity()));

    @Test
    void add() {
    }

    @Test
    void getAll() {
        List<ProductEntity> records = new ArrayList<>(Arrays.asList(productEntity1, productEntity2));
        Mockito.when(productRepository.findAll()).thenReturn(records);

        Assertions.assertEquals(productService.getAll().size(), 2);
        Assertions.assertEquals(productService.getAll().get(0).getProductName(),"Meat");
        Assertions.assertEquals(productService.getAll().get(1).getProductName(),"Fish");
    }
}