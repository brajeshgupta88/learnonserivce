package com.learnon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnon.model.entity.ServiceProvider;

import java.util.UUID;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, UUID> {
}
