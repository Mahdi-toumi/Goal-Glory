/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package model.structure;

/**
 *
 * @author toumi
 */
public record Stade(String nom, String Pays, double capacite) {

    public Stade {
        if (capacite < 0) {
            throw new IllegalArgumentException("La capacité ne peut pas être négative.");
        }
    }
    @Override
    public String toString() {
        return "Stade : " + nom + " | Pays : " + Pays + " | Capacité : " + capacite;
    }
}
