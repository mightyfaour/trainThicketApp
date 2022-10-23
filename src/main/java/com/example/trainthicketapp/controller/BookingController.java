package com.example.trainthicketapp.controller;

import com.example.trainthicketapp.dtos.request.BookingRequest;
import com.example.trainthicketapp.dtos.response.BookingResponse;
import com.example.trainthicketapp.exception.InsufficientBalanceException;
import com.example.trainthicketapp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book-ticket")
    public BookingResponse makeBooking(BookingRequest bookingRequest) throws InsufficientBalanceException {
        BookingResponse response = bookingService.bookTicket(bookingRequest);
        return response;
    }

    @PostMapping("/ticket-booker")
    public BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficientBalanceException {
        return bookingService.bookTicket(bookingRequest);
    }
}
