/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
public abstract class Joueur {

    private String nom;
    private String prenom;
    private int age;
    private String position;
    private Equipe equipe  ;

    public Joueur(String nom, String prenom, int age, String position , Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.position = position;
        this.equipe=equipe ;
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

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
   

}
