package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.ReviewDetails;
import com.speproject.majorproject.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/review")
public class ReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addReview")
    public ReviewDetails addReview(@RequestBody ReviewDetails reviewDetails){
        logger.info("Adding new review.");
        return reviewService.addReview(reviewDetails);
    }

    @GetMapping("/getAllReview")
    public List<ReviewDetails> getAllReview(){
        logger.info("Fetching all review.");
        return reviewService.getAllReview();
    }

    @GetMapping("/getReviewByBook/{id}")
    public List<ReviewDetails> getAllReviewByBookId(@PathVariable("id") Long bookId){
        logger.info("Fetching rentals for book with id: {}", bookId);
        return reviewService.getAllReviewByBookId(bookId);
    }

    @GetMapping("/getReviewByUser/{id}")
    public List<ReviewDetails> getAllReviewByUserId(@PathVariable("id") Long userId){
        logger.info("Fetching rentals for user with id: {}", userId);
        return reviewService.getAllReviewByUserId(userId);
    }
}
