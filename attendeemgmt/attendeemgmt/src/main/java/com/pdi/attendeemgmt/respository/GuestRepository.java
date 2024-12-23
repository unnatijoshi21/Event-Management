package com.pdi.attendeemgmt.respository;

import com.pdi.attendeemgmt.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(String status);
}
