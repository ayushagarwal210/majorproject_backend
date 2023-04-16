package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.PurchaseDetails;
import com.speproject.majorproject.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/addPurchase")
    public PurchaseDetails addPurchase(@RequestBody PurchaseDetails purchase){
        return purchaseService.addPurchase(purchase);
    }

    @GetMapping("/getPurchases")
    public List<PurchaseDetails> getPurchases(){
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/getPurchases/{id}")
    public List<PurchaseDetails> getPurchasesByUserId(@PathVariable("id") Long userId){
        return purchaseService.getAllPurchasesByUserId(userId);
    }
}
