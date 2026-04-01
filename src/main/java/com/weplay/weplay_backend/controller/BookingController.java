package com.weplay.weplay_backend.controller;

import com.weplay.weplay_backend.model.Booking;
import com.weplay.weplay_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestBody Booking booking) {
        Booking created = bookingService.createBooking(booking);
        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(
                bookingService.getBookingsByUser(userId));
    }

    @GetMapping("/venue/{venueId}")
    public ResponseEntity<List<Booking>> getBookingsByVenue(
            @PathVariable Long venueId) {
        return ResponseEntity.ok(
                bookingService.getBookingsByVenue(venueId));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}