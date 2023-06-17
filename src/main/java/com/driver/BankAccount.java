package com.driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    private Set<String> currentAccounts;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
        currentAccounts = new HashSet<>();
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum > (9 * digits) || sum < 0) throw new Exception("Account Number can not be generated");
        List<String> list = new ArrayList<>();
        generateAllPossibleAccountNumbers(digits,sum,"",list);

        String acc = "";
        for(String s : list){
            if(!currentAccounts.contains(s)){
                acc = s;
                currentAccounts.add(s);
                break;
            }
        }
        if (acc.isEmpty()){
            throw new Exception("Account Number can not be generated");
        }
        return acc;

    }

    private void generateAllPossibleAccountNumbers(int digits, int sum, String temp, List<String> list) {
        if(digits == 0){
            if(sum == 0){
                list.add(temp);
            }
            return;
        }
        for(int i = 0; i <= 9; i++){
            generateAllPossibleAccountNumbers(digits-1,sum-i,temp+i,list);
        }
    }



    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double rem = balance - amount;
        if(rem < minBalance)throw new Exception("Insufficient Balance");
        else{
            balance = rem;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}