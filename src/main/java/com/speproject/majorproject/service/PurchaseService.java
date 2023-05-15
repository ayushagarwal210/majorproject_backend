package com.speproject.majorproject.service;

import com.speproject.majorproject.DTO.PurchaseDetail;
import com.speproject.majorproject.DTO.PurchaseDetails;

import java.util.List;

public interface PurchaseService {
    PurchaseDetail addPurchase(PurchaseDetails purchase);

//    List<PurchaseDetails> getAllPurchases();
//
    List<PurchaseDetail> getAllPurchasesByUserId(Long userId);

    List<PurchaseDetail> getAllPurchases();
    PurchaseDetail getPurchasesByPurchaseId(Long purchaseId);

    void deletePurchaseById(Long purchaseId);
}
