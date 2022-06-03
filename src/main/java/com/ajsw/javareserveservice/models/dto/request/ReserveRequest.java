package com.ajsw.javareserveservice.models.dto.request;

import com.ajsw.javareserveservice.models.entities.Client;
import com.ajsw.javareserveservice.models.entities.Course;
import com.ajsw.javareserveservice.models.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class ReserveRequest {

    @Getter
    @Setter
    public Timestamp createdAt;

    @Getter
    @Setter
    public Course course;

    @Getter
    @Setter
    public Client client;

    @Getter
    @Setter
    public Payment payment;

}
