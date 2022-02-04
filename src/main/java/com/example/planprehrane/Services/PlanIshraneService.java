package com.example.planprehrane.Services;

import com.example.planprehrane.Models.Namirnice;
import com.example.planprehrane.Models.PlanIshrane;
import com.example.planprehrane.Repositories.PlanIshraneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanIshraneService {

    @Autowired
    private PlanIshraneRepository planIshraneRepository;
    // GET plan_ishrane
    public ResponseEntity<List<PlanIshrane>> getPlan() {
        List<PlanIshrane> plan = planIshraneRepository.findAll();
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }
    // DELETE plan_ishrane
    public ResponseEntity<String> deletePlan(Long id_plan) {
        Optional<PlanIshrane> result = planIshraneRepository.findById(id_plan);

        if (result.isPresent()){
            PlanIshrane planIshrane = result.get();
            planIshraneRepository.delete(planIshrane);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // POST plan_ishrane
    public ResponseEntity<String> addPlan(PlanIshrane planIshrane) {
        List<PlanIshrane> planovi = planIshraneRepository.findAll();

        for(PlanIshrane plan : planovi)
            if (planIshrane.getPlan_ishrane().equals(plan.getPlan_ishrane()))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        planIshraneRepository.save(planIshrane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
