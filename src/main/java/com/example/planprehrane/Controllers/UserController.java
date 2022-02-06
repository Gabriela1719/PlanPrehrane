package com.example.planprehrane.Controllers;

import com.example.planprehrane.Models.*;
import com.example.planprehrane.Repositories.UserRepository;
import com.example.planprehrane.Services.NamirniceService;
import com.example.planprehrane.Services.PlanIshraneService;
import com.example.planprehrane.Services.RezultatService;
import com.example.planprehrane.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController{

    @Autowired
    private final NamirniceService namirniceService;
    @Autowired
    private final PlanIshraneService planIshraneService;
    @Autowired
    private final RezultatService rezultatService;
    @Autowired
    private final UserService userService;
    @Autowired
    UserRepository userRepository;

    public UserController(NamirniceService namirniceService, PlanIshraneService planIshraneService, RezultatService rezultatService, UserService userService){
        this.namirniceService = namirniceService;
        this.planIshraneService = planIshraneService;
        this.rezultatService = rezultatService;
        this.userService = userService;
    }

    // GET namirnice
    @GetMapping("/namirnice")
    public ResponseEntity<List<Namirnice>> getNamirnice() {
        return namirniceService.getNamirnice();
    }

    // GET namirnice byId
    @GetMapping("/{nam_id}")
    public ResponseEntity<Namirnice> getNamirniceById(@PathVariable("nam_id") long nam_id) {
        return namirniceService.getNamirniceById(nam_id);
    }

   /* // GET Plan_Ishrane
    @GetMapping("/plan")
    public ResponseEntity<List<PlanIshrane>> getPlan() {
        return planIshraneService.getPlan();
    }*/

    // GET rezultat
    @GetMapping("/result")
    public ResponseEntity<List<Rezultat>> getResult() {
        return rezultatService.getResult();
    }

    // POST rezultat


    // DELETE rezultat
    @DeleteMapping("/{id_result}")
    public ResponseEntity<String> deleteResult(@PathVariable("id_result") Long id_result){
        return rezultatService.deleteResult(id_result);
    }

    //PUT users
    @PutMapping("/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable("user_id") Long user_id, @RequestBody User user){
        return userService.updateUser(user_id, user);
    }
    // POST rezultat
    @PostMapping("/result")
    public ResponseEntity<String> addRezultat (@RequestBody Rezultat rezultat){
        return rezultatService.addRezultat(rezultat);
    }
}
