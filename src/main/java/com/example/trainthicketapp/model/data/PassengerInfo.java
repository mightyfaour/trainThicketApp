package com.example.trainthicketapp.model.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PASSENGER_INFO")
public class PassengerInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String source;
    private String destination;
    private String pickUpTime;
    private String arrivalTime;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")

    private Date travelDate;
    private BigDecimal fare;
}
