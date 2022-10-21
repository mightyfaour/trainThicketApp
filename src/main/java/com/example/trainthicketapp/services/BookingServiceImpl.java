package com.example.trainthicketapp.services;

import com.example.trainthicketapp.dtos.request.BookingRequest;
import com.example.trainthicketapp.dtos.response.BookingResponse;
import com.example.trainthicketapp.exception.InsufficientBalanceException;
import com.example.trainthicketapp.model.data.PassengerInfo;
import com.example.trainthicketapp.model.data.PaymentInfo;
import com.example.trainthicketapp.model.repositories.PassengerInfoRepository;
import com.example.trainthicketapp.model.repositories.PaymentInfoRepository;
import com.example.trainthicketapp.utility.PaymentGatewaySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    public BookingResponse bookTicket(BookingRequest BookingRequest) throws InsufficientBalanceException {
        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = PassengerInfoRepository.save(BookingRequest.getPassengerInfo());

        PaymentInfo paymentInfo = BookingRequest.getPaymentInfo();

        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), passengerInfo.getTotalFare());

        paymentInfo.setPassengerId(passengerInfo.getId());

        paymentInfo.setFare();

        paymentInfoRepository.save(paymentInfo);

    }
}
