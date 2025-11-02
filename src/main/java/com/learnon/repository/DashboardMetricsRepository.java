package com.learnon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnon.model.entity.DashboardMetrics;

import java.util.UUID;

@Repository
public interface DashboardMetricsRepository extends JpaRepository<DashboardMetrics, UUID> {
}
