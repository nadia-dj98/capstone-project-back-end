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


    //Get all volunteers
    @GetMapping
    public  ResponseEntity<List<Volunteer>> getAllVolunteer(){
        List<Volunteer> allVolunteers = volunteerService.getAllVolunteers();
        return new ResponseEntity<>(allVolunteers, HttpStatus.OK);
    }

    //Get volunteer by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity <Volunteer> getVolunteerById(@PathVariable long id){
        Optional<Volunteer> volunteer = volunteerService.getVolunteerById(id);
        if (volunteer.isPresent()) {
            return new ResponseEntity<>(volunteer.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
      }

    //create new volunteer
    @PostMapping
    public ResponseEntity<Volunteer> addNewVolunteer(@RequestBody Volunteer volunteer){
        volunteerService.addVolunteer(volunteer);
        return new ResponseEntity<>(volunteer, HttpStatus.CREATED);
    }


      // Update volunteer by id
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer, @PathVariable Long id){
//        volunteerService.updateVolunteer(volunteer, id);
//        Optional<Volunteer>updateVolunteer = volunteerService.getVolunteerById(id);
//        return new ResponseEntity<>(updateVolunteer.get(), HttpStatus.OK);
//    }


    //Add job to volunteer
    //TODO -- method does not work yet
    @PutMapping (value = "/{volunteerId}/jobs/{jobId}")
    public ResponseEntity<Volunteer> addJobToVolunteer(@PathVariable Long volunteerId, @RequestBody Long jobId) {
        Job job = jobService.getJobById(jobId).get();
        Volunteer volunteer = volunteerService.getVolunteerById(volunteerId).get();
        Volunteer updatedVolunteer = volunteerService.applyToJob(job, );
        return new ResponseEntity<>(updatedVolunteer, HttpStatus.OK);
    }

    //delete volunteer
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteVolunteer(@PathVariable Long id){
        volunteerService.deleteVolunteer(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}


