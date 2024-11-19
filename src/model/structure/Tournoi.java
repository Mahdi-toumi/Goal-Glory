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
    public abstract class Tournoi {
    private String Nom ; 
    private ArrayList<Equipe> equipes;
    private ArrayList<Tour> Tours;
    private ArrayList<Stade> Stads;
    
    
    public Tournoi (String Nom) {
        this.Nom=Nom ;
        this.equipes = new ArrayList<>() ;
        this.Tours = new ArrayList<>() ;
        this.Tours = new ArrayList<>() ;
        this.Stads = new ArrayList<>();
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
        Collections.shuffle(this.Stads); 
        return this.Stads.get(0);
    }
    
    
    //Ajouter une equipe au tournoi 
    public void ajouterEquipe(Equipe e) throws AjoutEquipeException {
        for (Equipe equipeExistante : equipes) {
            if (equipeExistante.getNom().equals(e.getNom())) { 
                throw new AjoutEquipeException("Cette équipe existe déjà dans le tournoi !");
            }
        }
        this.equipes.add(e);
        System.out.println("Ajout avec succès");
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
    
    
    // Afficher la liste des equipes triees par nom (streams)
    public void afficherListeEquipes () {
        ArrayList<Equipe> equipesTriees = (ArrayList<Equipe>) equipes.stream()
                .sorted((e1, e2) -> e1.getNom().compareTo(e2.getNom())) // Comparaison par nom
                .collect(Collectors.toList());
        
        for (Equipe equipe : equipesTriees) {
            System.out.println(equipe);
        }
    }
    
    public abstract void Afficher_list_match ();
    public abstract void Initialiser_tournoi () ; // Creeer les match a jouer dans le tournoi
    public abstract Equipe Obtenir_gagnants () ;
    

    
}
