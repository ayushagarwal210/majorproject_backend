package com.speproject.majorproject.service;

import com.speproject.majorproject.DTO.ReviewDetails;

import java.util.List;

public interface ReviewService {
    ReviewDetails addReview(ReviewDetails reviewDetails);

    List<ReviewDetails> getAllReview();

    List<ReviewDetails> getAllReviewByBookId(Long bookId);

    List<ReviewDetails> getAllReviewByUserId(Long userId);
}
