/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.elements;

/**
 *
 * @author toumi
 */
public class Ballon {
    private Vector2D position;  // Position du ballon
    private double vitesse;      // Vitesse du ballon
    private Vector2D direction;  // Direction du ballon

    public Ballon(Vector2D position, double vitesse, Vector2D direction) {
        this.position = position;
        this.vitesse = vitesse;
        this.direction = direction;
    }

    // Getters
    public Vector2D getPosition() {
        return position;
    }

    public double getVitesse() {
        return vitesse;
    }

    public Vector2D getDirection() {
        return direction;
    }

    // Setters
    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public void setDirection(Vector2D direction) {
        this.direction = direction;
    }

    // Méthode pour frapper le ballon
    public void frapperBalle(Vector2D direction, double vitesse) {
        this.direction = direction;  
        this.vitesse = vitesse;      
        this.position = this.position.ajouter(direction.multiplier(vitesse)); // Met à jour la position
    }

  
    public void reinitialiserPosition(Vector2D nouvellePosition) {
        this.position = nouvellePosition; 
    }
}

