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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private final NamirniceService namirniceService;
    @Autowired
    private final PlanIshraneService planIshraneService;
    @Autowired
    private final RezultatService rezultatService;
    @Autowired
    private final UserService userService;

    UserRepository userRepository;

    public UserController(NamirniceService namirniceService, PlanIshraneService planIshraneService, RezultatService rezultatService, UserService userService){
        this.namirniceService = namirniceService;
        this.planIshraneService = planIshraneService;
        this.rezultatService = rezultatService;
        this.userService = userService;
    }

    //User
    @PostMapping("/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();

        System.out.println("New user: " + newUser.toString());

        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());

            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }
    // DELETE all
    @DeleteMapping("/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

    // GET namirnice
    @GetMapping("/namirnice")
    public ResponseEntity<List<Namirnice>> getNamirnice() {
        return namirniceService.getNamirnice();
    }

    // GET Plan_Ishrane
    @GetMapping("/plan")
    public ResponseEntity<List<PlanIshrane>> getPlan() {
        return planIshraneService.getPlan();
    }

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

}
