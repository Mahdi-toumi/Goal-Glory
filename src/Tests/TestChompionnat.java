/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import com.jeu.elements.Equipe;
import com.jeu.structure.Championnat;
import com.jeu.structure.Match ;
import com.jeu.structure.Exceptions.AjoutEquipeException;
import com.jeu.structure.Tour;

/**
 *
 * @author toumi
 */
public class TestChompionnat {
  

    
        public static void main(String[] args) {
            // Création du tournoi (exemple avec un tournoi de type Championnat)
            Championnat tournoi = new Championnat("Championnat 2024");

            // Création des équipes
            Equipe equipe1 = new Equipe("Equipe A","Xavi");
            Equipe equipe2 = new Equipe("Equipe B","Xavi");
            Equipe equipe3 = new Equipe("Equipe C","Xavi");
            Equipe equipe4 = new Equipe("Equipe D","Xavi");
            Equipe equipe5 = new Equipe("Equipe E","Xavi");
            Equipe equipe6 = new Equipe("Equipe F","Xavi");

            // Ajouter les équipes au tournoi
            try {
                tournoi.ajouter_Equipe(equipe1);
                tournoi.ajouter_Equipe(equipe2);
                tournoi.ajouter_Equipe(equipe3);
                tournoi.ajouter_Equipe(equipe4);
                tournoi.ajouter_Equipe(equipe5);
                tournoi.ajouter_Equipe(equipe6);
            } catch (AjoutEquipeException e) {
                System.out.println(e.getMessage());
            }

            // Organiser le tournoi
            tournoi.Initialiser_tournoi();

            // Affichage des tours organisés et des matchs
            for (Tour tour : tournoi.getTours()) {
                System.out.println("Tour " + tour.Num_tour() + ":");
                for (Match match : tour.matchs()) {
                    System.out.println(match);
                }
            }
        }
    

}
