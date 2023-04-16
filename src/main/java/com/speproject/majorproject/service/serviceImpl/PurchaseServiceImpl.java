package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.DTO.PurchaseDetails;
import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.Purchase;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.repository.PurchaseRepository;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
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
            return purchaseDetail;
        }
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
        return purchaseDetailsList;
    }

}
