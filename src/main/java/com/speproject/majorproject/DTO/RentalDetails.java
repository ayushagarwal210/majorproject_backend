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
public class RentalDetails {
    private Long rentalId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date rentalDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dueDate;

    private Long bookId;
    private Long userId;
}
