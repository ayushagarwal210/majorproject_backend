package com.speproject.majorproject.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    @Column(columnDefinition = "boolean default false")
    private Boolean isAdmin;
}
