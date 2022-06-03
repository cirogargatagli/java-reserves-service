package com.ajsw.javareserveservice.utils;

import com.ajsw.javareserveservice.models.dto.request.ReserveRequestDto;
import com.ajsw.javareserveservice.models.entities.Client;
import com.ajsw.javareserveservice.models.entities.Course;
import com.ajsw.javareserveservice.models.entities.Payment;
import com.ajsw.javareserveservice.models.entities.Reserve;
import org.springframework.stereotype.Component;


@Component
public class ReserveUtil {

        public Reserve createReserve(ReserveRequestDto reserveRequestDto){


            return new Reserve(
                    new Course(reserveRequestDto.getIdCourse()),
                    new Client(reserveRequestDto.getIdClient()),
                    new Payment(reserveRequestDto.getIdPayment())
            );
    }
}

