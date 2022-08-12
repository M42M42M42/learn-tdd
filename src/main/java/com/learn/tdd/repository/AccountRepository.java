package com.learn.tdd.repository;

import com.learn.tdd.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUsername(String username);

    @Query(value = "select password from accounts where username = ?1", nativeQuery = true)
    Optional<String> findPasswordByUsername(String username);
}
