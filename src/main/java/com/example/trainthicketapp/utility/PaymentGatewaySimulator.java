package com.example.trainthicketapp.utility;

import com.example.trainthicketapp.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewaySimulator {
    private static Map<String,Double> accountBalanceMap = new HashMap<>();

    {
        accountBalanceMap.put("acnt - 1212", 2000.00);
        accountBalanceMap.put("acnt - 1313", 5000.00);
        accountBalanceMap.put("acnt - 1414", 3000.00);
    }

    public static boolean validateFareBalanceCriteria(String accountNo, Double fare) throws InsufficientBalanceException {
        if (fare > accountBalanceMap.get(accountNo)){
            throw new InsufficientBalanceException("You do not have sufficient balance in your account" );

        }
        return true;
    }
}
