/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

import model.elements.Equipe;
import model.structure.exceptions.AjoutStadeException;
import model.structure.exceptions.AjoutTourException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Représente un tournoi de type Coupe (élimination directe).
 * Les équipes éliminées sont enregistrées dans une liste.
 * 
 * @author toumi
 */
public final class Coupe extends Tournoi {
    private ArrayList<Equipe> equipesEliminees;
    private ArrayList<Equipe> equipesRestantes;
    private int TourActuel = 0 ;

    public Coupe(String Nom) {
        super(Nom);
        this.equipesRestantes = new ArrayList<>(); // Copier les équipes de base
        this.equipesEliminees = new ArrayList<>();
    }

    @Override
    public void Afficher_list_match() {  
        for (Tour tour : this.getTours()){
            tour.afficherMatchs();
        }
    }

     // Creer le match du 1er tour
    @Override
    public void Initialiser_tournoi() {
        this.equipesRestantes = this.getEquipes() ;
        this.Initialiser_tour();
    }
    
    public void Initialiser_tour() {
        ArrayList<Match> tousLesMatchs = new ArrayList<>();

        // Mélanger les équipes pour générer des paires aléatoires pour le premier tour
        Collections.shuffle(equipesRestantes);

        // Créer des matchs pour le premier tour
        ArrayList<Match> matchsDuTour = new ArrayList<Match>();

        // Créer des matchs par paires d'équipes
        for (int i = 0; i < equipesRestantes.size(); i += 2) {
            if (i + 1 < equipesRestantes.size()) {
                Match m = new Match(equipesRestantes.get(i), equipesRestantes.get(i + 1));
                matchsDuTour.add(m);
            } else {
                System.out.println("L'équipe " + equipesRestantes.get(i).getNom() + " passe automatiquement au tour suivant !");
                equipesRestantes.add(equipesRestantes.get(i)); // Avance automatiquement au prochain tour
            }
        }
        // Ajouter le premier tour à la liste des tours
        if (!matchsDuTour.isEmpty()) {
            
            TourActuel+=1;  // Incrémente le numéro de tour
            Tour tour = new Tour(this.TourActuel);
            tour.setMatchs(matchsDuTour);
            
            

            try {
                this.ajouterTour(tour);
            } catch (AjoutTourException e) {
                System.out.println("Erreur lors de l'ajout du tour : " + e.getMessage());
            }
        }
        this.Commencer_tournoi();
        
    }
    
    
    public void Commencer_tournoi() {
        // Initialiser le premier tour
        this.Initialiser_tournoi();

        while (equipesRestantes.size() > 1) { // Continuer tant qu'il reste plus d'une équipe
            System.out.println("Tour n°" + TourActuel + " commence !"); 
            this.Afficher_list_match() ;
            Tour tourActuel = this.getTours().get(TourActuel - 1);


            // Jouer chaque match du tour actuel
            ArrayList<Equipe> gagnantsTour = new ArrayList<>();
            for (Match match : tourActuel.getMatchs()) {
                match.jouerMatch();
                gagnantsTour.add(match.getGagnant());
            }

            // Mettre à jour les équipes restantes avec les gagnants
            equipesRestantes = gagnantsTour;

            // Préparer le prochain tour si nécessaire
            if (equipesRestantes.size() > 1) {
                
                this.Initialiser_tour();
            }
        }

        // Déterminer le vainqueur final
        if (equipesRestantes.size() == 1) {
            System.out.println("Le gagnant du tournoi est : " + equipesRestantes.get(0).getNom());
        } else {
            System.out.println("Erreur : Aucun gagnant déterminé !");
        }
    }
    
    


    @Override
    public Equipe Obtenir_gagnants() {
        return equipesRestantes.size() == 1 ? equipesRestantes.get(0) : null;
    }
    public ArrayList<Equipe> getEquipesRestantes(){
        return this.equipesRestantes;
    }

    
    

   

    
}
