package com.driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    Set<String> tradeIdSet ;
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        tradeIdSet = new HashSet<>();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
       if(!isValid(tradeLicenseId)){
           List<String> list = getAllPermutations(tradeLicenseId);
           for(String id : list){
               if(isValid(id) && !tradeIdSet.contains(id)){
                   tradeLicenseId = id;
                   tradeIdSet.add(id);
               }
           }
           if(!isValid(tradeLicenseId)){
               throw new Exception("Valid License can not be generated");
           }
       }
    }
    private boolean isValid(String id){
        int len = id.length();

        for(int i = 1; i < len; i++){
            if(id.charAt(i) == id.charAt(i-1))return false;
        }
        return true;
    }


    private List<String> getAllPermutations(String s){
        if(s.length() == 1){
            return List.of(s);
        }
        List<String> res = getAllPermutations(s.substring(1));
        List<String> ans = new ArrayList<>();
        char c = s.charAt(0);

        for(String str : res){
            ans.add(c+str);
            for(int i = 1; i < str.length(); i++){
                ans.add(str.substring(0,i)+c+str.substring(i));
            }
            ans.add(str+c);
        }
        return ans;


    }

}
