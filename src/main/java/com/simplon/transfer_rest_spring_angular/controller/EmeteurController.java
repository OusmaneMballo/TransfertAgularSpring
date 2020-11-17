package com.simplon.transfer_rest_spring_angular.controller;

import com.simplon.transfer_rest_spring_angular.dao.EmeteurRepository;
import com.simplon.transfer_rest_spring_angular.entities.Emeteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class EmeteurController {
    @Autowired
     private EmeteurRepository emeteurRepos;

    @GetMapping("/emeteurs")
     public List<Emeteur> findAll(){
         return emeteurRepos.findAll();
     }
    //    @PostMapping("/emeteur/add")
    @RequestMapping(value="/emeteur/add", method = RequestMethod.POST)
     public Emeteur add(@RequestBody Emeteur emeteur){
        return emeteurRepos.save(emeteur);
    }

     @RequestMapping(value = "/emeteur/{id}", method = RequestMethod.GET)
     public Emeteur findById(@PathVariable int id){
        return emeteurRepos.findById(id);
    }

    @RequestMapping(value = "/emeteur/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable int id){
        emeteurRepos.deleteById(id);
    }

}
