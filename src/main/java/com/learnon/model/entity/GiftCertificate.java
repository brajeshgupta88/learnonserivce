package com.learnon.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gift_certificate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftCertificate extends BaseAuditEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "redeemed")
    private Boolean redeemed;
}
