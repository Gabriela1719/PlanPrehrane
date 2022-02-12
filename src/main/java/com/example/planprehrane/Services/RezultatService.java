package com.example.planprehrane.Services;

import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Models.User;
import com.example.planprehrane.Repositories.RezultatRepository;
import com.example.planprehrane.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezultatService {
    @Autowired
    private RezultatRepository rezultatRepository;
    @Autowired
    private UserRepository userRepository;

    // GET rezultat by users id
   public ResponseEntity<Rezultat> getResult(Long user_id) {
       Optional<User> users = userRepository.findById(user_id);

       if (users.isPresent()){
          List <Rezultat> rezultat = users.get().getRezultati();
           return new ResponseEntity(rezultat, HttpStatus.OK);
       }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    // DELETE rezultat preko id-a
    public ResponseEntity<String> deleteResult(Long id_result) {
        Optional<Rezultat> result = rezultatRepository.findById(id_result);

        if (result.isPresent()){
            Rezultat rezultat = result.get();
            rezultatRepository.delete(rezultat);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<List<Rezultat>> getRezultat() {
        List<Rezultat> rezultati = rezultatRepository.findAll();
        return new ResponseEntity<>(rezultati, HttpStatus.OK);
    }

    public ResponseEntity<Rezultat> createResult(Long user_id, Rezultat resultRequest) {
        Rezultat rezultat = userRepository.findById(user_id).map(user -> {
            resultRequest.setUser(user);
            return rezultatRepository.save(resultRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + user_id));

        return new ResponseEntity<>(rezultat, HttpStatus.CREATED);
    }
}
