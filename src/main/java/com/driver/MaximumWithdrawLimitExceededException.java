package com.driver;

public class MaximumWithdrawLimitExceededException extends RuntimeException {
    public MaximumWithdrawLimitExceededException(String s) {
        super(s);
    }
}
