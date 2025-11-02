package com.learnon.service.impl;

import com.learnon.model.entity.ProprietorProfile;
import com.learnon.model.dto.ProprietorProfileDTO;
import com.learnon.repository.ProprietorProfileRepository;
import com.learnon.repository.UserAccountRepository;
import com.learnon.service.ProprietorProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProprietorProfileServiceImpl implements ProprietorProfileService {

    private final ProprietorProfileRepository profileRepo;
    private final UserAccountRepository userRepo;

    public ProprietorProfileServiceImpl(ProprietorProfileRepository profileRepo, 
                                      UserAccountRepository userRepo) {
        this.profileRepo = profileRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ProprietorProfileDTO create(ProprietorProfileDTO dto) {
        ProprietorProfile entity = toEntity(dto);
        userRepo.findById(dto.getUserId()).ifPresent(entity::setUserAccount);
        ProprietorProfile saved = profileRepo.save(entity);
        return toDto(saved);
    }

    @Override
    public Optional<ProprietorProfileDTO> findById(UUID id) {
        return profileRepo.findById(id).map(this::toDto);
    }

    @Override
    public Optional<ProprietorProfileDTO> findByUserId(UUID userId) {
        return profileRepo.findByUserAccountId(userId).map(this::toDto);
    }

    @Override
    public List<ProprietorProfileDTO> findAll() {
        return profileRepo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProprietorProfileDTO> update(UUID id, ProprietorProfileDTO dto) {
        return profileRepo.findById(id).map(existing -> {
            if (dto.getFirstName() != null) existing.setFirstName(dto.getFirstName());
            if (dto.getLastName() != null) existing.setLastName(dto.getLastName());
            if (dto.getYearOfExperience() != null) existing.setYearOfExperience(dto.getYearOfExperience());
            if (dto.getAbout() != null) existing.setAbout(dto.getAbout());
            if (dto.getAddress() != null) existing.setAddress(dto.getAddress());
            if (dto.getCity() != null) existing.setCity(dto.getCity());
            if (dto.getState() != null) existing.setState(dto.getState());
            if (dto.getCountry() != null) existing.setCountry(dto.getCountry());
            if (dto.getZip() != null) existing.setZip(dto.getZip());
            return toDto(profileRepo.save(existing));
        });
    }

    @Override
    public void deleteById(UUID id) {
        profileRepo.deleteById(id);
    }

    private ProprietorProfileDTO toDto(ProprietorProfile entity) {
        ProprietorProfileDTO dto = new ProprietorProfileDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserAccount().getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setYearOfExperience(entity.getYearOfExperience());
        dto.setAbout(entity.getAbout());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setCountry(entity.getCountry());
        dto.setZip(entity.getZip());
        return dto;
    }

    private ProprietorProfile toEntity(ProprietorProfileDTO dto) {
        ProprietorProfile entity = new ProprietorProfile();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setYearOfExperience(dto.getYearOfExperience());
        entity.setAbout(dto.getAbout());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setZip(dto.getZip());
        return entity;
    }
}