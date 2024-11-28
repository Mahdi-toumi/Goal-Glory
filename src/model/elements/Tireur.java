/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

/**
 *
 * @author toumi
 */
public final class Tireur extends Joueur {  
    private double precisionDeTir;
    private int penaltiesReussis ; 

    public Tireur(String nom, String prenom, int age,Poste poste, Equipe equipe, double precisionDeTir) {
        super(nom, prenom, age, poste, equipe);
        this.precisionDeTir = precisionDeTir;
    }

    // Getters 
    public double getPrecisionDeTir() {return precisionDeTir;}
    public double getPenaltiesReussis() {return penaltiesReussis;}

    //Setters
    public void setPrecisionDeTir(double precisionDeTir) {this.precisionDeTir = precisionDeTir;}
    public void setPenaltiesReussis(int penaltiesReussis) {this.penaltiesReussis = penaltiesReussis;}

 
}

    

