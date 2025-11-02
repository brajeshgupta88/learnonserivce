package com.learnon.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;
import java.math.BigDecimal;

@Entity
@Table(name = "dashboard_metrics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardMetrics extends BaseAuditEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ServiceProvider provider;

    @Column(name = "total_customers")
    private Integer totalCustomers;

    @Column(name = "total_enrollments")
    private Integer totalEnrollments;

    @Column(name = "avg_csat")
    private BigDecimal avgCsat;

    @Column(name = "revenue")
    private BigDecimal revenue;
}
