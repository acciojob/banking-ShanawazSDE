package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
   private double withDrawCount;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        withDrawCount = 0;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(withDrawCount > maxWithdrawalLimit) throw new MaximumWithdrawLimitExceededException("Maximum Withdraw Limit Exceed");
        if(amount > getBalance()) throw new InsufficientBalanceException("Insufficient Balance");

        withDrawCount++;
        setBalance(getBalance() - amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return getBalance() + rate * getBalance() * years;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
           return getBalance() * Math.pow(1 + rate / times, years*times);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getWithDrawCount() {
        return withDrawCount;
    }

    public void setWithDrawCount(double withDrawCount) {
        this.withDrawCount = withDrawCount;
    }
}
