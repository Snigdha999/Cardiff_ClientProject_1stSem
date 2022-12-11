package com.project.repository;

import com.project.model.Accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByUsername(String username);
}
