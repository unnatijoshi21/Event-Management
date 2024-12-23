package com.pdi.attendeemgmt.service;

import com.pdi.attendeemgmt.exception.ResourceNotFoundException;
import com.pdi.attendeemgmt.model.Guest;
import com.pdi.attendeemgmt.respository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id " + id));
    }

    public Guest createOrUpdateGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        Guest guest = getGuestById(id);
        guestRepository.delete(guest);
    }

    public List<Guest> filterGuestsByStatus(String status) {
        return guestRepository.findByStatus(status);
    }
}

