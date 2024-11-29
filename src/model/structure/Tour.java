/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package model.structure;

import model.elements.Equipe;
import model.structure.exceptions.AjoutMatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author toumi
 */
// Tour.java
public class Tour {
    private int numTour;
    private ArrayList<Match> matchs;

    public Tour(int numTour) {
        if (numTour <= 0) {
            throw new IllegalArgumentException("Le numéro du tour doit être supérieur à 0.");
        }
        this.numTour = numTour;
        this.matchs = new ArrayList<>();
    }
    
    
    // Getters  
    public int getNumTour() {return this.numTour;}

    public ArrayList<Match> getMatchs() {return this.matchs;}
    
    //Setters
    public void setNumTour(int num) {this.numTour = num ;}
     
    public void setMatchs(ArrayList<Match> m) {this.matchs = m ;}

    
    
    public void afficherMatchs() {
        System.out.println("Matchs du Tour " + numTour + ":");
        matchs.forEach(System.out::println);
    }

    public void ajouterMatch(Match m) throws AjoutMatchException {
        // Vérifie si le match est déjà présent
        for (Match matchExistant : this.matchs) {
            if (matchExistant.equals(m)) {
                throw new AjoutMatchException("Le match est déjà présent dans ce tour.");
            }
        }

        // Vérifie si l'une des équipes participe déjà à un autre match
        if (equipeExistante(m.getEquipe1()) || equipeExistante(m.getEquipe2())) {
            throw new AjoutMatchException("Une des équipes est déjà engagée dans un autre match du tour.");
        }

        this.matchs.add(m);
        System.out.println("Match ajouté avec succès.");
    }

    public boolean equipeExistante(Equipe e) {
        return matchs.stream().anyMatch(match -> match.getEquipe1().equals(e) || match.getEquipe2().equals(e));
    }


    
    
    // Get all winners of the matches
    public List<Equipe> getGagnants() {
        return matchs.stream()
                .map(Match::getGagnant)
                .collect(Collectors.toList());
    }
    
    // Get matches where a specific team is playing
    public List<Match> getMatchsParEquipe(Equipe equipe) {
        return matchs.stream()
                .filter(match -> match.getEquipe1().equals(equipe) || match.getEquipe2().equals(equipe))
                .collect(Collectors.toList());
    }
    


    
    
    
        @Override
    public String toString() {
        return "Tour " + numTour + " : " + matchs.size() + " matchs";
    }
    
}
