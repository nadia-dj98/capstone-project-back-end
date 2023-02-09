package com.example.voluntech_jobboard.Controllers;

import com.example.voluntech_jobboard.models.ApplicationDTO;
import com.example.voluntech_jobboard.models.Charity;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.services.CharityService;
import com.example.voluntech_jobboard.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/charities")
public class CharityController {

    @Autowired
    CharityService charityService;

    @Autowired
    JobService jobService;

    //get all charities
    @GetMapping
    public  ResponseEntity<List<Charity>> getAllCharities(){
        List<Charity> allCharities = charityService.getAllCharities();
        return new ResponseEntity<>(allCharities, HttpStatus.OK);
    }

    //create new charity
    @PostMapping
    public ResponseEntity<Charity> createNewCharity(@RequestBody Charity charity) {
        charityService.addCharity(charity);
        return new ResponseEntity<>(charity, HttpStatus.CREATED);
    }

    //add new job to charity
    //path variable = charity id
    @PostMapping(value = "/{id}/jobs")
    public ResponseEntity<Job> addNewJob(@RequestBody Job job, @PathVariable long id){
        jobService.addJob(job, id);
        job.setVolunteers(new ArrayList<>());
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }


    //delete charity -> need to change method to id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteCharity(@PathVariable long id) {
        charityService.deleteCharity(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }













    //update charity
    @PutMapping(value = "/{id}")
    public ResponseEntity<Charity> updateCharity(@RequestBody Charity charity, @PathVariable Long id){
        charityService.updateCharity(charity, id);
        Optional<Charity> updateCharity = charityService.getCharitiesById(id);
        return new ResponseEntity<>(updateCharity.get(), HttpStatus.OK);
    }

}
