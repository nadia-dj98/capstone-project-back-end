package com.example.voluntech_jobboard.Controllers;

import com.example.voluntech_jobboard.models.Job;
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

    //GET all jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> allJobs = jobService.getAllJobs();
        return new ResponseEntity<>(allJobs, HttpStatus.OK);
    }

    //GET jobs by id
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

    //add new job
    @PostMapping
    public ResponseEntity<Job> addNewJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    //delete job
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeJobById(@PathVariable long id){
        jobService.removeJobById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
