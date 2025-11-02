package com.learnon.service.impl;

import com.learnon.model.entity.UserAccount;
import com.learnon.model.dto.UserAccountDTO;
import com.learnon.repository.UserAccountRepository;
import com.learnon.service.UserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccountDTO create(UserAccountDTO dto) {
        UserAccount u = toEntity(dto);
        UserAccount saved = repo.save(u);
        return toDto(saved);
    }

    @Override
    public Optional<UserAccountDTO> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repo.findById(uuid).map(this::toDto);
    }

    @Override
    public List<UserAccountDTO> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserAccountDTO> update(String id, UserAccountDTO dto) {
     UUID uuid = UUID.fromString(id);
  
        return repo.findById(uuid).map(existing -> {
            if (dto.getEmail() != null) existing.setEmail(dto.getEmail());
         //   if (dto.getFirstName() != null) existing.setLastName(dto.getFirstName());
         //   if (dto.getLastName() != null) existing.setLastName(dto.getLastName());
            if (dto.getPassword() != null && !dto.getPassword().isBlank()) existing.setPasswordHash(dto.getPassword());
            UserAccount saved = repo.save(existing);
            return toDto(saved);
        });
    }

    @Override
    public void deleteById(String id) {
           UUID uuid = UUID.fromString(id);
        repo.deleteById(uuid);
    }

    @Override
    public boolean existsById(String id) {
           UUID uuid = UUID.fromString(id);
        return repo.existsById(uuid);
    }

    // helpers
    private UserAccountDTO toDto(UserAccount u) {
        UserAccountDTO dto = new UserAccountDTO();
        dto.setId(u.getId().toString());
        dto.setEmail(u.getEmail());
     //   dto.setFirstName(u.getFirstName());
     //   dto.setLastName(u.getLastName());
        dto.setPassword(u.getPasswordHash()); // avoid exposing password in real APIs
     //   dto.setCreatedAt(u.getCreatedAt());
        return dto;
    }

    private UserAccount toEntity(UserAccountDTO dto) {
        UserAccount u = new UserAccount();

       // UUID uuid = UUID.fromString(dto.getId());

        UUID uuid = UUID.randomUUID();
        u.setId(uuid);
        u.setEmail(dto.getEmail());
      //  u.setLastName(dto.getFirstName());
      //  u.setLastName(dto.getLastName());
        u.setPasswordHash(dto.getPassword());
        u.setRole("Customer");
        return u;
    }
}