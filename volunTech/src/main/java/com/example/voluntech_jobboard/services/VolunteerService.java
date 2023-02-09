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

    //adding job object to jobs arraylist in Volunteer
    public void applyToJob(ApplicationDTO applicationDTO){
        Long volunteerId = applicationDTO.getVolunteerId();
        Long jobId = applicationDTO.getJobId();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        Job job = jobRepository.findById(jobId).get();
        volunteer.applyToJob(job);
        volunteerRepository.save(volunteer);

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

