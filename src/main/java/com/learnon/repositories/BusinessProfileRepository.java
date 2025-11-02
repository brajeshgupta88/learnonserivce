package com.learnon.repositories;

import com.learnon.entities.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface BusinessProfileRepository extends JpaRepository<BusinessProfile, UUID> {
}
