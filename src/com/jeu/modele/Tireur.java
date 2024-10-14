/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
public class Tireur  extends Joueur {
    private double precisionDeTir; // Précision du joueur lors des tirs

    public Tireur(String nom , String prenom, int age, double precisionDeTir) {
        super(nom, prenom,age, "Attaquant");
        this.precisionDeTir = precisionDeTir;
    }

    public void tirerTirAuBut() {
        // Logique pour déterminer si l'attaquant marque un but
        
    }

    // Getters et Setters
    public double getPrecisionDeTir() {
        return precisionDeTir;
    }

    public void setPrecisionDeTir(double precisionDeTir) {
        this.precisionDeTir = precisionDeTir;
    }
}
    

