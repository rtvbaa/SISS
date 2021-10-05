package com.solidsystems.siss.service;

import com.solidsystems.siss.controller.model.Sale;
import com.solidsystems.siss.dao.SaleRepository;
import com.solidsystems.siss.dao.model.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<SaleEntity> getAll() {
        return saleRepository.findAll();
    }

    public SaleEntity add(Sale sale) {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setDiscountId(sale.getDiscountId());
        saleEntity.setSaleDate(new Date());
        return saleRepository.save(saleEntity);
    }
}