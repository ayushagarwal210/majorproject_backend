package com.speproject.majorproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDetails {
    private Long purchaseId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date purchaseDate;
    private Long bookId;
    private Long userId;
}
