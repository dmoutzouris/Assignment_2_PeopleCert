/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.Trainers;
import java.util.List;

/**
 *
 * @author Dimitrios
 */
public interface iTrainerService {
    
    public void insertTrainer(Trainers t);
    
    
    public List<Trainers> getallTrainers();
    
    public Trainers getTrainerById(Integer id);
    
    public void updateTrainer(Integer id,String name,String lname,String email);
    
    public void deleteTrainer(Integer id);
}
