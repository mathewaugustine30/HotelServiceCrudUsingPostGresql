package com.mathew.hotel.service;

import com.mathew.hotel.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HotelService {
	public Hotel save(Hotel hotel);
	public Hotel update(Hotel hotel);
	public Hotel get(String id);
	public void delete(String id);
	public List<Hotel> getAllHotels();
}