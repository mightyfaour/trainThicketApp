package com.example.trainthicketapp.services;

import com.example.trainthicketapp.dtos.request.BookingRequest;
import com.example.trainthicketapp.dtos.response.BookingResponse;
import com.example.trainthicketapp.exception.InsufficientBalanceException;

public interface BookingService {

    public BookingResponse bookTicket(BookingRequest BookingRequest) throws InsufficientBalanceException;
}
