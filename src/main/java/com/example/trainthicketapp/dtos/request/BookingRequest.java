package com.example.trainthicketapp.dtos.request;

import com.example.trainthicketapp.model.data.PassengerInfo;
import com.example.trainthicketapp.model.data.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String destination;
    private String arrivalTime;
    private PaymentInfo paymentInfo;

}
