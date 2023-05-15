package com.speproject.majorproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseItemList {
    private Long bookId;
    private String quantity;
    private Double price;
    private String image;
    public  String bookTitle;
}
