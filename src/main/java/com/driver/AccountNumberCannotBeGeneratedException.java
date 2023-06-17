package com.driver;

public class AccountNumberCannotBeGeneratedException extends RuntimeException {
    public AccountNumberCannotBeGeneratedException(String s) {
        super(s);
    }
}
