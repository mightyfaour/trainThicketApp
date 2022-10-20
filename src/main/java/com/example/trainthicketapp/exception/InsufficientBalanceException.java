package com.example.trainthicketapp.exception;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String errMsg){
        super(errMsg);
    }
}
