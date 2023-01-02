package com.mathew.hotel.web;


import com.mathew.hotel.entity.Hotel;
import com.mathew.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createResponse = hotelService.save(hotel);
        return new ResponseEntity<>(createResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        Hotel updateResponse = hotelService.update(hotel);
        return new ResponseEntity<>(updateResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        Hotel getResponse = hotelService.get(id);
        return new ResponseEntity<>(getResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable String id) {
        hotelService.delete(id);
        return "Record deleted succesfully";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getUsers() {
        List<Hotel> getAllResponse = hotelService.getAllHotels();
        return new ResponseEntity<>(getAllResponse, HttpStatus.ACCEPTED);
    }
}
