package com.ajsw.javareserveservice.controllers;

import com.ajsw.javareserveservice.models.dto.request.ReserveRequest;
//import com.ajsw.javareserveservice.models.dto.response.ReserveResponseDto;
import com.ajsw.javareserveservice.models.dto.request.ReserveRequestDto;
import com.ajsw.javareserveservice.models.dto.response.Response;
//import com.ajsw.javareserveservice.models.entities.Reserve;
import com.ajsw.javareserveservice.services.ReserveService;
//import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//import java.util.List;

@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService _reserveService){
        reserveService = _reserveService;
    }

    @PostMapping()
    public Response createReserve(@Validated @RequestBody ReserveRequestDto reserveRequestDto){
        try {
            return reserveService.saveReserve(reserveRequestDto);
            //Si descomentas la linea de arriba y dejas esta te das cuenta que hasta aca llega
            //Response response = new Response(200,"course:"+ reserveRequestDto.getIdCourse());
            //return response;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    // microservice up&running test
    @GetMapping()
    public Response getReserve(){
            Response response = new Response(200,"el endpoint funciona! asdfalskjdfhlak");
            return response;
    }

}