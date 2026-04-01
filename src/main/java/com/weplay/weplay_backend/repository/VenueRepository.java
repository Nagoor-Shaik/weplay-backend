package com.weplay.weplay_backend.repository;

import com.weplay.weplay_backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findBySport(String sport);
    List<Venue> findByLocation(String location);
}