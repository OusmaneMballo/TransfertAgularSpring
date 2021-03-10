package com.simplon.transfer_rest_spring_angular.controller;

import com.simplon.transfer_rest_spring_angular.dao.EmeteurRepository;
import com.simplon.transfer_rest_spring_angular.dao.EnvoieRepository;
import com.simplon.transfer_rest_spring_angular.dao.RecepteurRepository;
import com.simplon.transfer_rest_spring_angular.entities.Emeteur;
import com.simplon.transfer_rest_spring_angular.entities.Envoie;
import com.simplon.transfer_rest_spring_angular.entities.Recepteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EnvoiController {
    @Autowired
    EnvoieRepository envoieRepos;
    @Autowired
    RecepteurRepository recepteurRepos;
    @Autowired
    EmeteurRepository emeteurRepos;

    @GetMapping("/envoie/all")
    public List<Envoie> findAll(){return envoieRepos.findAll();}

    @RequestMapping(value="/envoie/add", method = RequestMethod.POST)
    public Envoie add(@RequestBody Envoie envoie){
        Emeteur emeteur=emeteurRepos.save(envoie.getEmeteur());
        Recepteur recepteur=recepteurRepos.save(envoie.getRecepteur());
        envoie.setEmeteur(emeteur);
        envoie.setRecepteur(recepteur);
        return envoieRepos.save(envoie);
    }

    @RequestMapping(value = "/envoie/{id}", method = RequestMethod.GET)
    public Envoie findById(@PathVariable int id){return envoieRepos.findById(id);}

    @RequestMapping(value = "/envoie/emeteur/{id}", method = RequestMethod.GET)
    public Envoie findByEmeteurId(@PathVariable int id){return envoieRepos.findByEmeteur_Id(id);}public Envoie findByEmeteurNci(String nci){return envoieRepos.findByEmeteur_Nci(nci);}

    @RequestMapping(value = "/envoie/recepteur/{id}", method = RequestMethod.GET)
    public Envoie findByRecepteurId(@PathVariable int id){return envoieRepos.findByRecepteur_Id(id);}

    @RequestMapping(value = "/envoie/{nom}/{prenom}", method = RequestMethod.GET)
    public Envoie findByRecepteurNomAndRecepteurPrenom(@PathVariable String nom, @PathVariable String prenom){return envoieRepos.findByRecepteur_NomAndRecepteur_Prenom(nom, prenom);}

    @RequestMapping(value = "/envoie/recepteur/{tel}", method = RequestMethod.GET)
    public Envoie findByRecepteurTel(@PathVariable String tel){return envoieRepos.findByRecepteur_Tel(tel);}

    /*@RequestMapping(value="/envoie/update", method = RequestMethod.POST)*/
    @PutMapping(value = "/envoie/update/{id}")
    public Envoie update(@PathVariable int id, @RequestBody Envoie envoie){
        try{
            this.updateEmetteur(envoie.getEmeteur());
            this.updateRecepteur(envoie.getRecepteur());
            Envoie env=envoieRepos.findById(id);
            env.setDate(envoie.getDate());
            env.setMontant(envoie.getMontant());
            envoieRepos.flush();
            return env;
        }catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/envoie/delete/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id ){
        return envoieRepos.deleteById(id);
    }

    public void updateEmetteur(Emeteur emeteur){
        Emeteur em=emeteurRepos.findById(emeteur.getId());
        em.setTelephone(emeteur.getTelephone());
        em.setPrenom(emeteur.getPrenom());
        em.setNom(emeteur.getNom());
        em.setNci(emeteur.getNci());
        emeteurRepos.flush();
    }

    public void updateRecepteur(Recepteur recepteur){
        Recepteur re=recepteurRepos.findById(recepteur.getId());
        re.setNom(recepteur.getNom());
        re.setPrenom(recepteur.getPrenom());
        re.setTel(recepteur.getTel());
        recepteurRepos.flush();
    }

}
