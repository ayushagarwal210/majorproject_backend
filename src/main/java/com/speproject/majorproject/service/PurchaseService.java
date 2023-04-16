package com.speproject.majorproject.service;

import com.speproject.majorproject.DTO.PurchaseDetails;

import java.util.List;

public interface PurchaseService {
    PurchaseDetails addPurchase(PurchaseDetails purchase);

    List<PurchaseDetails> getAllPurchases();

    List<PurchaseDetails> getAllPurchasesByUserId(Long userId);
}
