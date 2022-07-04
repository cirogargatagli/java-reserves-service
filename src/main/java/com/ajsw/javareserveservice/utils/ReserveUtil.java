package com.ajsw.javareserveservice.utils;

import com.ajsw.javareserveservice.models.dto.request.ReserveRequest;
import com.ajsw.javareserveservice.models.entities.Client;
import com.ajsw.javareserveservice.models.entities.Course;
import com.ajsw.javareserveservice.models.entities.Payment;
import com.ajsw.javareserveservice.models.entities.Reserve;
import org.springframework.stereotype.Component;


@Component
public class ReserveUtil {

    public Reserve createReserve(ReserveRequest request){
        return new Reserve(
            new Course(request.getIdCourse()),
            new Client(request.getIdClient()),
            new Payment(request.getIdPayment())
        );
    }
}

