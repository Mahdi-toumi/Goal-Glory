/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

/**
 *
 * @author toumi
 */
public abstract sealed class Joueur implements Comparable<Joueur> permits Tireur, Gardien {

    private String nom;
    private String prenom;
    private int age;
    private Poste poste;
    

    public Joueur(String nom, String prenom, int age, Poste poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.poste = poste;
    }

    // Getters
    public String getNom() {return nom;}

    public String getPrenom() {return prenom;}

    public int getAge() {return age;}

    public Poste getPoste() {return poste;}

    

    // Setters
    public void setNom(String nom) {this.nom = nom;}

    public void setPrenom(String prenom) { this.prenom = prenom;}

    public void setAge(int age) {this.age = age;}

    public void setPoste(Poste poste) {this.poste = poste;}

    
    
    @Override
    public int compareTo(Joueur other) {
        return Integer.compare(this.age, other.age);
    }

    
    @Override
    public String toString() {
        return "Joueur{" +
               "nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", age=" + age +
               ", poste=" + poste +
               '}';
    }
    
    
   
    
}

