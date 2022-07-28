package com.learn.tdd.controller;

import com.learn.tdd.controller.request.AccountRequest;
import com.learn.tdd.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping("/register")
    public void register(@RequestBody AccountRequest account) {
        accountService.register(account.getUsername(), account.getPassword());
    }
}
