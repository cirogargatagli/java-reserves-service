package com.ajsw.javareserveservice.models.dto.response;

import com.ajsw.javareserveservice.models.entities.Client;
import com.ajsw.javareserveservice.models.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class ReserveResponseDto {
    @Getter
    @Setter
    private int idReserve;

    @Getter
    @Setter
    private Timestamp createdAt;

    @Getter
    @Setter
    private CourseResponseDto course;

}
