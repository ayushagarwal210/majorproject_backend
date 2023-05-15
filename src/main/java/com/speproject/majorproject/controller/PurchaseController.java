package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.PurchaseDetail;
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
    public PurchaseDetail addPurchase(@RequestBody PurchaseDetails purchase){
        logger.info("Adding a new purchase.");

//
        return purchaseService.addPurchase(purchase);
    }
    @GetMapping("/getPurchases")
    public List<PurchaseDetail> getPurchases(){
        logger.info("Fetching all purchases.");
        return purchaseService.getAllPurchases();
    }
//    @GetMapping("/getPurchases")
//    public List<PurchaseDetails> getPurchases(){
//        logger.info("Fetching all purchases.");
//        return purchaseService.getAllPurchases();
//    }
//
    @GetMapping("/getPurchases/{id}")
    public PurchaseDetail getPurchasesByPurchaseId(@PathVariable("id") Long userId){
        logger.info("Fetching purchases for user with id: {}", userId);
        return purchaseService.getPurchasesByPurchaseId(userId);
    }
    @GetMapping("/getAllPurchases/{id}")
    public List<PurchaseDetail> getPurchasesByUserId(@PathVariable("id") Long userId){
        logger.info("Fetching purchases for user with id: {}", userId);
        return purchaseService.getAllPurchasesByUserId(userId);
    }
//    @DeleteMapping("/deletePurchaseById/{id}")
//    public String deleteBookById(@PathVariable("id") Long purchaseId) {
//        purchaseService.deletePurchaseById(purchaseId);
//        return "Department deleted successfully";
//    }
}
