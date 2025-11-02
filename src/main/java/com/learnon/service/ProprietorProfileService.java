package com.learnon.service;

import com.learnon.model.dto.ProprietorProfileDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProprietorProfileService {
    ProprietorProfileDTO create(ProprietorProfileDTO dto);
    Optional<ProprietorProfileDTO> findById(UUID id);
    Optional<ProprietorProfileDTO> findByUserId(UUID userId);
    List<ProprietorProfileDTO> findAll();
    Optional<ProprietorProfileDTO> update(UUID id, ProprietorProfileDTO dto);
    void deleteById(UUID id);
}