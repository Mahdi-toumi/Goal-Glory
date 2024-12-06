package model.elements;

import javafx.scene.image.ImageView;

/**
 *
 * @author toumi
 */
// Gardien.java
public final class Gardien extends Joueur {
    private double pourcentageDeSauvetage;
    private ImageView gloves;
    public Gardien(String nom, String prenom, int age) {
        super(nom, prenom, age, Poste.GARDIEN);
        //this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }

    // Méthode pour essayer d'arrêter un tir
    public boolean arreterTir(Ballon ballon) {
        double chanceArrêt = this.pourcentageDeSauvetage;
        return Math.random() < chanceArrêt;
    }

    //@Override
    public void jouer() {
        // Logique de jeu du gardien
    }

    /*public double getPourcentageDeSauvetage() {
        return pourcentageDeSauvetage;
    }

    public void setPourcentageDeSauvetage(double pourcentageDeSauvetage) {
        this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }*/
    public double getpourcentageDeSauvetage() {
        return pourcentageDeSauvetage;
    }

    public void setpourcentageDeSauvetage(double pos) {
        this.pourcentageDeSauvetage=pos;
    }
}
