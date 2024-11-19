/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

/**
 *
 * @author toumi
 */
public class TirAuBut {
    private Tireur tireur;
    private Gardien gardien;
    private Ballon ballon;
    private boolean estBut;

    public TirAuBut(Tireur tireur, Gardien gardien, Ballon ballon) {
        this.tireur = tireur;
        this.gardien = gardien;
        this.ballon = ballon;
        this.estBut = false;
    }

    public void effectuerTir() {
        this.estBut = ballon.estBut(gardien, tireur);
    }

    // Getters et Setters
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

    public void setEstBut(boolean estBut) {
        this.estBut = estBut;
    }
}
