package com.ajsw.javareserveservice.repositories.interfaces;

import com.ajsw.javareserveservice.models.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IReserveRepository extends JpaRepository<Reserve, Integer> {
    }

