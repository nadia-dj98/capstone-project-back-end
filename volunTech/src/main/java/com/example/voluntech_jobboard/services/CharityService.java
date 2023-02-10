package com.example.voluntech_jobboard.services;

import com.example.voluntech_jobboard.models.ApplicationDTO;
import com.example.voluntech_jobboard.models.Charity;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.repositories.CharityRepository;
import com.example.voluntech_jobboard.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharityService {

    @Autowired
    CharityRepository charityRepository;

    @Autowired
    JobRepository jobRepository;

    public void addCharity(Charity charity){
        charityRepository.save(charity);
    }

    public void deleteCharity(Long id){
        charityRepository.deleteById(id);
    }

    public List<Charity> getAllCharities(){
        return charityRepository.findAll();
    }

    public Optional<Charity> getCharitiesById(Long id){
        return charityRepository.findById(id);
    }

    public void addJob(ApplicationDTO applicationDTO){
        Long charityId = applicationDTO.getCharityId();
        Long jobId = applicationDTO.getJobId();
        Charity charity = charityRepository.findById(charityId).get();
        Job job = jobRepository.findById(jobId).get();
        charity.addJob(job);
        charityRepository.save(charity);
    }

    public void removeJob(ApplicationDTO applicationDTO){
        Long charityId = applicationDTO.getCharityId();
        Long jobId = applicationDTO.getJobId();
        Charity charity = charityRepository.findById(charityId).get();
        Job job = jobRepository.findById(jobId).get();
        charity.removeJob(job);
        charityRepository.save(charity);
    }

    public void updateCharity(Charity charity, Long id){
        Charity charityToUpdate = charityRepository.findById(id).get();
        charityToUpdate.setName(charity.getName());
        charityToUpdate.setDescription(charity.getDescription());
        charityToUpdate.setCharityCause(charity.getCharityCause());
        charityRepository.save(charityToUpdate);
    }

    public List<Charity> findByCharityCause(String charityCause) {
        return charityRepository.findByCharityCauseContainingIgnoreCase(charityCause);
    }
}
