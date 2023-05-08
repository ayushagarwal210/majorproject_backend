package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.PurchaseDetails;
import com.speproject.majorproject.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/purchase")
public class PurchaseController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/addPurchase")
    public PurchaseDetails addPurchase(@RequestBody PurchaseDetails purchase){
        logger.info("Adding a new purchase.");
        return purchaseService.addPurchase(purchase);
    }

    @GetMapping("/getPurchases")
    public List<PurchaseDetails> getPurchases(){
        logger.info("Fetching all purchases.");
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/getPurchases/{id}")
    public List<PurchaseDetails> getPurchasesByUserId(@PathVariable("id") Long userId){
        logger.info("Fetching purchases for user with id: {}", userId);
        return purchaseService.getAllPurchasesByUserId(userId);
    }
}
