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
public class ReviewDetails {
    private Long reviewId;
    private Double rating;
    private String comment;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reviewDate;

    private Long bookId;

    private Long userId;
}
