package com.mathew.hotel.service;

import com.mathew.hotel.entity.Hotel;
import com.mathew.hotel.exception.HotelNotFoundException;
import com.mathew.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        Optional<Hotel> byId = Optional.ofNullable(hotelRepository.findById(hotel.getId()).orElseThrow(() -> new HotelNotFoundException("Unable to update Hotel. Invalid hotelId: " + hotel.getId())));
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel get(String id) {
        Optional<Hotel> byId = Optional.ofNullable(hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("No Records Found Invalid hotelId: " + id)));
        return byId.get();
    }

    @Override
    public void delete(String id) {
        Optional<Hotel> byId = Optional.ofNullable(hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Unable to delete Hotel. Invalid hotelId: " + id)));
        hotelRepository.delete(byId.get());
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
