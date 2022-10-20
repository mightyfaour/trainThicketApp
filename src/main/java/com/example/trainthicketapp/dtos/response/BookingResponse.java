package com.example.trainthicketapp.dtos.response;

import com.example.trainthicketapp.model.data.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingResponse {

    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;

}
