package com.learnon.repositories;

import com.learnon.entities.ProprietorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProprietorProfileRepository extends JpaRepository<ProprietorProfile, UUID> {
}
