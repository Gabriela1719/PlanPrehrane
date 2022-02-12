package com.example.planprehrane.Controllers;

import com.example.planprehrane.Models.Namirnice;
import com.example.planprehrane.Models.PlanIshrane;
import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Models.User;
import com.example.planprehrane.Services.NamirniceService;
import com.example.planprehrane.Services.PlanIshraneService;
import com.example.planprehrane.Services.RezultatService;
import com.example.planprehrane.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController{


    private final NamirniceService namirniceService;
    private final PlanIshraneService planIshraneService;
    private final RezultatService rezultatService;
    private final UserService userService;

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

    // GET Plan_Ishrane
    @GetMapping("/plan")
    public ResponseEntity<List<PlanIshrane>> getPlan() {
        return planIshraneService.getPlan();
    }

    @GetMapping("/result")
    public ResponseEntity<List<Rezultat>> getRezultat() {
        return rezultatService.getRezultat();
    }

    // GET rezultat by users id
    @GetMapping("/{user_id}/result")
    public ResponseEntity<Rezultat> getResult(@PathVariable Long user_id) {
        return rezultatService.getResult(user_id);
    }

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
    @PostMapping("/{user_id}/result")
    public ResponseEntity<Rezultat> createResult(@PathVariable(value = "user_id") Long user_id,
                                                 @RequestBody Rezultat resultRequest) {
        return rezultatService.createResult(user_id, resultRequest);
    }
}
