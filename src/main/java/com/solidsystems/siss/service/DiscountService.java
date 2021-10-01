package com.solidsystems.siss.service;

import com.solidsystems.siss.dao.DiscountRepository;
import com.solidsystems.siss.dao.model.DiscountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<DiscountEntity> getAll() {
        return discountRepository.findAll();
    }
}
