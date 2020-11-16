package com.simplon.transfer_rest_spring_angular.entities;

import javax.persistence.*;

@Entity
public class Recepteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String tel;
    @OneToOne
    private Envoie envoie;

    public Recepteur() {
    }

    public Envoie getEnvoie() {
        return envoie;
    }

    public void setEnvoie(Envoie envoie) {
        this.envoie = envoie;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
