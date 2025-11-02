package com.learnon.repositories;

import com.learnon.entities.StaffAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface StaffAvailabilityRepository extends JpaRepository<StaffAvailability, UUID> {
}
