package com.example.library.controller;

import com.example.library.model.Patron;
import com.example.library.repository.PatronsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronsRepository patronsRepository;

    public PatronController(PatronsRepository patronsRepository) {
        this.patronsRepository = patronsRepository;
    }

    @PostMapping()
    public ResponseEntity<Patron> createPatron(@RequestBody Patron patron) {
        return ResponseEntity.ok(patronsRepository.save(patron));
    }

    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons() {
        return ResponseEntity.ok(patronsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        return patronsRepository.findById(id)
                .map(patron -> ResponseEntity.ok().body(patron))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron updatedPatron) {
        return patronsRepository.findById(id)
                .map(patron -> {
                    patron.setFirst_name(updatedPatron.getFirst_name());
                    patron.setLast_name(updatedPatron.getLast_name());
                    patron.setEmail(updatedPatron.getEmail());
                    patron.setPhone_number(updatedPatron.getPhone_number());
                    patron.setAddress(updatedPatron.getAddress());
                    patron.setCity(updatedPatron.getCity());
                    patron.setState(updatedPatron.getState());
                    patron.setZip_code(updatedPatron.getZip_code());
                    patron.setDate_of_birth(updatedPatron.getDate_of_birth());
                    patron.setMembership_status(updatedPatron.getMembership_status());

                    Patron saved = patronsRepository.save(patron);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        return patronsRepository.findById(id)
                .map(patron -> {
                    patronsRepository.delete(patron);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
