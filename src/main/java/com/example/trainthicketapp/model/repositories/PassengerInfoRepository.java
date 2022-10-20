package com.example.trainthicketapp.model.repositories;

import com.example.trainthicketapp.model.data.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository <PassengerInfo, Long > {
}
