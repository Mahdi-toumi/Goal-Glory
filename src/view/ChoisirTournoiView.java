/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ChoisirTournoiView {

    private Scene scene;
    private Button worldCupButton;
    private Button championsLeagueButton;

    public ChoisirTournoiView() {
        // Création du conteneur principal
        StackPane root = new StackPane();

        // Ajouter une image en arrière-plan (terrain de football)
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        background.setFitWidth(900);
        background.setFitHeight(600);

        // Label d'instruction
        Label label = new Label("Choisissez votre tournoi :");
        label.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-family: 'Sports World';" +
            "-fx-pref-width: 1000px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;" + // White color for contrast
            "-fx-effect: dropshadow(gaussian, black, 4, 0.5, 1, 1);" +// Shadow for better visibility
            "-fx-alignment: center;" +  
            "-fx-text-alignment: center;"  
        );

        // Bouton pour "World Cup"
        worldCupButton = new Button("World Cup");
        worldCupButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 18px;" +                                                // Taille du texte
            "-fx-padding: 15px 15px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            "-fx-border-color: #006400;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
        // Bouton pour "Champions League"
        championsLeagueButton = new Button("Champions League");
        championsLeagueButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 18px;" +                                                // Taille du texte
            "-fx-padding: 15px 15px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            "-fx-border-color: #006400;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
        // Positionner les éléments au centre
        VBox vbox = new VBox(30, label, worldCupButton, championsLeagueButton); // Espacement de 30px entre les éléments
        vbox.setAlignment(Pos.CENTER);

        // Ajouter les éléments au conteneur principal
        root.getChildren().addAll(background, vbox);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }

    /**
     * Méthode pour styliser les boutons en fonction du thème du football.
     *
     * @param button Le bouton à styliser
     * @param startColor Couleur initiale du dégradé
     * @param endColor Couleur finale du dégradé
     */
    private void styleButton(Button button, String startColor, String endColor) {
        button.setStyle(
            "-fx-font-size: 20px;" + // Taille du texte
            "-fx-font-family: 'Arial Black';" + // Police de caractères sportive
            "-fx-text-fill: white;" + // Texte blanc
            "-fx-padding: 15px 40px;" + // Espacement interne
            "-fx-border-radius: 20px;" + // Bordure arrondie
            "-fx-background-radius: 20px;" + // Fond arrondi
            "-fx-background-color: linear-gradient(to right, " + startColor + ", " + endColor + ");" + // Dégradé
            "-fx-border-width: 3px;" +
            "-fx-border-color: white;" // Bordure blanche
        );
        button.setMinWidth(250); // Largeur minimale pour uniformité
        button.setPrefWidth(250); // Largeur préférée
    }

    // Getters pour la scène et les boutons
    public Scene getScene() {
        return scene;
    }

    public Button getWorldCupButton() {
        return worldCupButton;
    }

    public Button getChampionsLeagueButton() {
        return championsLeagueButton;
    }
}

