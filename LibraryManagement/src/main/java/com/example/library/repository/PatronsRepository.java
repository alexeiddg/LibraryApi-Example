package com.example.library.repository;

import com.example.library.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronsRepository extends JpaRepository<Patron, Long> {
    // Basic crud
}
