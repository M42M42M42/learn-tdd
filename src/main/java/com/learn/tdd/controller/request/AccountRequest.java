package com.learn.tdd.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountRequest {
    private static final String USERNAME_ERROR = "用户名错误";
    @NotNull(message = USERNAME_ERROR)
    @Length(min = 6, message = USERNAME_ERROR)
    private String username;
    private String password;
}
