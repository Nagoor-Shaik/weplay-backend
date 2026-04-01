package com.weplay.weplay_backend.service;

import com.weplay.weplay_backend.model.Booking;
import com.weplay.weplay_backend.model.Venue;
import com.weplay.weplay_backend.repository.BookingRepository;
import com.weplay.weplay_backend.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VenueRepository venueRepository;

    public Booking createBooking(Booking booking) {
        Venue venue = venueRepository.findById(
                booking.getVenueId()).orElse(null);
        if (venue == null) return null;

        long hours = booking.getStartTime()
                .until(booking.getEndTime(),
                        java.time.temporal.ChronoUnit.HOURS);
        booking.setTotalPrice(venue.getPricePerHour() * hours);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByVenue(Long venueId) {
        return bookingRepository.findByVenueId(venueId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}