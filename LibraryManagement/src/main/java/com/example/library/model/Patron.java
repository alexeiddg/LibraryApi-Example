package com.example.library.model;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "patrons")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATRON_ID")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 50)
    private String last_name;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phone_number;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zip_code;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime date_of_birth;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registration_date;

    @Column(name = "membership_status", nullable = false, length = 20)
    private String membership_status;

    @Column(name = "last_visit", nullable = false)
    private LocalDateTime last_visit;

    // auto-set dates on creation and update
    @PrePersist
    private void onCreate() {
        this.registration_date = LocalDateTime.now();;
    }

    @PreUpdate
    private void onUpdate() {
        this.last_visit = LocalDateTime.now();
    }
}
