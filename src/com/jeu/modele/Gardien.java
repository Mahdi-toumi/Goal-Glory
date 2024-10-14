/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
public class Gardien extends Joueur {
    private double pourcentageDeSauvete; // Pourcentage de réussite des arrêts

    public Gardien(String nom,String prenom , int age,Equipe equipe,  double pourcentageDeSauvete) {
        super(nom ,prenom , age, "Gardien",equipe);  //a ajouter equipe
        this.pourcentageDeSauvete = pourcentageDeSauvete;
    }

    public void sauverTir() {
        // Logique pour déterminer si le gardien réussit à sauver le tir
       
    }

    // Getters et Setters
    public double getPourcentageDeSauvete() {
        return pourcentageDeSauvete;
    }

    public void setPourcentageDeSauvete(double pourcentageDeSauvete) {
        this.pourcentageDeSauvete = pourcentageDeSauvete;
    }
}
