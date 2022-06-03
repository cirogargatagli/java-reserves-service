package com.ajsw.javareserveservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class ReserveResponseDto {
    @Getter
    @Setter
    public String email;

    @Getter
    @Setter
    public Date createdAt;

    @Getter
    @Setter
    public boolean active;

}
