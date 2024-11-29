/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

import model.elements.Equipe;
import model.structure.exceptions.AjoutEquipeException;
import model.structure.exceptions.AjoutMatchException;
import model.structure.exceptions.AjoutStadeException;
import model.structure.exceptions.AjoutTourException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Classe abstraite représentant un tournoi. 
 * Contient la structure de base et des méthodes pour gérer les équipes et les matchs.
 * 
 * @author toumi
 */
    public abstract sealed class Tournoi permits Coupe, Championnat {
    private String Nom ; 
    private ArrayList<Equipe> equipes;
    private ArrayList<Tour> Tours;
    private ArrayList<Stade> stades;
    
    
    public Tournoi (String Nom) {
        this.Nom=Nom ;
        this.equipes = new ArrayList<>() ;
        this.Tours = new ArrayList<>() ;
        this.Tours = new ArrayList<>() ;
        this.stades = new ArrayList<>();
    }
    
     // Méthode qui applique une action sur chaque équipe du tournoi
    public void appliquerActionSurEquipes(ActionEquipe action) {
        for (Equipe equipe : equipes) {
            action.appliquer(equipe);
        }
    }
    
    public void appliquerActionSurMatchs(ActionMatch action) {
        for (Tour tour : Tours) {
            for (Match match : tour.getMatchs()) {
                action.appliquer(match);
            }
        }
    }
    
    public void afficherDetailsMatchs() {
         appliquerActionSurMatchs(match -> System.out.println(match.toString()));
    }
    
    public String getNom () {
        return this.Nom ;
    }
    public ArrayList<Equipe> getEquipes () {
        return this.equipes ;
    }
    
    public ArrayList<Tour> getTours () {
        return this.Tours ;
    }
    
    
    //Choisir un stade au hasard
    public Stade choisirStade() {
        if (this.stades.isEmpty()) {
            throw new IllegalStateException("Aucun stade n'est disponible.");
        }
        Collections.shuffle(this.stades);
        return this.stades.get(0);
    }
    
    
        // Ajouter une équipe
    public void ajouterEquipe(Equipe e) throws AjoutEquipeException {
        if (equipes.contains(e)) {
            throw new AjoutEquipeException("L'équipe " + e.getNom() + " existe déjà dans le tournoi !");
        }
        this.equipes.add(e);
    }

    // Ajouter un stade
    public void ajouterStade(Stade s) throws AjoutStadeException {
        if (stades.contains(s)) {
            throw new AjoutStadeException("Le stade " + s.nom() + " existe déjà dans le tournoi !");
        }
        this.stades.add(s);
    }
    
    //Ajouter un tour au Tournoi 
    public void ajouterTour(Tour t) throws AjoutTourException {
        for (Tour tourExistant : Tours) {
            if (tourExistant.getNumTour() == t.getNumTour()) { 
                throw new AjoutTourException("Ce tour existe déjà dans le tournoi !");
            }
        }
        this.Tours.add(t);
        System.out.println("Ajout avec succès");
    }
    
    
    // Afficher les équipes triées
    public void afficherListeEquipes() {
        this.equipes.stream()
            .sorted((e1, e2) -> e1.getNom().compareTo(e2.getNom()))
            .forEach(System.out::println);
    }
    
    public abstract void Afficher_list_match ();
    public abstract void Initialiser_tournoi () ; // Creeer les match a jouer dans le tournoi
    public abstract Equipe Obtenir_gagnants () ;
    
    @Override
    public String toString() {
        return "Tournoi : " + this.Nom ;
    }
    
}
