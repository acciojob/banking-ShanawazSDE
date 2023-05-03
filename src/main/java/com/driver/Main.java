package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount bankAccount = new BankAccount("ram",0,0);
        System.out.println(bankAccount.generateAccountNumber(10,100));

        CurrentAccount currentAccount = new CurrentAccount("raju",20000,"aaabbbc");
        currentAccount.validateLicenseId();
        System.out.println(currentAccount.getTradeLicenseId());

    }
}