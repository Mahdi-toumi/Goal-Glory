/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.jeu.structure;

import com.jeu.elements.Equipe;
import com.jeu.structure.Exceptions.AjoutMatchException;
import java.util.ArrayList;

/**
 *
 * @author toumi
 */
public record Tour(int Num_tour , ArrayList<Match> matchs) {
    
    
    public Tour(int Num_tour) {
        this(Num_tour, new ArrayList<>());
    }
    
    
    public void afficherMatchs() {
        System.out.println("Matchs du Tour " + Num_tour + ":");
        for (Match match : matchs) {
            System.out.println(match);
        }
    }
    
    public boolean ajouterMatch (Match m)  {
        for (Match matchExistant : this.matchs()) {
                if (!matchExistant.equals(m)) {
                    this.matchs.add(m);
                    System.out.println("Ajout avec succès du match dans ce tour.");
                    return true ;
                }
        }  
        return false ; 
    }
    
    public boolean Equipe_existant (Equipe e) {
        for (Match matchExistant : this.matchs()) {
                if (matchExistant.getEquipe1().equals(e) || matchExistant.getEquipe2().equals(e)){
                    return true ;
                }
        }
        return false ;        
    }
}
