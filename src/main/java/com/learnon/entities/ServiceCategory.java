package com.learnon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;
import com.learnon.entities.enums.CategoryType;
import com.learnon.entities.enums.SubCategoryType;

@Entity
@Table(name = "service_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCategory extends BaseAuditEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryType category;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_category")
    private SubCategoryType subCategory;

    @Column(name = "description", columnDefinition = "text")
    private String description;
}
