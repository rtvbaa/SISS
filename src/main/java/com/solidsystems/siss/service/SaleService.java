package com.solidsystems.siss.service;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.controller.model.Sale;
import com.solidsystems.siss.dao.SaleRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Collection<Sale> getAll() {
        Collection<Sale> saleList = new ArrayList<>();
        for (SaleEntity saleEntity : saleRepository.findAll()) {
            Collection<Product> products = new ArrayList<>();
            for (ProductEntity productEntity: saleEntity.getProducts()) {
                products.add(new Product(productEntity.getId(), productEntity.getProductName(), productEntity.getProductPrice()));
            }
            saleList.add(new Sale(saleEntity.getId(), saleEntity.getSaleDate(), saleEntity.getDiscountId(), products));
        }
        return saleList;
    }

    public SaleEntity add(Sale sale) {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setDiscountId(sale.getDiscountId());
        saleEntity.setSaleDate(new Date());
        return saleRepository.save(saleEntity);
    }
}