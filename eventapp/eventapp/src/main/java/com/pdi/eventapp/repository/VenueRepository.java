package com.pdi.eventapp.repository;

import com.pdi.eventapp.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    Optional<Venue> findByNameAndBookingDate(String name, LocalDate date);
}

