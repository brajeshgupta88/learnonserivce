package com.learnon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "proprietor_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProprietorProfile extends BaseAuditEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "yr_of_experience")
    private Integer yrOfExperience;

    @Column(name = "about", columnDefinition = "text")
    private String about;

    @Column(name = "address", columnDefinition = "text")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip")
    private String zip;
}
