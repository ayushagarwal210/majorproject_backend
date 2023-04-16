package com.speproject.majorproject.repository;

import com.speproject.majorproject.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
