package com.simplon.transfer_rest_spring_angular.controller;

import com.simplon.transfer_rest_spring_angular.dao.RecepteurRepository;
import com.simplon.transfer_rest_spring_angular.entities.Recepteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RecepteurController {

    @Autowired
    RecepteurRepository recepteurRepos;

    @RequestMapping(value="/recepteur/add", method = RequestMethod.POST)
    public Recepteur add(@RequestBody Recepteur recepteur){return recepteurRepos.save(recepteur);}
    @GetMapping("recepteurs")
    public List<Recepteur> findAll(){return recepteurRepos.findAll();}
    @RequestMapping(value = "/recepteur/{id}", method = RequestMethod.GET)
    public Recepteur findById(@PathVariable int id){
        return recepteurRepos.findById(id);
    }

    @RequestMapping(value = "/recepteur/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable int id){
        recepteurRepos.deleteById(id);
    }
}
