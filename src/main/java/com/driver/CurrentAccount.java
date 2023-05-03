package com.driver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance < 5000) throw new InsufficientBalanceException("Insufficient Balance");
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!tradeLicenseId.equals(tradeLicenseId.toUpperCase()))throw new ValidLicenseCannotBeGeneratedException("Valid License can not be generated");
        int size = tradeLicenseId.length();


        if(!valid(size)){
            Map<Character,Integer> map = new HashMap<>();
            int maxFreq = populateMap(tradeLicenseId,map);


            if((size % 2 == 0 && maxFreq > size/2) || (size % 2 != 0 && maxFreq > (size+1)/2))throw new ValidLicenseCannotBeGeneratedException("Valid License can not be generated");

            tradeLicenseId = makeValidLicense(size,map);
        }


    }

    public String makeValidLicense(int size, Map<Character,Integer> map){
        char[] array = new char[size];
        int index = 0;
        for(Character key : map.keySet()){
            int count = map.get(key);
            while(count > 0){
                array[index] = key;
                index += 2;
                if(index >= size) index = 1;

                count--;
            }
        }
        return new String(array);
    }

    private int populateMap(String tradeLicenseId, Map<Character, Integer> map) {
        int size = tradeLicenseId.length();
        int maxFreq = 0;
        for (int i = 0; i < size; i++){
            Character key = tradeLicenseId.charAt(i);
            map.put(key,map.getOrDefault(key,0)+1);
            maxFreq = Math.max(maxFreq,map.get(key));
        }
        return maxFreq;
    }

    public boolean valid(int size){
         size = tradeLicenseId.length();
        for(int i = 0; i < size - 1; i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)) return false;
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}
