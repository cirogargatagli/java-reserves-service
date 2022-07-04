package com.ajsw.javareserveservice.repositories.interfaces;

import com.ajsw.javareserveservice.models.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IReserveRepository extends JpaRepository<Reserve, Integer> {
    List<Reserve> findReservesByClient_IdPerson(int id);
}

