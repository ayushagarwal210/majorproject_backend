package com.speproject.majorproject.controller;

import com.speproject.majorproject.DTO.ReviewDetails;
import com.speproject.majorproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addReview")
    public ReviewDetails addReview(@RequestBody ReviewDetails reviewDetails){
        return reviewService.addReview(reviewDetails);
    }

    @GetMapping("/getAllReview")
    public List<ReviewDetails> getAllReview(){
        return reviewService.getAllReview();
    }

    @GetMapping("/getReviewByBook/{id}")
    public List<ReviewDetails> getAllReviewByBookId(@PathVariable("id") Long bookId){
        return reviewService.getAllReviewByBookId(bookId);
    }

    @GetMapping("/getReviewByUser/{id}")
    public List<ReviewDetails> getAllReviewByUserId(@PathVariable("id") Long userId){
        return reviewService.getAllReviewByUserId(userId);
    }
}
