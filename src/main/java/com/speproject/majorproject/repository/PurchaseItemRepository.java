package com.speproject.majorproject.repository;

import com.speproject.majorproject.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem,Long> {

    @Query("DELETE FROM PurchaseItem pi WHERE pi.purchase.purchaseId = :purchaseId")
    void deleteByPurchaseId(@Param("purchaseId") Long purchaseId);

}
