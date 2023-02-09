package com.example.voluntech_jobboard.services;

import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public void addJob(Job job){
        jobRepository.save(job);
    }

    public void deleteJob(Long id ){jobRepository.deleteById(id);}

    public Optional<Job> getJobById(Long id){
        return jobRepository.findById(id);
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
}
