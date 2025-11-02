package com.learnon.repositories;

import com.learnon.entities.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, UUID> {
}
