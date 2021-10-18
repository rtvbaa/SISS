package com.solidsystems.siss.dao;

import com.solidsystems.siss.dao.model.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<StatisticsEntity, Long> {
}
