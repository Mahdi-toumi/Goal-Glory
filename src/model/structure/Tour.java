/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package model.structure;

import model.elements.Equipe;
import model.structure.exceptions.AjoutMatchException;
import java.util.ArrayList;

/**
 *
 * @author toumi
 */
// Tour.java
public class Tour {
    private int numTour;
    private ArrayList<Match> matchs;

    public Tour(int numTour) {
        this.numTour = numTour;
        this.matchs = new ArrayList<>();
    }

    public void afficherMatchs() {
        System.out.println("Matchs du Tour " + numTour + ":");
        for (Match match : matchs) {
            System.out.println(match);
        }
    }

    public boolean ajouterMatch(Match m) {
        // Ajoute un match si il n'est pas déjà présent
        for (Match matchExistant : this.matchs) {
            if (matchExistant.equals(m)) {
                System.out.println("Le match est déjà présent dans ce tour.");
                return false;
            }
        }
        this.matchs.add(m);
        System.out.println("Match ajouté avec succès.");
        return true;
    }

    public boolean equipeExistante(Equipe e) {
        for (Match matchExistant : this.matchs) {
            if (matchExistant.getEquipe1().equals(e) || matchExistant.getEquipe2().equals(e)) {
                return true;
            }
        }
        return false;
    }

    // Getters et Setters
    public int getNumTour() {
        return numTour;
    }

    public ArrayList<Match> getMatchs() {
        return matchs;
    }
    
    public void setMatchs(ArrayList<Match> m) {
        this.matchs = m ;
    }
}
