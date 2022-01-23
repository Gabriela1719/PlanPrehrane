package com.example.planprehrane.Services;

import com.example.planprehrane.Models.PlanIshrane;
import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Repositories.RezultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezultatService {
    @Autowired
    private RezultatRepository rezultatRepository;

    // GET rezultat
    public ResponseEntity<List<Rezultat>> getResult() {
        List<Rezultat> rezultati = rezultatRepository.findAll();
        return new ResponseEntity<>(rezultati, HttpStatus.OK);
    }
    // DELETE rezultat
    public ResponseEntity<String> deleteResult(Long id_result) {
        Optional<Rezultat> result = rezultatRepository.findById(id_result);

        if (result.isPresent()){
            Rezultat rezultat = result.get();
            rezultatRepository.delete(rezultat);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
