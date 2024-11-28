/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package model.elements;


/**
 * Représente un vecteur 2D avec des opérations d'ajout et de multiplication par un scalaire.
 */
public record Vector2D(double x, double y) {

    // Méthode pour ajouter un autre vecteur
    public Vector2D ajouter(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    // Méthode pour multiplier le vecteur par un scalaire
    public Vector2D multiplier(double scalaire) {
        return new Vector2D(this.x * scalaire, this.y * scalaire);
    }
}

