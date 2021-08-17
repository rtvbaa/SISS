package com.solidsystems.siss.dao;

import com.solidsystems.siss.dao.model.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDB, Long> {
}
