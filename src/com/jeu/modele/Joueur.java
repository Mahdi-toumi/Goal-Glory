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
    private Equipe equipe;

    public Joueur(String nom, String prenom, int age, String position, Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.position = position;
        this.equipe = equipe;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) { // Correction du nom de paramètre
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

   
    public abstract void jouer();
}

