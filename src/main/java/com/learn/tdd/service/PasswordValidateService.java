package com.learn.tdd.service;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class PasswordValidateService {
    public static final String SUCCESS = "SUCCESS";
    private static final String SPECIAL_STRING = "!@#$%&+=:;";

    /**
     * 1. 长度在12-24之间
     *  2. 必需同时包含大写字母、小写字母、数字、特殊字符
     *  3. 特殊字符只能是括号中内容：[!@#$%&+=:;]
     *  4. 不能有两个以上的连续字母和数字，比如：123，abc是不被允许的
     *  5. 字符不能重复超过两次，比如：111，222，aaa是不被允许的
     * @param password password
     * @return message
     */
    public String validate(byte[] password) {
        if (password == null) {
            return "密码长度必需在12~24";
        }
        if (password.length < 12 || password.length > 24) {
            return "密码长度必需在12~24";
        }

        boolean hasUpperLetter = false;
        for (byte b : password) {
            if (b >= 'A' && b <= 'Z') {
                hasUpperLetter = true;
                break;
            }
        }

        if (!hasUpperLetter) {
            return "密码必需包含大写字母、小写字母、数字和特殊字符";
        }

        boolean hasLowercaseLetter = false;
        for (byte b : password) {
            if (b >= 'a' && b <= 'z') {
                hasLowercaseLetter = true;
                break;
            }
        }
        if (!hasLowercaseLetter) {
            return "密码必需包含大写字母、小写字母、数字和特殊字符";
        }

        boolean hasNumber = false;
        for (byte b : password) {
            if (b >= '0' && b <= '9') {
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber) {
            return "密码必需包含大写字母、小写字母、数字和特殊字符";
        }

        boolean hasSpecialLetter = false;
        for (byte b : password) {
            byte[] specialBytes = SPECIAL_STRING.getBytes(StandardCharsets.UTF_8);
            for (byte specialByte : specialBytes) {
                if (b == specialByte) {
                    hasSpecialLetter = true;
                    break;
                }
            }
            if (hasSpecialLetter) {
                break;
            }
        }
        if (!hasSpecialLetter) {
            return "密码必需包含大写字母、小写字母、数字和特殊字符";
        }

        boolean hasUnexpectedLetter = false;
        for (byte b : password) {
            if (b >= 'a' && b <= 'z') {
                continue;
            }
            if (b >= 'A' && b <= 'Z') {
                continue;
            }
            if (b >= '0' && b <= '9') {
                continue;
            }
            byte[] specialBytes = SPECIAL_STRING.getBytes(StandardCharsets.UTF_8);
            boolean isSpecialLetter = false;
            for (byte specialByte : specialBytes) {
                if (b == specialByte) {
                    isSpecialLetter = true;
                    break;
                }
            }
            if (!isSpecialLetter) {
                hasUnexpectedLetter = true;
                break;
            }
        }
        if (hasUnexpectedLetter) {
            return "特殊字符只能包含：!@#$%&+=:;";
        }

        boolean isHaveContinuousLetter = false;
        if (password.length > 2) {
            for (int index = 2; index < password.length; index++) {
                if (Math.abs(password[index] - password[index-1]) == 1 && Math.abs(password[index - 1] - password[index - 2]) == 1) {
                    isHaveContinuousLetter = true;
                    break;
                }
            }
        }
        if (isHaveContinuousLetter) {
            return "连续字符不能超过两个";
        }

        boolean isHaveRepeatLetter = false;
        if (password.length > 2) {
            for (int index = 2; index < password.length; index++) {
                if (password[index] == password[index-1] && password[index - 1] == password[index - 2]) {
                    isHaveRepeatLetter = true;
                    break;
                }
            }
        }
        if (isHaveRepeatLetter) {
            return "连续相同字符不能超过两个";
        }

        return SUCCESS;
    }
}
