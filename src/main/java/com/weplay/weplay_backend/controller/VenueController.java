package com.weplay.weplay_backend.controller;

import com.weplay.weplay_backend.model.Venue;
import com.weplay.weplay_backend.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/venues")
@CrossOrigin(origins = "*")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue) {
        return ResponseEntity.ok(venueService.addVenue(venue));
    }

    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        return ResponseEntity.ok(venueService.getVenueById(id));
    }

    @GetMapping("/sport/{sport}")
    public ResponseEntity<List<Venue>> getVenuesBySport(
            @PathVariable String sport) {
        return ResponseEntity.ok(venueService.getVenuesBySport(sport));
    }
}