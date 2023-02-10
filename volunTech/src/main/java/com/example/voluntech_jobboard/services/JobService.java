package com.example.voluntech_jobboard.services;

import com.example.voluntech_jobboard.models.Charity;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.repositories.CharityRepository;
import com.example.voluntech_jobboard.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CharityRepository charityRepository;

    public void addJob(Job job, long charityId){
        //change to if present
        Charity charity = charityRepository.findById(charityId).get();
        job.setCharity(charity);
        jobRepository.save(job);
    }

    public void deleteJob(Long id ){jobRepository.deleteById(id);}

    public Optional<Job> getJobById(Long id){
        return jobRepository.findById(id);
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public void updateJob(Job job, Long id){
        Job jobToUpdate = jobRepository.findById(id).get();
        jobToUpdate.setRole(job.getRole());
        jobToUpdate.setDescription(job.getDescription());
        jobToUpdate.setStartDate(job.getStartDate());
        jobToUpdate.setEndDate(job.getEndDate());
        jobToUpdate.setLocation(jobToUpdate.getLocation());
        jobRepository.save(jobToUpdate);
    }
    public List<Job> findByLocation (String location)
    { return jobRepository.findByLocationIgnoreCase(location);}
}
