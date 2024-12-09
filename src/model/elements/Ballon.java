package model.elements;

import javafx.scene.image.ImageView;




// Ballon.java
public class Ballon {
    private Vector2D position;
    private double vitesse;
    private Vector2D direction;
    private ImageView Balloon;
    public Ballon(ImageView ballon) {

        this.Balloon=ballon;
    }

   public boolean estBut(Gardien gardien, Tireur tireur) {
        double precisionTir = tireur.getPrecisionDeTir();
        double chanceArrêt = gardien.getpourcentageDeSauvetage();
        
        // Chance de marquer un but
        double chanceBut = precisionTir - chanceArrêt;

        return Math.random() < chanceBut; // Si le tir est marqué
    }

    // Getters et Setters
    public Vector2D getPosition() {
        return position;
    }

    public double getVitesse() {
        return vitesse;
    }

    public Vector2D getDirection() {
        return direction;
    }

    // Méthodes de manipulation du ballon
    public void frapper(Vector2D direction, double vitesse) {
        this.direction = direction;
        this.vitesse = vitesse;
        this.position = this.position.ajouter(direction.multiplier(vitesse));
    }
    public ImageView getBallon(){
        return Balloon;
    }

}
