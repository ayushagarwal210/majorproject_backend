package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.DTO.RentalDetails;
import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.entity.Rental;
import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.repository.RentalRepository;
import com.speproject.majorproject.repository.UserRepository;
import com.speproject.majorproject.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public RentalDetails addRentals(RentalDetails rentalDetails) {
        Book book;
        User user;
        if(bookRepository.findById(rentalDetails.getBookId()).isPresent()
                && userRepository.findById(rentalDetails.getUserId()).isPresent()){
            book= bookRepository.findById(rentalDetails.getBookId()).get();
            user= userRepository.findById(rentalDetails.getUserId()).get();
            Rental rental=new Rental(
                    rentalDetails.getRentalId()
                    ,rentalDetails.getRentalDate()
                    ,rentalDetails.getDueDate()
                    ,book
                    ,user
            );
            rentalRepository.save(rental);
            rentalDetails.setRentalId(rental.getRentalId());
            return rentalDetails;
        }
        return null;
    }

    @Override
    public List<RentalDetails> getAllRentals() {
        List<RentalDetails> rentalDetailsList=new ArrayList<>();
        List<Rental>rentals=rentalRepository.findAll();
        for(Rental rental:rentals){
            rentalDetailsList.add(new RentalDetails(
                    rental.getRentalId(),
                    rental.getRentalDate(),
                    rental.getDueDate(),
                    rental.getBook().getBookId(),
                    rental.getUser().getUserId()

            ));
        }
        return rentalDetailsList;
    }

    @Override
    public List<RentalDetails> getRentalsByUserId(Long userId) {
        List<RentalDetails> rentalDetailsList=new ArrayList<>();
        List<Rental>rentals=rentalRepository.findAll();
        for(Rental rental:rentals){
            if(rental.getUser().getUserId().equals(userId)){
                rentalDetailsList.add(new RentalDetails(
                        rental.getRentalId(),
                        rental.getRentalDate(),
                        rental.getDueDate(),
                        rental.getBook().getBookId(),
                        rental.getUser().getUserId()
                ));
            }
        }
        return rentalDetailsList;
    }
}
