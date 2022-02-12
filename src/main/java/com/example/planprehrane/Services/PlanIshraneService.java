package com.example.planprehrane.Services;

import com.example.planprehrane.Models.PlanIshrane;
import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Repositories.PlanIshraneRepository;
import com.example.planprehrane.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanIshraneService {

    @Autowired
    private PlanIshraneRepository planIshraneRepository;
    @Autowired
    private UserRepository userRepository;

    // GET plan_ishrane-admin pregledava sve planove
    public ResponseEntity<List<PlanIshrane>> getPlan() {
        List<PlanIshrane> plan = planIshraneRepository.findAll();
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }
    // DELETE plan_ishrane - addmin brise
    public ResponseEntity<String> deletePlan(Long id_plan) {
        Optional<PlanIshrane> result = planIshraneRepository.findById(id_plan);

        if (result.isPresent()){
            PlanIshrane planIshrane = result.get();
            planIshraneRepository.delete(planIshrane);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // POST plan_ishrane - admin dodaje plan ishrane
    public ResponseEntity<String> addPlan(PlanIshrane planIshrane) {
        List<PlanIshrane> planovi = planIshraneRepository.findAll();

        for(PlanIshrane plan : planovi)
            if (planIshrane.getPlan_ishrane().equals(plan.getPlan_ishrane()))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        planIshraneRepository.save(planIshrane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<PlanIshrane> createPlanIshrane(Long user_id, PlanIshrane planRequest) {
        PlanIshrane planIshrane = userRepository.findById(user_id).map(user -> {
            planRequest.setUser(user);
            return planIshraneRepository.save(planRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + user_id));

        return new ResponseEntity<>(planIshrane, HttpStatus.CREATED);
    }
}
