package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.DTO.PurchaseDetail;
import com.speproject.majorproject.DTO.PurchaseDetails;
import com.speproject.majorproject.DTO.PurchaseItemList;
import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.Purchase;
import com.speproject.majorproject.entity.PurchaseItem;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.repository.PurchaseItemRepository;
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

    @Autowired
    private  PurchaseItemRepository purchaseItemRepository;

    @Override
    public PurchaseDetail addPurchase(PurchaseDetails purchaseDetail){
        User user = userRepository.findById(purchaseDetail.getUserId()).get();;
//        if(userRepository.findById(purchaseDetail.getUserId()).isPresent()){
//            user= userRepository.findById(purchaseDetail.getUserId()).get();
        System.out.println("hereeee");
        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(purchaseDetail.getPurchaseDate());
        purchase.setUser(user);
        purchase.setAddress(purchaseDetail.getAddress());
        purchase.setCity(purchaseDetail.getCity());
        purchase.setPincode(purchaseDetail.getPincode());
        purchase.setCountry(purchaseDetail.getCountry());
        purchase.setPaymentMethod(purchaseDetail.getPaymentMethod());
        purchase.setTaxPrice(purchaseDetail.getTaxPrice());
        purchase.setShippingPrice(purchaseDetail.getShippingPrice());
        purchase.setTotalPrice(purchaseDetail.getTotalPrice());
        Purchase purchase1 = purchaseRepository.save(purchase);
        for(PurchaseItemList purchaseItemList : purchaseDetail.getPurchaseItemsList()){
            PurchaseItem purchaseItem = new PurchaseItem();

            Book book;
            if(bookRepository.findById(purchaseItemList.getBookId()).isPresent()){
                book = bookRepository.findById(purchaseItemList.getBookId()).get();
                purchaseItem.setPurchase(purchase);
                purchaseItem.setBook(book);
                purchaseItem.setQuantity(purchaseItemList.getQuantity());
                purchaseItemRepository.save(purchaseItem);
            }

        }
//        }
        PurchaseDetail purchaseDetail1 = new PurchaseDetail(purchase1.getPurchaseId(),purchaseDetail);
        // purchase details



        return purchaseDetail1;

    }

//    @Override
//    public PurchaseDetails addPurchase(PurchaseDetails purchaseDetail){
//        Book book;
//        User user;
//        if(bookRepository.findById(purchaseDetail.getBookId()).isPresent()
//                && userRepository.findById(purchaseDetail.getUserId()).isPresent()){
//            book= bookRepository.findById(purchaseDetail.getBookId()).get();
//            user= userRepository.findById(purchaseDetail.getUserId()).get();
//            Purchase purchase = Purchase.builder()
//                    .purchaseDate(purchaseDetail.getPurchaseDate())
//                    .book(book)
//                    .user(user)
//                    .build();
//            purchaseRepository.save(purchase);
//            purchaseDetail.setPurchaseId(purchase.getPurchaseId());
//            logger.info("Added purchase with ID {}.", purchase.getPurchaseId());
//            return purchaseDetail;
//        }
//        logger.warn("Could not add purchase with book ID {} and user ID {}.", purchaseDetail.getBookId(), purchaseDetail.getUserId());
//        return null;
//
//    }

//
//    @Override
//    public List<PurchaseDetails> getAllPurchases() {
//        List<PurchaseDetails> purchaseDetailsList=new ArrayList<>();
//        List<Purchase>purchases=purchaseRepository.findAll();
//        for(Purchase purchase:purchases){
//            purchaseDetailsList.add(new PurchaseDetails(
//                    purchase.getPurchaseId()
//                    ,purchase.getPurchaseDate()
//                    ,purchase.getBook().getBookId(),
//                    purchase.getUser().getUserId()
//            ));
//        }
//        logger.info("Retrieved all purchases.");
//        return purchaseDetailsList;
//    }
//
    @Override
    public List<PurchaseDetail> getAllPurchasesByUserId(Long userId) {
        List<PurchaseDetail> purchaseDetailList = new ArrayList<>();
//        List<PurchaseDetails> purchaseDetailsList=new ArrayList<>();
        List<Purchase>purchases=purchaseRepository.findAll();
        for(Purchase purchase:purchases){
            if(purchase.getUser().getUserId().equals(userId)){
                long purchaseId = purchase.getPurchaseId();
                List<PurchaseItemList> purchaseItemsList = new ArrayList<>();
                List<PurchaseItem> purchaseItems = purchaseItemRepository.findAll();
                for(PurchaseItem purchaseItem: purchaseItems){
                    if(purchaseItem.getPurchase().getPurchaseId().equals(purchaseId)){
                        purchaseItemsList.add(new PurchaseItemList(purchaseItem.getBook().getBookId(),
                                purchaseItem.getQuantity(),
                                purchaseItem.getBook().getPrice(),
                                purchaseItem.getBook().getImage(),
                                purchaseItem.getBook().getTitle()));
                    }
                }
                purchaseDetailList.add(new PurchaseDetail(purchase.getPurchaseId(),new PurchaseDetails(
                        purchase.getPurchaseDate(),
                        purchase.getUser().getUserId(),
                        purchase.getAddress(),
                        purchase.getCity(),
                        purchase.getPincode(),
                        purchase.getCountry(),
                        purchase.getPaymentMethod(),
                        purchase.getShippingPrice(),
                        purchase.getTaxPrice(),
                        purchase.getTotalPrice(),
                        purchaseItemsList
                )));
            }
        }
        logger.info("Retrieved all purchases for user with ID {}.", userId);
        return purchaseDetailList;
    }

    @Override
    public List<PurchaseDetail> getAllPurchases() {
        List<PurchaseDetail> purchaseDetailList = new ArrayList<>();
//        List<PurchaseDetails> purchaseDetailsList=new ArrayList<>();
        List<Purchase>purchases=purchaseRepository.findAll();
        for(Purchase purchase:purchases) {
            long purchaseId = purchase.getPurchaseId();
            List<PurchaseItemList> purchaseItemsList = new ArrayList<>();
            List<PurchaseItem> purchaseItems = purchaseItemRepository.findAll();
            for (PurchaseItem purchaseItem : purchaseItems) {
                if (purchaseItem.getPurchase().getPurchaseId().equals(purchaseId)) {
                    purchaseItemsList.add(new PurchaseItemList(purchaseItem.getBook().getBookId(),
                            purchaseItem.getQuantity(),
                            purchaseItem.getBook().getPrice(),
                            purchaseItem.getBook().getImage(),
                            purchaseItem.getBook().getTitle()));
                }
            }
            purchaseDetailList.add(new PurchaseDetail(purchase.getPurchaseId(), new PurchaseDetails(
                    purchase.getPurchaseDate(),
                    purchase.getUser().getUserId(),
                    purchase.getAddress(),
                    purchase.getCity(),
                    purchase.getPincode(),
                    purchase.getCountry(),
                    purchase.getPaymentMethod(),
                    purchase.getShippingPrice(),
                    purchase.getTaxPrice(),
                    purchase.getTotalPrice(),
                    purchaseItemsList
            )));
        }
            logger.info("Retrieved all purchases.");
            return purchaseDetailList;
    }

    @Override
    public PurchaseDetail getPurchasesByPurchaseId(Long purchaseId) {
        PurchaseDetail purchaseDetail = new PurchaseDetail();
        List<PurchaseDetails> purchaseDetailsList=new ArrayList<>();

                List<PurchaseItemList> purchaseItemsList = new ArrayList<>();
                List<PurchaseItem> purchaseItems = purchaseItemRepository.findAll();
                for(PurchaseItem purchaseItem: purchaseItems){
                    if(purchaseItem.getPurchase().getPurchaseId().equals(purchaseId)){
                        purchaseItemsList.add(new PurchaseItemList(purchaseItem.getBook().getBookId(),
                                purchaseItem.getQuantity(),
                                purchaseItem.getBook().getPrice(),
                                purchaseItem.getBook().getImage(),
                                purchaseItem.getBook().getTitle()));
                    }
                Purchase purchase = purchaseRepository.findById(purchaseId).get();
                PurchaseDetails purchaseDetails = new PurchaseDetails(
                        purchase.getPurchaseDate(),
                        purchase.getUser().getUserId(),
                        purchase.getAddress(),
                        purchase.getCity(),
                        purchase.getPincode(),
                        purchase.getCountry(),
                        purchase.getPaymentMethod(),
                        purchase.getShippingPrice(),
                        purchase.getTaxPrice(),
                        purchase.getTotalPrice(),
                        purchaseItemsList
                );
                purchaseDetail.setPurchaseId(purchaseId);
                purchaseDetail.setPurchaseDetails(purchaseDetails);
            }

        logger.info("Retrieved all purchases for user with ID {}.", purchaseId);
        return purchaseDetail;
    }

    @Override
    public void deletePurchaseById(Long purchaseId) {
        purchaseItemRepository.deleteByPurchaseId(purchaseId);
        purchaseRepository.deleteById(purchaseId);
       return;
    }


}
