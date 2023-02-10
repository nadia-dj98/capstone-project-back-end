package com.example.voluntech_jobboard.services;

import com.example.voluntech_jobboard.models.ApplicationDTO;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.repositories.CharityRepository;
import com.example.voluntech_jobboard.repositories.JobRepository;
import com.example.voluntech_jobboard.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
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
        volunteerToUpdate.setExperience(volunteer.getExperience());
        volunteerRepository.save(volunteerToUpdate);
    }

    //TODO
    //we want to remove volunteer item from volunteer array in job object
    //access each individual job object
    //loop through volunteer in volunteer array
    //if volunteer id is found in array, delete item
    //set volunteer array to new array
    //repeat for each job object
//    public void deleteVolunteer(Long volunteerId) {
//        List<Job> jobs = jobRepository.findAll();
//        for (int i = 0; i < jobs.size(); i++){
//        }
//    }

    public void deleteVolunteer(long volunteerId) {
        Volunteer volunteerToDelete = volunteerRepository.findById(volunteerId).get();
        List<Job> listOfJobs = volunteerToDelete.getJobs();
        for (Job job : listOfJobs) {
            withdrawFromJob(job.getId(), volunteerId);
        }
        volunteerRepository.delete(volunteerToDelete);
    }

    public void  applyToJob(Long jobId, Long volunteerId) {
        Job jobToApplyTo = jobRepository.findById(jobId).get();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        List<Volunteer> jobVolunteers = jobToApplyTo.getVolunteers();
        jobVolunteers.add(volunteer);
        jobToApplyTo.setVolunteers(jobVolunteers);
        jobRepository.save(jobToApplyTo);
    }

    public void withdrawFromJob(Long jobId, Long volunteerId){
        Job jobToApplyTo = jobRepository.findById(jobId).get();
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();
        List<Volunteer> jobVolunteers = jobToApplyTo.getVolunteers();
        jobVolunteers.remove(volunteer);
        jobToApplyTo.setVolunteers(jobVolunteers);
        jobRepository.save(jobToApplyTo);
    }
}

