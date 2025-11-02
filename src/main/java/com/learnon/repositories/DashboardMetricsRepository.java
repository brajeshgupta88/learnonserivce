package com.learnon.repositories;

import com.learnon.entities.DashboardMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DashboardMetricsRepository extends JpaRepository<DashboardMetrics, UUID> {
}
