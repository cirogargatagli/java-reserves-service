package com.ajsw.javareserveservice.services;

import com.ajsw.javareserveservice.models.dto.request.ReserveRequest;
import com.ajsw.javareserveservice.models.dto.response.ReserveResponseDto;
import com.ajsw.javareserveservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javareserveservice.models.dto.response.Response;
import com.ajsw.javareserveservice.models.entities.Reserve;
import com.ajsw.javareserveservice.models.mappers.ListMapper;
import com.ajsw.javareserveservice.repositories.interfaces.IReserveRepository;
import com.ajsw.javareserveservice.utils.ReserveUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {
    private final IReserveRepository reserveRepository;
    private final ReserveUtil reserveUtil;
    private final String nameEntity = "Reserve";
    private final ModelMapper mapper;
    private final ListMapper listMapper;

    @Autowired
    public ReserveService(IReserveRepository reserveRepository, ReserveUtil reserveUtil, ModelMapper mapper, ListMapper listMapper){
        this.reserveRepository = reserveRepository;
        this.reserveUtil = reserveUtil;
        this.mapper = mapper;
        this.listMapper = listMapper;
    }

    public Response saveReserve(ReserveRequest reserveRequest){

        Reserve reserve = reserveUtil.createReserve(reserveRequest);

        Reserve reserveCreated = reserveRepository.save(reserve);

        return new EntityCreatedResponse(reserveCreated.getIdReserve(), nameEntity);
    }

    public ReserveResponseDto getReserveById(int id){
        return mapper.map(reserveRepository.findById(id).get(), ReserveResponseDto.class);
    }

    public List<ReserveResponseDto> getReservesByUser(int id){
        return listMapper.mapList(reserveRepository.findReservesByClient_IdPerson(id), ReserveResponseDto.class);
    }

    public Response deleteReserve(int id) {
        reserveRepository.deleteById(id);
        return new Response(200, "Reserve deleted successfully");
    }
}

