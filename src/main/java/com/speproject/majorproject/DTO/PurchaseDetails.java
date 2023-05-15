package com.speproject.majorproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDetails {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date purchaseDate;
    private Long userId;
    private String address;
    private String city;
    private String pincode;
    private String country;
    private String paymentMethod;
    private double shippingPrice;
    private double taxPrice;
    private double totalPrice;
    private List<PurchaseItemList> purchaseItemsList;

}
