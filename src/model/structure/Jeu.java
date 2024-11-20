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
    private Coupe coupe;
    private Championnat championnat ;

    public Jeu() {
        Joueurs = new ArrayList<Player>() ;
    }

    

    public ArrayList<Player> getJoueurs() {
    return Joueurs;
}    
    
    public Coupe getCoupe() {
        return coupe;
    }
    public Championnat getTournoi() {
        return championnat;
    }

    public void setCoupe(Coupe coupe) {
        this.coupe = coupe;
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

