package com.learnon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "csat_feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CSATFeedback extends BaseAuditEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comments", columnDefinition = "text")
    private String comments;
}
