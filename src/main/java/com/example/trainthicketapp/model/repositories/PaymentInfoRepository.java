package com.example.trainthicketapp.model.repositories;

import com.example.trainthicketapp.model.data.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
