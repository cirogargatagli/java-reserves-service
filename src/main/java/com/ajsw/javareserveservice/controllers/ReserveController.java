package com.ajsw.javareserveservice.controllers;

import com.ajsw.javareserveservice.models.dto.request.ReserveRequest;
import com.ajsw.javareserveservice.models.dto.response.ReserveResponseDto;
import com.ajsw.javareserveservice.models.dto.response.Response;
import com.ajsw.javareserveservice.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService _reserveService){
        reserveService = _reserveService;
    }

    @PostMapping()
    public Response createReserve(@Validated @RequestBody ReserveRequest reserveRequest){
        try {
            return reserveService.saveReserve(reserveRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @PutMapping()
    public Response updateReserve(@Validated @RequestBody ReserveRequest reserveRequest) {
        try {
            return reserveService.saveReserve(reserveRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteReserve(@PathVariable int id){
        try {
            return reserveService.deleteReserve(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @GetMapping("/{id}")
    public ReserveResponseDto getReserveById(@PathVariable int id){
        try {
            return reserveService.getReserveById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @GetMapping("/user/{idUser}")
    public List<ReserveResponseDto> getReservesByUser(@PathVariable int idUser){
        try {
            return reserveService.getReservesByUser(idUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}