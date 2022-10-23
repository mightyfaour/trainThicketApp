package com.example.trainthicketapp.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {

    @Id
    @GeneratedValue(generator = "UUID2")
    @GenericGenerator(name="UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true)
    private String paymentId;
    private String accountNo;
    private double amount;
    private Cardtype cardType;
    private long passengerId;


}
