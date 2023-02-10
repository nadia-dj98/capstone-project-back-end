package com.example.voluntech_jobboard.Controllers;

import com.example.voluntech_jobboard.models.ApplicationDTO;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.services.JobService;
import com.example.voluntech_jobboard.services.VolunteerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/volunteers")

public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @Autowired
    JobService jobService;

    //get all volunteers
    @GetMapping
    public  ResponseEntity<List<Volunteer>> getAllVolunteer(){
        List<Volunteer> allVolunteers = volunteerService.getAllVolunteers();
        return new ResponseEntity<>(allVolunteers, HttpStatus.OK);
    }

    //get volunteer by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity <Volunteer> getVolunteerById(@PathVariable long id){
        Optional<Volunteer> volunteer = volunteerService.getVolunteerById(id);
        if (volunteer.isPresent()) {
            return new ResponseEntity<>(volunteer.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
      }

      //create a new volunteer
    @PostMapping
    public ResponseEntity<Volunteer> addNewVolunteer(@RequestBody Volunteer volunteer){
        volunteerService.addVolunteer(volunteer);
        return new ResponseEntity<>(volunteer, HttpStatus.CREATED);
    }

    //update volunteer experience by id
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer, @PathVariable Long id){
        volunteerService.updateVolunteer(volunteer, id);
        Optional<Volunteer>updateVolunteer = volunteerService.getVolunteerById(id);
        return new ResponseEntity<>(updateVolunteer.get(), HttpStatus.OK);
    }

    //add volunteer to job
    @PostMapping (value = "/{jobId}/{volunteerId}")
    public ResponseEntity<String> applyToJob (@PathVariable Long jobId, @PathVariable Long volunteerId) {
        volunteerService.applyToJob(jobId, volunteerId);
        return new ResponseEntity<>("Application successful", HttpStatus.OK);
    }

    //delete volunteer from job
    @DeleteMapping (value = "/{jobId}/{volunteerId}")
    public ResponseEntity<String> withdrawVolunteerFromJob(@PathVariable Long jobId, @PathVariable Long volunteerId){
        volunteerService.withdrawFromJob(jobId, volunteerId);
        return new ResponseEntity<>("Application has been withdrawn", HttpStatus.OK);
    }

    //delete volunteer
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteVolunteer(@PathVariable Long id){
        volunteerService.deleteVolunteer(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}


