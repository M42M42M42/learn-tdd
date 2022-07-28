package com.learn.tdd.controller;

import com.learn.tdd.BaseApiTest;
import com.learn.tdd.controller.request.AccountRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.equalTo;

public class AccountControllerTest extends BaseApiTest {

    @Test
    void should_register_success_when_register_given_valid_username_and_valid_password() {
        // given
        AccountRequest request = new AccountRequest();
        request.setUsername("TestUser");
        request.setPassword("password001");

        // when
        given().body(request).post("/accounts/register").then().status(HttpStatus.OK);

        // then
        dbAssertThat("select * from accounts where username = ?", request.getUsername()).hasNumberOfRows(1);
    }

    @Test
    @Sql("classpath:sql/insertUserToDb.sql")
    void should_return_400_when_register_given_exist_username_and_valid_password() {
        // given
        AccountRequest request = new AccountRequest();
        request.setUsername("TestUser");
        request.setPassword("password001");

        // when
        given().body(request).post("/accounts/register").then().status(HttpStatus.BAD_REQUEST)
                .body(equalTo("用户名已使用"));
    }
}
