/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
public class TirAuBut {
    private Tireur tireur; 
    private Gardien gardien; 
    private Ballon ballon; // Ballon
    private boolean estBut; 
    
    public TirAuBut(Tireur tireur, Gardien gardien, Ballon ballon) {
        this.tireur = tireur;
        this.gardien = gardien;
        this.ballon = ballon;
        this.estBut = false; 
    }

    // Getters
    public Tireur getTireur() {
        return tireur;
    }

    public Gardien getGardien() {
        return gardien;
    }

    public Ballon getBallon() {
        return ballon;
    }

    public boolean isEstBut() {
        return estBut;
    }

    // Setters
    public void setTireur(Tireur tireur) {
        this.tireur = tireur;
    }

    public void setGardien(Gardien gardien) {
        this.gardien = gardien;
    }

    public void setBallon(Ballon ballon) {
        this.ballon = ballon;
    }

    public void setEstBut(boolean estBut) {
        this.estBut = estBut;
    }
    
    
}
