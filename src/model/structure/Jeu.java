/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

import java.util.ArrayList;



/**
 *
 * @author toumi
 */
public class Jeu {
    
    private ArrayList<Player>  Joueurs ; 
    private Coupe coupe = null;
    private Championnat championnat = null ;
    private Player JoueurCourant = null ;
    private Difficulte difficulte ;
    private int tour = 0;

    public Jeu() {
        Joueurs = new ArrayList<Player>() ;
        difficulte = Difficulte.Intermediaire ;
    }

    

    public ArrayList<Player> getJoueurs() {
    return Joueurs;
}    
    
    public Coupe getCoupe() {
        return coupe;
    }
    public Championnat getChampionnat() {
        return championnat;
    }
    
    public Player getPlayer() {
        return JoueurCourant;
    }
    
    public int getTour() {
        return tour ;
    }
    
    
    public void setPlayer(Player JoueurCourant) {
        this.JoueurCourant = JoueurCourant;
    }

    public void setCoupe(Coupe coupe) {
        this.coupe = coupe;
    }
    
    public void setTour(int t) {
        this.tour = t;
    }
    
    
    public void setChampionnat(Championnat championnat) {
        this.championnat = championnat;
    }
    
    public void ajouterPlayer (Player e ) {
       
        for (Player player : Joueurs) {
            if (player.getNom() == e.getNom()) {
                if (player.getScore() >= e.getScore())   return  ;
                
            }
            else {
                this.Joueurs.add(e) ;
            }
        }
        
        
    }

    public void afficherClassementJoeurs (){
        for(Player joueur : Joueurs) {
            System.out.println(joueur);
        }
    }
}

