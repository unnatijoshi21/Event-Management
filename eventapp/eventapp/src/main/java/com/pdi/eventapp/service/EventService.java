package com.pdi.eventapp.service;

import com.pdi.eventapp.exception.ConflictException;
import com.pdi.eventapp.model.Event;
import com.pdi.eventapp.model.Venue;
import com.pdi.eventapp.repository.EventRepository;
import com.pdi.eventapp.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    public EventService(EventRepository eventRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }

    public Event createEvent(Event event) {
        checkVenueConflict(event.getVenue(), event.getDate());
        return eventRepository.save(event);
    }

    private void checkVenueConflict(String venue, LocalDate date) {
        Optional<Venue> existingBooking = venueRepository.findByNameAndBookingDate(venue, date);
        if (existingBooking.isPresent()) {
            throw new ConflictException("Venue is already booked on this date: " + date);
        }
    }
}

