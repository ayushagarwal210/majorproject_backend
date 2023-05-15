package com.speproject.majorproject.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "Please add user name")
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @NotBlank(message = "Please add password")
    private String password;
    private String address;
    private String phoneNumber;
    @Column(columnDefinition = "boolean default false")
    private Boolean isAdmin;
}
