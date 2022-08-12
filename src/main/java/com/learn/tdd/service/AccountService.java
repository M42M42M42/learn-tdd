package com.learn.tdd.service;

import com.learn.tdd.entity.Account;
import com.learn.tdd.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void register(String username, String password) {
        if (accountRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("用户名已使用");
        }
        accountRepository.save(new Account(username, password));
    }

    public void login(String username, String password) {
        Optional<String> result = accountRepository.findPasswordByUsername(username);
        if (result.isPresent() && result.get().equals(password)) {
            return;
        }
        throw new RuntimeException("用户名或密码错误");
    }
}
