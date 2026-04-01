package com.weplay.weplay_backend.service;

import com.weplay.weplay_backend.model.Venue;
import com.weplay.weplay_backend.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public List<Venue> getVenuesBySport(String sport) {
        return venueRepository.findBySport(sport);
    }

    public Venue getVenueById(Long id) {
        return venueRepository.findById(id).orElse(null);
    }
}