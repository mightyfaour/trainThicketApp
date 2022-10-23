package com.example.trainthicketapp.services;

import com.example.trainthicketapp.dtos.request.BookingRequest;
import com.example.trainthicketapp.dtos.response.BookingResponse;
import com.example.trainthicketapp.exception.InsufficientBalanceException;
import com.example.trainthicketapp.model.data.Booking;
import com.example.trainthicketapp.model.data.PassengerInfo;
import com.example.trainthicketapp.model.data.PaymentInfo;
import com.example.trainthicketapp.model.repositories.PassengerInfoRepository;
import com.example.trainthicketapp.model.repositories.PaymentInfoRepository;
import com.example.trainthicketapp.utility.PaymentGatewaySimulator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Getter
@Setter
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    public BookingResponse bookTicket(BookingRequest BookingRequest) throws InsufficientBalanceException {
        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepository.save(BookingRequest.getPassengerInfo());

        PaymentInfo paymentInfo = BookingRequest.getPaymentInfo();

        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getId());

        paymentInfo.setTotalFare(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

    }
    public BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficientBalanceException {

        Booking booking = new Booking();
        booking.setDestination(bookingRequest.getDestination());
        booking.setFare(BigDecimal.valueOf(2500.00));
        booking.setExitTime("3 PM");
        booking.setArrivalTime("6 PM");
        booking.setPassengerNames(bookingRequest.getFirstName() + " " + bookingRequest.getLastName());

        PassengerInfo passenger = new PassengerInfo();
        passenger.setDestination(bookingRequest.getDestination());
        passenger.setArrivalTime(bookingRequest.getArrivalTime());
        passenger.setFirstName(bookingRequest.getFirstName());
        passenger.setLastName(bookingRequest.getLastName());
        passenger.setEmail(bookingRequest.getEmail());
        passenger.setFare(booking.getFare());

        booking.setPassengerId(passenger.getId());
        Booking passengerBooked = bookingRepository.save(booking);

        BookingResponse response = modelMapper.map(passengerBooked, Booking.class);
        return response;

    }
}
