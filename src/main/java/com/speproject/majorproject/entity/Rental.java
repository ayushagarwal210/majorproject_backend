package com.speproject.majorproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rental {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long rentalId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date rentalDate;
    private Date dueDate;

    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Book book;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;
}
