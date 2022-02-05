package com.example.planprehrane.Controllers;

import com.example.planprehrane.Models.Namirnice;
import com.example.planprehrane.Models.PlanIshrane;
import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Models.User;
import com.example.planprehrane.Services.NamirniceService;
import com.example.planprehrane.Services.PlanIshraneService;
import com.example.planprehrane.Services.RezultatService;
import com.example.planprehrane.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private final NamirniceService namirniceService;
    @Autowired
    private final PlanIshraneService planIshraneService;
    @Autowired
    private final RezultatService rezultatService;
    @Autowired
    private final UserService userService;

    public AdminController(NamirniceService namirniceService, PlanIshraneService planIshraneService, RezultatService rezultatService, UserService userService){
        this.namirniceService = namirniceService;
        this.planIshraneService = planIshraneService;
        this.rezultatService = rezultatService;
        this.userService = userService;
    }

    // GET namirnice
    @GetMapping("/")
    public ResponseEntity<List<Namirnice>> getNamirnice() {
        return namirniceService.getNamirnice();
    }

    // DELETE namirnice
    @DeleteMapping("/namirnice/{id_namirnice}")
    public ResponseEntity<String> deleteNamirnice(@PathVariable Long id_namirnice){
        return namirniceService.deleteNamirnice(id_namirnice);
    }
    // POST namirnice
    @PostMapping("/namirnice")
    public ResponseEntity<String> addNew (@RequestBody Namirnice namirnice){
        return namirniceService.addNew(namirnice);
    }
    // GET plan_ishrane
    @GetMapping("/plan")
    public ResponseEntity<List<PlanIshrane>> getPlan() {
        return planIshraneService.getPlan();
    }
    // POST plan_ishrane
    @PostMapping("/plan")
    public ResponseEntity<String> addPlan (@RequestBody PlanIshrane planIshrane){
        return planIshraneService.addPlan(planIshrane);
    }
    // DELETE plan_ishrane
    @DeleteMapping("/plan/{id_plan}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id_plan){
        return planIshraneService.deletePlan(id_plan);
    }
    // GET rezultat
    @GetMapping("/result")
    public ResponseEntity<List<Rezultat>> getResult() {
        return rezultatService.getResult();
    }

    //GET users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }


}
