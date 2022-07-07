/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.Trainers;
import com.example.demo.models.Trainers;
import com.example.demo.repository.iTrainerRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dimitrios
 */
@Service
public class TrainerService implements iTrainerService {
    @Autowired
    iTrainerRepository itr;
    
    @Override
    public void insertTrainer(Trainers t){
        
        Trainers savedtrainer = itr.save(t);
        
        
        
    }

    @Override
    public List<Trainers> getallTrainers() {
        return itr.findAll();
    }

    @Override
    public Trainers getTrainerById(Integer id) {
        
        
        return itr.findById(id).get();
    }

    @Override
    @Transactional
    public void updateTrainer(Integer id,String name, String lname, String email) {
        
        Trainers t =  getTrainerById(id);
        
        //t.setId(id);
        t.setFirstname(name);
        t.setLastname(lname);
        t.setEmail(email);
        itr.save(t);
        
    }

    @Override
    @Transactional
    public void deleteTrainer(Integer id) {
        Trainers t2 = getTrainerById(id);
        
        itr.deleteById(id);
    }
    
}
