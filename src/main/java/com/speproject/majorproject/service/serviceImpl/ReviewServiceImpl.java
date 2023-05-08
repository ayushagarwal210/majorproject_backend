package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.DTO.ReviewDetails;
import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.Review;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.repository.ReviewRepository;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.ReviewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final Logger logger = LogManager.getLogger(ReviewServiceImpl.class);
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ReviewDetails addReview(ReviewDetails reviewDetails) {
        Book book;
        User user;
        if(bookRepository.findById(reviewDetails.getBookId()).isPresent()
                && userRepository.findById(reviewDetails.getUserId()).isPresent()){
            book = bookRepository.findById(reviewDetails.getBookId()).get();
            user=userRepository.findById(reviewDetails.getUserId()).get();
            Review review=Review.builder()
                    .reviewDate(reviewDetails.getReviewDate())
                    .rating(reviewDetails.getRating())
                    .comment(reviewDetails.getComment())
                    .book(book)
                    .user(user)
                    .build();
            reviewDetails.setReviewId(review.getReviewId());
            reviewRepository.save(review);
            logger.info("Added review with id " + review.getReviewId());
            return reviewDetails;
        }
        logger.error("Unable to add review. Either the book or user does not exist.");
        return null;
    }

    @Override
    public List<ReviewDetails> getAllReview() {
        List<ReviewDetails> reviewDetailsList=new ArrayList<>();
        List<Review>reviews=reviewRepository.findAll();
        for(Review review:reviews){
            reviewDetailsList.add(ReviewDetails.builder()
                            .reviewId(review.getReviewId())
                            .bookId(review.getBook().getBookId())
                            .userId(review.getUser().getUserId())
                            .comment(review.getComment())
                            .rating(review.getRating())
                            .reviewDate(review.getReviewDate())
                    .build());
        }
        logger.info("Retrieved all reviews.");
        return reviewDetailsList;
    }

    @Override
    public List<ReviewDetails> getAllReviewByBookId(Long bookId) {
        List<ReviewDetails> reviewDetailsList=new ArrayList<>();
        List<Review>reviews=reviewRepository.findAll();
        for(Review review:reviews){
            if(review.getBook().getBookId().equals(bookId)){
                reviewDetailsList.add(ReviewDetails.builder()
                        .reviewId(review.getReviewId())
                        .bookId(review.getBook().getBookId())
                        .userId(review.getUser().getUserId())
                        .comment(review.getComment())
                        .rating(review.getRating())
                        .reviewDate(review.getReviewDate())
                        .build());
            }

        }
        logger.info("Retrieved all reviews for book with id " + bookId);
        return reviewDetailsList;
    }

    @Override
    public List<ReviewDetails> getAllReviewByUserId(Long userId) {
        List<ReviewDetails> reviewDetailsList=new ArrayList<>();
        List<Review>reviews=reviewRepository.findAll();
        for(Review review:reviews){
            if(review.getUser().getUserId().equals(userId)){
                reviewDetailsList.add(ReviewDetails.builder()
                        .reviewId(review.getReviewId())
                        .bookId(review.getBook().getBookId())
                        .userId(review.getUser().getUserId())
                        .comment(review.getComment())
                        .rating(review.getRating())
                        .reviewDate(review.getReviewDate())
                        .build());
            }
        }
        logger.info("Retrieved reviews by user id: " + userId);
        return reviewDetailsList;
    }
}
