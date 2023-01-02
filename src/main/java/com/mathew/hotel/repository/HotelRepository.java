package com.mathew.hotel.repository;

import com.mathew.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Serializable> {

}