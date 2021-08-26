package com.solidsystems.siss.dao;

import com.solidsystems.siss.dao.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<ProductEntity, Long> {
}
