package com.learn.tdd.service;

import com.learn.tdd.BaseUnitTest;
import com.learn.tdd.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class AccountServiceTest extends BaseUnitTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountService accountService;

    @Test
    void should_register_success_when_register_given_username_and_password_valid() {
        // given when then
        accountService.register("TestUser", "password001");
    }
}
