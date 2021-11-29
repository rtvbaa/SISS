package com.solidsystems.siss.service;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.controller.model.Sale;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.SaleRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import com.solidsystems.siss.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public List<Sale> getAll() {
        List<Sale> saleList = new ArrayList<>();
        for (SaleEntity saleEntity : saleRepository.findAll()) {
            List<Product> products = new ArrayList<>();
            for (ProductEntity productEntity : saleEntity.getProducts()) {
                products.add(new Product(productEntity.getId(),
                                productEntity.getProductName(),
                                productEntity.getProductPrice()));
            }
            saleList.add(new Sale(saleEntity.getId(), saleEntity.getSaleDate(), saleEntity.getDiscountId(), products));
        }
        return saleList;
    }

    public SaleEntity add(String products, String discountId) {
        if (products.equals("")) {
            throw new ApiRequestException("products cannot be empty.");
        }
        if (discountId.equals("")) {
            throw new ApiRequestException("discountId cannot be empty.");
        }
        SaleEntity saleEntity = new SaleEntity();
        List<ProductEntity> productEntityList = new ArrayList<>();
        for (String product: products.split(" ")) {
            productEntityList.add(productRepository.getById(Long.parseLong(product)));
        }
        saleEntity.setProducts(productEntityList);
        saleEntity.setDiscountId(Long.parseLong(discountId));
        saleEntity.setSaleDate(new Date());
        return saleRepository.save(saleEntity);
    }
}