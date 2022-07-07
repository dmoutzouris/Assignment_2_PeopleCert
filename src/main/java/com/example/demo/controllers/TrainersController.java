/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.models.Trainers;
import com.example.demo.models.Trainers;
import com.example.demo.services.iTrainerService;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dimitrios
 */
@Controller
public class TrainersController {

    @Autowired
    iTrainerService trainerService;

    @GetMapping("/addTrainerForm")
    public String addController() {

        return "formaddtrainer";

    }

    @PostMapping("/addTrainerController")
    public String addTrainer(@RequestParam("firstname") String fname,
            @RequestParam("lastname") String lname,
            @RequestParam("email") String email,
            @RequestParam("insurance") MultipartFile insurance, ModelMap mm) {

        Trainers t = new Trainers(fname, lname, email);
        t.setInsurancefilename(insurance.getOriginalFilename());
        try {
            t.setInsurancefile(insurance.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(TrainersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        trainerService.insertTrainer(t);

        return "redirect: /showlist";
    }

    @GetMapping("/showlist")
    public String showAllTrainers(ModelMap mm) {

        mm.addAttribute("alltrainers",
                trainerService.getallTrainers());

        return "trainerslist";
    }

    @GetMapping("/trainer/update/{id}")
    public String updateTrainer(@PathVariable("id") Integer id,
            ModelMap mm) {

        Trainers t = trainerService.getTrainerById(id);
        mm.addAttribute("trainertoupdate", t);

        return "formtoupdate";
    }

    @GetMapping("/trainer/delete/{id}")
    public String deleteTrainer(@PathVariable("id") Integer id,
            ModelMap mm) {

        trainerService.deleteTrainer(id);

        mm.addAttribute("alltrainers",
                trainerService.getallTrainers());

        return "redirect: /showlist";
    }

    /**
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param email
     * @return
     */
    @GetMapping("/trainer/doupdate")
    public String updateTrainerFinal(
            @PathVariable("id") Integer id,
            @PathVariable("firstname") String firstname,
            @PathVariable("lastname") String lastname,
            @PathVariable("email") String email) {

        trainerService.updateTrainer(id, firstname, lastname, email);

        return "trainerlist";
    }

    @GetMapping(value = "/trainer/download/{id}")
    @ResponseBody
    public byte[] downLoadInsuranceFile(@PathVariable("id") Integer id) {

        Trainers t = trainerService.getTrainerById(id);

        return t.getInsurancefile();

    }
//    
//    @GetMapping(value="trainer/download/{id}")
//    public ResponseEntity<Resource> dowloadInsurance(@PathVariable Integer id){
//        
//        
//        Trainers t = trainerService.getTrainerById(id);
//        byte[] insurance = t.getInsurancefile();
//        
//        return ResponseEntity.ok().contentLength(insurance.length)
//                .contentType(MediaType.parseMediaType("application/octect-stream")
;
//    }

}
