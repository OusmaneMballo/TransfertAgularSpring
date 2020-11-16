package com.simplon.transfer_rest_spring_angular.entities;

import javax.persistence.*;

@Entity
public class Emeteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String telephone;
    @Column
    private String nci;
    @OneToOne
    private Envoie envoies;

    public Emeteur() {
    }

    public Envoie getEnvoies() {
        return envoies;
    }

    public void setEnvoies(Envoie envoies) {
        this.envoies = envoies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }
}
