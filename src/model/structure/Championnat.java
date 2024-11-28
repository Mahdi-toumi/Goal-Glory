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
        // Trier par points
        List<Map.Entry<Equipe, Integer>> classementTrie = Classement.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Tri décroissant des scores
                .collect(Collectors.toList());

        System.out.println("Classement des équipes :");
        int rang = 1;
        for (Map.Entry<Equipe, Integer> entry : classementTrie) {
            System.out.println(rang + ". " + entry.getKey().getNom() + " - " + entry.getValue() + " points");
            rang++;
        }
    }
    
        
        
    @Override
    public void Afficher_list_match() {
        for (Tour tour : this.getTours()){
            tour.afficherMatchs();
        }
    }
    
  
    
    @Override
    public Equipe Obtenir_gagnants() {
        // Vérifie si le classement est vide
        if (Classement.isEmpty()) {
            System.out.println("Aucune équipe dans le classement.");
            return null; // Aucun gagnant si aucune équipe
        }

        // Utilise un flux pour trier les équipes par score décroissant
        Map.Entry<Equipe, Integer> gagnant = Classement.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue()) // Trouve l'entrée avec la valeur maximale (le plus grand score)
            .orElse(null); // Si la map est vide, renvoie null

        // Si un gagnant est trouvé, renvoie l'équipe gagnante
        if (gagnant != null) {
            System.out.println("L'équipe gagnante est : " + gagnant.getKey().getNom() + " avec " + gagnant.getValue() + " points");
            return gagnant.getKey();
        } else {
            System.out.println("Aucun gagnant trouvé.");
            return null; // Si aucun gagnant n'est trouvé
        }
    }


   
    

    
}
