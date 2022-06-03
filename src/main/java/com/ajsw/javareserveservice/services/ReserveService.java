package com.ajsw.javareserveservice.services;

import com.ajsw.javareserveservice.models.dto.request.ReserveRequest;
import com.ajsw.javareserveservice.models.dto.request.ReserveRequestDto;
import com.ajsw.javareserveservice.models.dto.response.ReserveResponseDto;
import com.ajsw.javareserveservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javareserveservice.models.dto.response.Response;
import com.ajsw.javareserveservice.models.entities.Client;
import com.ajsw.javareserveservice.models.entities.Reserve;
import com.ajsw.javareserveservice.repositories.interfaces.IReserveRepository;
import com.ajsw.javareserveservice.utils.ReserveUtil;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class ReserveService {
    private final IReserveRepository reserveRepository;
    private final ReserveUtil reserveUtil;
    private final String nameEntity = "Reserve";
    private final ModelMapper mapper;

    @Autowired
    public ReserveService(IReserveRepository reserveRepository, ReserveUtil reserveUtil, ModelMapper mapper){
        this.reserveRepository = reserveRepository;
        this.reserveUtil = reserveUtil;
        this.mapper = mapper;
    }

    public Response saveReserve(ReserveRequestDto reserveRequestDto){

        //String idClient = String.valueOf(reserveRequestDto.getIdClient());
        //Client client;

        //WebClient webClient = WebClient.builder()
         //       .baseUrl("http://localhost:8080")
             //   .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
             //   .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
           //     .build();

        //client = webClient.get()
          //      .uri("/api/clients/?id="+idClient)
                //.body(Mono.just(request), ClientRequest.class)
          //      .retrieve()
          //      .bodyToMono(Client.class)
          //      .timeout(Duration.ofSeconds(3))  // timeout
          //      .block();


        //String cadena = "{client: "+ client.getFirstName()+
        //                ",course: "+reserveRequestDto.getIdCourse()+
        //                ",payment: "+reserveRequestDto.getIdClient()+
         //               "}";
        //Response response = new Response(200, cadena );
        //return response;


        Reserve reserve = reserveUtil.createReserve(reserveRequestDto);
        //capaz este no lo necesitas, o bien le pasas los objetos posta

        Reserve reserveCreated = reserveRepository.save(reserve);


        return new EntityCreatedResponse(reserveCreated.getIdReserve(), nameEntity);
    }

    public Reserve getReserveById(int id){
        return reserveRepository.findById(id).get();
    }
}

