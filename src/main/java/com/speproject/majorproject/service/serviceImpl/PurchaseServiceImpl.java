package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.DTO.PurchaseDetails;
import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.Purchase;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.repository.PurchaseRepository;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.PurchaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private static final Logger logger = LogManager.getLogger(PurchaseServiceImpl.class);

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PurchaseDetails addPurchase(PurchaseDetails purchaseDetail){
        Book book;
        User user;
        if(bookRepository.findById(purchaseDetail.getBookId()).isPresent()
                && userRepository.findById(purchaseDetail.getUserId()).isPresent()){
            book= bookRepository.findById(purchaseDetail.getBookId()).get();
            user= userRepository.findById(purchaseDetail.getUserId()).get();
            Purchase purchase = Purchase.builder()
                    .purchaseDate(purchaseDetail.getPurchaseDate())
                    .book(book)
                    .user(user)
                    .build();
            purchaseRepository.save(purchase);
            purchaseDetail.setPurchaseId(purchase.getPurchaseId());
            logger.info("Added purchase with ID {}.", purchase.getPurchaseId());
            return purchaseDetail;
        }
        logger.warn("Could not add purchase with book ID {} and user ID {}.", purchaseDetail.getBookId(), purchaseDetail.getUserId());
        return null;

    }

    @Override
    public List<PurchaseDetails> getAllPurchases() {
        List<PurchaseDetails> purchaseDetailsList=new ArrayList<>();
        List<Purchase>purchases=purchaseRepository.findAll();
        for(Purchase purchase:purchases){
            purchaseDetailsList.add(new PurchaseDetails(
                    purchase.getPurchaseId()
                    ,purchase.getPurchaseDate()
                    ,purchase.getBook().getBookId(),
                    purchase.getUser().getUserId()
            ));
        }
        logger.info("Retrieved all purchases.");
        return purchaseDetailsList;
    }

    @Override
    public List<PurchaseDetails> getAllPurchasesByUserId(Long userId) {
        List<PurchaseDetails> purchaseDetailsList=new ArrayList<>();
        List<Purchase>purchases=purchaseRepository.findAll();
        for(Purchase purchase:purchases){
            if(purchase.getUser().getUserId().equals(userId)){
                purchaseDetailsList.add(new PurchaseDetails(
                        purchase.getPurchaseId()
                        ,purchase.getPurchaseDate()
                        ,purchase.getBook().getBookId(),
                        purchase.getUser().getUserId()
                ));
            }
        }
        logger.info("Retrieved all purchases for user with ID {}.", userId);
        return purchaseDetailsList;
    }

}
