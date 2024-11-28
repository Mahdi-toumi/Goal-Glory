/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

/**
 *
 * @author toumi
 */
public class TirAuBut implements Comparable<TirAuBut> {
    /*private Tireur tireur;
    private Gardien gardien;*/
    private Ballon ballon;
    private String position;
    private boolean estBut;

    public TirAuBut(//Tireur tireur, Gardien gardien, 
            Ballon ballon, String position) {
        /*this.tireur = tireur;
        this.gardien = gardien;*/
        this.ballon = ballon;
        this.position=position;
        this.estBut = false;
    }

    /*public void effectuerTir() {
        this.estBut = ballon.estBut(gardien, tireur);
    }

    // Getters et Setters
    public Tireur getTireur() {
        return tireur;
    }

    public Gardien getGardien() {
        return gardien;
    }
*/
    public Ballon getBallon() {
        return ballon;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String pos) {
        this.position=pos;
    }
    
    public void setBallon (Ballon ballon) {
        this.ballon=ballon;
    }
    
    public boolean isEstBut() {
        return estBut;
    }

    public void setEstBut(boolean estBut) {
        this.estBut = estBut;
    }
    
    

    @Override
    public int compareTo(TirAuBut other) {
        return Boolean.compare(this.estBut, other.estBut); 
    }
    
    @Override
    public String toString() {
        return "TirAuBut{" +
               "position='" + position + '\'' +
               ", estBut=" + estBut +
               '}';
    }
}
