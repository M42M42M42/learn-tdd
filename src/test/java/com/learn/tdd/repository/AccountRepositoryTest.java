package com.learn.tdd.repository;


import com.learn.tdd.BaseRepositoryTest;
import com.learn.tdd.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccountRepositoryTest extends BaseRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void should_return_account_when_find_by_username_given_an_exist_username() {
        // given
        Account account = new Account("test", "password");

        // when
        accountRepository.save(account);

        // then
        dbAssertThat("select * from accounts where username='test'").hasNumberOfRows(1);
    }
}