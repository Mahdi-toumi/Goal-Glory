/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

/**
 *
 * @author toumi
 */
// Gardien.java
public final class Gardien extends Joueur {
    
    private double pourcentageDeSauvetage;
    private int arretsEffectues ;

    public Gardien(String nom, String prenom, int age, Equipe equipe, double pourcentageDeSauvetage) {
        super(nom, prenom, age, Poste.GARDIEN, equipe);
        this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }

    

   
    public double getPourcentageDeSauvetage() {return pourcentageDeSauvetage;}
    public int getArretsEffectues() {return arretsEffectues;}

    public void setArretsEffectues(int arretsEffectues) {this.arretsEffectues = arretsEffectues;}
    public void setPourcentageDeSauvetage(double pourcentageDeSauvetage) {this.pourcentageDeSauvetage = pourcentageDeSauvetage;}
    
}


