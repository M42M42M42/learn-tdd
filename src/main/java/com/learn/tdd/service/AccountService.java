package com.learn.tdd.service;

import com.learn.tdd.entity.Account;
import com.learn.tdd.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void register(String username, String password) {
        accountRepository.save(new Account(username, password));
    }
}
