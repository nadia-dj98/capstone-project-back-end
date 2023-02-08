package com.example.voluntech_jobboard.services;

import com.example.voluntech_jobboard.models.Charity;
import com.example.voluntech_jobboard.repositories.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityService {

    @Autowired
    CharityRepository charityRepository;

    public void addCharity(Charity charity){
        charityRepository.save(charity);
    }

    public void removeCharity(Charity charity){
        charityRepository.delete(charity);
    }

    public List<Charity> getAllCharities(){
        return charityRepository.findAll();
    }
}
