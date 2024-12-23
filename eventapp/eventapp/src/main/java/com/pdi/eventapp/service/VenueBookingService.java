package com.pdi.eventapp.service;

import com.pdi.eventapp.model.Venue;
import com.pdi.eventapp.repository.VenueRepository;
import org.springframework.stereotype.Service;

@Service
public class VenueBookingService {

    private final VenueRepository venueRepository;

    public VenueBookingService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Venue bookVenue(Venue venue) {
        return venueRepository.save(venue);
    }
}

