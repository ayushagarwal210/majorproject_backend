package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.RentalDetails;
import com.speproject.majorproject.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/addRental")
    public RentalDetails addRentals(@RequestBody RentalDetails rentalDetails){
        return rentalService.addRentals(rentalDetails);
    }

    @GetMapping("/getAllRentals")
    public List<RentalDetails> getRentals(){
        return rentalService.getAllRentals();
    }

    @GetMapping("/getAllRentals/{id}")
    public List<RentalDetails> getRentalsByUserId(@PathVariable("id") Long userId){
        return rentalService.getRentalsByUserId(userId);
    }
}
