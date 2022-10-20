package com.example.trainthicketapp.model.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PASSENGER_INFO")
public class PassengerInfo {
    @javax.persistence.Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String secondName;
    private String email;
    private String source;
    private String destination;
    private String pickUpTime;
    private String arrivalTime;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")

    private Date travelDate;
    private double TotalFare;


}
