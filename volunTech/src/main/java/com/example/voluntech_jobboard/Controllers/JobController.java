package com.example.voluntech_jobboard.Controllers;

import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    //Get job by location or get all jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobsOrFilterByLocationOrFilterByRole(
            @RequestParam(required = false, value= "location")String location,
            @RequestParam(required = false, value = "role")String role){
        if (location != null) {
    return new ResponseEntity<>(jobService.findByLocation(location), HttpStatus.OK);
        }
        if (role !=null){
            return new ResponseEntity<>(jobService.findByRole(role), HttpStatus.OK);
        }
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }


    //Get jobs by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Job>getJobById(@PathVariable long id){
        Optional<Job> job = jobService.getJobById(id);
        if (job.isPresent()){
            return new ResponseEntity<>(job.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //update job
    @PutMapping(value = "/{id}")
    public ResponseEntity<Job> updateJob(@RequestBody Job job, @PathVariable Long id){
        jobService.updateJob(job, id);
        Optional<Job>updateJob = jobService.getJobById(id);
        return new ResponseEntity<>(updateJob.get(), HttpStatus.OK);
    }

    //delete job
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteJob(@PathVariable long id){
        jobService.deleteJob(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
