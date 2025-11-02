package com.learnon.repository;

import com.learnon.model.entity.ProprietorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.Optional;

@Repository
public interface ProprietorProfileRepository extends JpaRepository<ProprietorProfile, UUID> {
    Optional<ProprietorProfile> findByUserAccountId(UUID userId);
}
