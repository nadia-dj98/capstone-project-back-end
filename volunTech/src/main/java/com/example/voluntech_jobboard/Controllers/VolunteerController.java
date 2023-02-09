package com.example.voluntech_jobboard.Controllers;

import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.services.JobService;
import com.example.voluntech_jobboard.services.VolunteerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/volunteers")

public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @Autowired
    JobService jobService;

    //add Volunteer
    @PostMapping
    public ResponseEntity<Volunteer> addNewVolunteer(@RequestBody Volunteer volunteer){
         volunteerService.addVolunteer(volunteer);
        return new ResponseEntity<>(volunteer, HttpStatus.CREATED);
    }

    //Get all volunteers

    @GetMapping
    public  ResponseEntity<List<Volunteer>> getAllVolunteer(){
        List<Volunteer> allVolunteers = volunteerService.getAllVolunteers();
        return new ResponseEntity<>(allVolunteers, HttpStatus.OK);
    }

    //Get volunteers by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity <Volunteer> getVolunteerById(@PathVariable long id){
        Optional<Volunteer> volunteer = volunteerService.getVolunteerById(id);
        if (volunteer.isPresent()) {
            return new ResponseEntity<>(volunteer.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
      }


}

