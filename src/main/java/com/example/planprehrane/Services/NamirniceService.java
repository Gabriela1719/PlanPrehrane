package com.example.planprehrane.Services;

import com.example.planprehrane.Models.Namirnice;
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

    // GET namirnice user pregledava, admin također
    public ResponseEntity<List<Namirnice>> getNamirnice() {
        List<Namirnice> allNamirnice = namirniceRepository.findAll();
        return new ResponseEntity<>(allNamirnice, HttpStatus.OK);
    }
    // DELETE namirnice - admin brise
    public ResponseEntity<String> deleteNamirnice(Long id_namirnice) {
        Optional<Namirnice> result = namirniceRepository.findById(id_namirnice);

        if (result.isPresent()){
            Namirnice namirnice = result.get();
            namirniceRepository.delete(namirnice);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // POST namirnice - amdin dodaje
    public ResponseEntity<String> addNew(Namirnice namirnice) {
       List<Namirnice> sveNamirnice = namirniceRepository.findAll();

       for(Namirnice namirnice1 : sveNamirnice)
           if (namirnice.getNaziv().equals(namirnice1.getNaziv()))
               return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        namirniceRepository.save(namirnice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //user trazi namirnice po id-u
    public ResponseEntity<Namirnice> getNamirniceById(long nam_id) {
        Optional<Namirnice> namirnice = namirniceRepository.findById(nam_id);

        if (namirnice.isPresent()) {
            return new ResponseEntity<>(namirnice.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
