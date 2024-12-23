package com.pdi.attendeemgmt.controller;

import com.pdi.attendeemgmt.model.Guest;
import com.pdi.attendeemgmt.service.GuestService;
import com.pdi.attendeemgmt.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService guestService;
    private final EmailService emailService;

    public GuestController(GuestService guestService, EmailService emailService) {
        this.guestService = guestService;
        this.emailService = emailService;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    @PostMapping
    public ResponseEntity<Guest> createOrUpdateGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.createOrUpdateGuest(guest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public List<Guest> filterGuestsByStatus(@RequestParam String status) {
        return guestService.filterGuestsByStatus(status);
    }

//    @PostMapping("/invite")
//    public ResponseEntity<String> sendInvitation(@RequestParam Long guestId, @RequestParam String subject, @RequestParam String body) {
//        Guest guest = guestService.getGuestById(guestId);
//        emailService.sendEmail(guest.getEmail(), subject, body);
//        return ResponseEntity.ok("Invitation sent to " + guest.getName());
//    }
}

