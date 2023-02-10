package com.example.voluntech_jobboard.services;

import com.example.voluntech_jobboard.models.ApplicationDTO;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.repositories.CharityRepository;
import com.example.voluntech_jobboard.repositories.JobRepository;
import com.example.voluntech_jobboard.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {


    @Autowired
    CharityRepository charityRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @Autowired
    JobRepository jobRepository;



    public List<Volunteer> getAllVolunteers(){
        return volunteerRepository.findAll();
    }

    public void addVolunteer(Volunteer volunteer){
        volunteerRepository.save(volunteer);
    }

    public Optional<Volunteer> getVolunteerById(Long id){
        return volunteerRepository.findById(id);
    }

    public void updateVolunteer(Volunteer volunteer, Long id){
        Volunteer volunteerToUpdate = volunteerRepository.findById(id).get();
        volunteerToUpdate.setName(volunteer.getName());
        volunteerToUpdate.setExperience(volunteer.getExperience());
        volunteerRepository.save(volunteerToUpdate);
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }

    // adding job object to jobs arraylist in Volunteer
    //TODO -- first "applyToJob" method does not work
//    public Volunteer applyToJob(Long volunteerId, Long jobId){
//        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
//        Job job = jobRepository.findById(jobId).get();
//        List<Job> jobs = volunteer.getJobs();
//        jobs.add(job);
//        volunteer.setJobs(jobs);
//        volunteerRepository.save(volunteer);
//        return volunteer;
//    }
//
//    //TODO -- second "applyToJob" method does not work
//    public void applyToJob(Job job, Volunteer volunteer){
//        List<Job> jobs = volunteer.getJobs();
//        jobs.add(job);
//        volunteer.setJobs(jobs);
//        volunteerRepository.save(volunteer);
//    }

    //volunteer adds job to their job array
    //job exists
    //get job from array through its id
    //then add to their array list

    public void  applyToJob(Long jobId, Long volunteerId) {

        Job jobToApplyTo = jobRepository.findById(jobId).get();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        List<Volunteer> jobVolunteers = jobToApplyTo.getVolunteers();
        jobVolunteers.add(volunteer);
        jobToApplyTo.setVolunteers(jobVolunteers);
        jobRepository.save(jobToApplyTo);

    }



    public void withdrawFromJob(ApplicationDTO applicationDTO){
        Long volunteerId = applicationDTO.getVolunteerId();
        Long jobId = applicationDTO.getJobId();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        Job job = jobRepository.findById(jobId).get();
        volunteer.withdrawFromJob(job);
        volunteerRepository.save(volunteer);
    }

}

