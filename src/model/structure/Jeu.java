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
    private Difficulte niveau ;
    private Tournoi tournoi;

    public Jeu(Match matchActuel, Tournoi tournoi) {
        this.niveau = Difficulte.Intermediaire ; 
        this.tournoi = tournoi;
        Joueurs = new ArrayList<Player>() ;
    }
    public Jeu() {
        this.niveau = Difficulte.Intermediaire ; 
        Joueurs = new ArrayList<Player>() ;
    }
    

    public ArrayList<Player> getJoueurs() {
    return Joueurs;
}    
    
    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
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

