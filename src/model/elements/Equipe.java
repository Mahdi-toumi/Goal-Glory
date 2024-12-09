/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.elements.exceptions.EquipePleineException;
import model.elements.exceptions.EquipeVideException;
import model.elements.exceptions.JoueurNonTrouveException;
import model.elements.exceptions.PointsInvalideException;
import model.structure.ActionMatch;
import model.structure.Match;
import model.structure.Tour;

/**
 *
 * @author toumi
 */

public class  Equipe  implements Comparable<Equipe> {
    
    private String nom;
    private String entraineur;
    private final String Abreviation;
    private ArrayList<Joueur> joueurs;
    private int points = 0 ;

    public Equipe(String nom, String entraineur, String Abr)  {
        this.nom = nom;
        this.entraineur = entraineur;
        this.Abreviation=Abr;
        this.joueurs = new ArrayList<>();
    }

    // Getters
    public String getNom() {return nom;}
    
    public int  getPoints (){return this.points ;}
    
    public String getAbr() {return Abreviation;}
    
    public String getEntraineur() {return entraineur;}

    public ArrayList<Joueur> getJoueurs() {return joueurs;}
    
    

    // Setters
    public void setNom(String nom) {this.nom = nom;}

    public void setEntraineur(String entraineur) {this.entraineur = entraineur;}

    public void setJoueurs(ArrayList<Joueur> joueurs) {this.joueurs = joueurs;}
    
    public void setPoints(int points) throws PointsInvalideException {
        if (points < 0) {
            throw new PointsInvalideException("Les points ne peuvent pas être négatifs !");
        }
        this.points = points;
    }

    
    public void appliquerActionSurJoueurs(PlayerAction action) {
        for (Joueur joueur : joueurs) {
                action.apply(joueur);
            
        }
    }

    
    
    // Ajouter un joueur
    public void ajouterJoueur(Joueur joueur) throws EquipePleineException {
        if (joueurs.size() >= 11) { // Limite de 11 joueurs
            throw new EquipePleineException("L'équipe est déjà complète !");
        }
        joueurs.add(joueur);
    }

    // Supprimer un joueur
    public void supprimerJoueur(Joueur joueur) throws JoueurNonTrouveException {
        if (!joueurs.contains(joueur)) {
            throw new JoueurNonTrouveException("Le joueur n'existe pas dans l'équipe !");
        }
        joueurs.remove(joueur);
    }
    
    
    // Vérifier si l'équipe est vide
    public void verifierEquipeVide() throws EquipeVideException {
        if (joueurs.isEmpty()) {
            throw new EquipeVideException("L'équipe est vide !");
        }
    }
    
    
    public List<Joueur> obtenirJoueursParPoste(Poste poste) {
        return joueurs.stream()
                .filter(joueur -> joueur.getPoste().equals(poste))
                .collect(Collectors.toList());
    }
    
    public static List<Joueur> trierJoueurNom(List<Joueur> players) {
        return players.stream()
                      .sorted(Comparator.comparing(Joueur::getNom))
                      .collect(Collectors.toList());
    }
    

    

    public Map<Joueur, Poste> obtenirCompositionEquipe() { // Obtenir un map sur les joeurs avec son poste 
        Map<Joueur, Poste> Composition = new HashMap<>();
        for (Joueur joueur : joueurs) {
            Composition.put(joueur, joueur.getPoste());
        }
        return Composition;
    }
    
    // Implémentation de Comparable pour trier les équipes par nombre de points
    @Override
    public int compareTo(Equipe autreEquipe) {
        return Integer.compare(this.points, autreEquipe.points); // Tri par points
    }
    
    
    @Override
    public String toString() {
        return "Equipe : " + nom + " Entraineur: " + entraineur + " Points : " + this.points +  " Abreviation: " +this.Abreviation ;
    }
    
    
    
    
}
