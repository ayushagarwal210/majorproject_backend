package com.speproject.majorproject.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long purchaseItemId;


    @ManyToOne
    @JoinColumn(
            name = "purchase_id",
            referencedColumnName = "purchaseId"
    )
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Book book;

    private String quantity;

}
