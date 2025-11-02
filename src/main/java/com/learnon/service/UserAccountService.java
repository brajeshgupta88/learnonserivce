package com.learnon.service;

import com.learnon.model.dto.UserAccountDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserAccountService {
    UserAccountDTO create(UserAccountDTO dto);
    Optional<UserAccountDTO> findById(String id);
    List<UserAccountDTO> findAll();
    Optional<UserAccountDTO> update(String id, UserAccountDTO dto);
    void deleteById(String id);
    boolean existsById(String id);
}