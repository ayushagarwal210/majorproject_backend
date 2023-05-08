package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.RentalDetails;
import com.speproject.majorproject.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/rental")
public class RentalController {

    private static final Logger logger = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @PostMapping("/addRental")
    public RentalDetails addRentals(@RequestBody RentalDetails rentalDetails){
        logger.info("Adding a new rental.");
        return rentalService.addRentals(rentalDetails);
    }

    @GetMapping("/getAllRentals")
    public List<RentalDetails> getRentals(){
        logger.info("Fetching all rentals.");
        return rentalService.getAllRentals();
    }

    @GetMapping("/getAllRentals/{id}")
    public List<RentalDetails> getRentalsByUserId(@PathVariable("id") Long userId){
        logger.info("Fetching rentals for user with id: {}", userId);
        return rentalService.getRentalsByUserId(userId);
    }
}
