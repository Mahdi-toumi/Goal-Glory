/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

import model.elements.Equipe;
import model.structure.exceptions.AjoutMatchException;
import model.structure.exceptions.AjoutTourException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Représente un tournoi de type Championnat (système de points).
 * Les équipes gagnent des points en fonction de leurs performances.
 * 
 * @author toumi
 */
public final class Championnat extends Tournoi {
    private Map<Equipe, Integer> Classement;

    public Championnat(String Nom) {
        super(Nom);
        this.Classement = new HashMap<>();
    }
    
    
    //Creer les match du tour d'un tournoi 
    @Override
    public void Initialiser_tournoi() {
        // Initialiser les points de chaque équipe
        this.getEquipes().forEach(equipe -> Classement.put(equipe, 0));
        ArrayList<Match> tousLesMatchs = new ArrayList<>();

        // Générer tous les matchs possibles (round-robin)
        for (int i = 0; i < this.getEquipes().size(); i++) {
            for (int j = i + 1; j < this.getEquipes().size(); j++) {
                Match m = new Match(this.getEquipes().get(i), this.getEquipes().get(j));
                tousLesMatchs.add(m);
            }
        }
        // Mélanger les matchs pour créer une répartition aléatoire
        Collections.shuffle(tousLesMatchs);

        // Initialiser le numéro du tour
        int numTour = 1;

        // Organiser les tours
        while (!tousLesMatchs.isEmpty()) {
            ArrayList<Match> matchsDuTour = new ArrayList<>();
            ArrayList<Equipe> equipesEngagees = new ArrayList<>(); // Pour suivre les équipes jouant dans ce tour

            // Parcourir les matchs et ajouter ceux qui respectent la contrainte
            Iterator<Match> it = tousLesMatchs.iterator();
            while (it.hasNext() && matchsDuTour.size() < this.getEquipes().size() / 2) {
                Match prochainMatch = it.next();

                // Vérifier si les équipes ne jouent pas déjà dans ce tour
                if (!equipesEngagees.contains(prochainMatch.getEquipe1()) &&
                    !equipesEngagees.contains(prochainMatch.getEquipe2())) {

                    matchsDuTour.add(prochainMatch);
                    equipesEngagees.add(prochainMatch.getEquipe1());
                    equipesEngagees.add(prochainMatch.getEquipe2());
                    it.remove(); // Supprimer le match ajouté de la liste globale
                }
            }

            // Ajouter le tour organisé à la liste des tours
            if (!matchsDuTour.isEmpty()) {
                Tour tour = new Tour(numTour++);
                tour.setMatchs(matchsDuTour);
                
                try {
                    this.ajouterTour(tour);
                } catch (AjoutTourException e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
        }
    }


    // Méthode pour afficher le classement trié des équipes
    public void afficherClassement() {
        Classement.entrySet().stream()
            .sorted(Map.Entry.<Equipe, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey().getNom() + " - " + entry.getValue() + " points"));
    }
    
    
    //Ajouter des points aux equipes
    public void AjoutPointsEquipes(int points) {
    appliquerActionSurEquipes(equipe -> {
        int pointsActuel = Classement.containsKey(equipe) ? Classement.get(equipe) : 0;
        int nouveauScore = pointsActuel + points ;
        Classement.put(equipe, nouveauScore);
        System.out.println("L'équipe " + equipe.getNom() + " a maintenant " + nouveauScore + " points.");
    });
}
    
        
        
    @Override
    public void Afficher_list_match() {
        for (Tour tour : this.getTours()){
            tour.afficherMatchs();
        }
    }
    
  
    
    @Override
    public Equipe Obtenir_gagnants() {
        return Classement.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }


   
    

    
}
