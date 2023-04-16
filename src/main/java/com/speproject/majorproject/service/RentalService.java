package com.speproject.majorproject.service;

import com.speproject.majorproject.DTO.RentalDetails;

import java.util.List;

public interface RentalService {
    RentalDetails addRentals(RentalDetails rentalDetails);

    List<RentalDetails> getAllRentals();

    List<RentalDetails> getRentalsByUserId(Long userId);
}
