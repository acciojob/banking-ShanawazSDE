package com.driver;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String insufficient_funds) {
        super(insufficient_funds);
    }
}
