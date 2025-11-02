package com.learnon.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;
import com.learnon.model.entity.enums.BusinessType;
import com.learnon.model.entity.enums.RegistrationStatus;

@Entity
@Table(name = "service_provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider extends BaseAuditEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "proprietor_id", nullable = false)
    private ProprietorProfile proprietor;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_type")
    private BusinessType businessType;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "timezone")
    private String timezone;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_status")
    private RegistrationStatus registrationStatus;
}
