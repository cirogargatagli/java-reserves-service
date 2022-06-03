package com.ajsw.javareserveservice.models.dto.request;

import com.ajsw.javareserveservice.models.entities.Client;
import com.ajsw.javareserveservice.models.entities.Course;
import com.ajsw.javareserveservice.models.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

public class ReserveRequestDto {
    @Getter
    @Setter
    //public Course course;
    int idCourse;

    @Getter
    @Setter
    //public Client client;
    int idClient;

    @Getter
    @Setter
    //public Payment payment;
    int idPayment;


}
