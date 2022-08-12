package com.learn.tdd.repository;


import com.learn.tdd.BaseRepositoryTest;
import com.learn.tdd.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class AccountRepositoryTest extends BaseRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void should_save_success_when_save_given_an_username_and_password() {
        // given
        Account account = new Account("TestUser", "password");

        // when
        accountRepository.save(account);

        // then
        dbAssertThat("select * from accounts where username='TestUser'").hasNumberOfRows(1);
    }

    @Test
    @Sql("classpath:sql/insertUserToDb.sql")
    void should_return_account_when_findByUsername_given_and_exist_username() {
        // when
        Optional<Account> account = accountRepository.findByUsername("TestUser");

        // then
        assertThat(account.isPresent()).isTrue();
    }

    @Test
    @Sql("classpath:sql/insertUserToDb.sql")
    void should_return_password_when_findPasswordByUsername_given_an_exist_username() {
        // when
        Optional<String> password = accountRepository.findPasswordByUsername("TestUser");

        // then
        assertThat(password.isPresent()).isTrue();
    }

    @Test
    @Sql("classpath:sql/insertUserToDb.sql")
    void should_return_empty_when_findPasswordByUsername_given_an_unregistered_username() {
        // when
        Optional<String> password = accountRepository.findPasswordByUsername("TestUser001");

        // then
        assertThat(password.isPresent()).isFalse();
    }
}