package com.solidsystems.siss.service;

import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

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