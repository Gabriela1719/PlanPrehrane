package com.example.planprehrane.Services;

import com.example.planprehrane.Models.Namirnice;
import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Models.User;
import com.example.planprehrane.Repositories.NamirniceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NamirniceService {

    @Autowired
    private NamirniceRepository namirniceRepository;

    // GET namirnice
    public ResponseEntity<List<Namirnice>> getNamirnice() {
        List<Namirnice> allNamirnice = namirniceRepository.findAll();
        return new ResponseEntity<>(allNamirnice, HttpStatus.OK);
    }
    // DELETE namirnice
    public ResponseEntity<String> deleteNamirnice(Long id_namirnice) {
        Optional<Namirnice> result = namirniceRepository.findById(id_namirnice);

        if (result.isPresent()){
            Namirnice namirnice = result.get();
            namirniceRepository.delete(namirnice);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // POST namirnice
    public ResponseEntity<String> addNew(Namirnice namirnice) {
       List<Namirnice> sveNamirnice = namirniceRepository.findAll();

       for(Namirnice namirnice1 : sveNamirnice)
           if (namirnice.getNaziv().equals(namirnice1.getNaziv()))
               return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        namirniceRepository.save(namirnice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Namirnice> updateNamirnice(Long nam_id, Namirnice namirnice) {
        Optional<Namirnice> namirnice1 = namirniceRepository.findById(nam_id);

        if(namirnice1.isPresent()) {
            Namirnice namirnice2 = namirnice1.get();
            namirnice2.setNaziv(namirnice.getNaziv());
            namirnice2.setNutritivna_vrijednost(namirnice.getNutritivna_vrijednost());
            return new ResponseEntity<>(namirniceRepository.save(namirnice2), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Namirnice> getNamirniceById(long nam_id) {
        Optional<Namirnice> namirnice = namirniceRepository.findById(nam_id);

        if (namirnice.isPresent()) {
            return new ResponseEntity<>(namirnice.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
