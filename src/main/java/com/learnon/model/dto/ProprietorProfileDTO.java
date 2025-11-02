package com.learnon.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProprietorProfileDTO {
    private UUID id;
    private UUID userId;
    private String firstName;
    private String lastName;
    private Integer yearOfExperience;
    private String about;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String createdDate;
    private String modifiedDate;
    private String createdBy;
    private String modifiedBy;
}