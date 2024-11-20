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
            "-fx-font-size: 26px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;" // Texte blanc
        );

        // Bouton pour "World Cup"
        worldCupButton = new Button("World Cup");
        styleButton(worldCupButton, "#1e90ff", "#000080"); // Couleurs bleu clair et bleu foncé

        // Bouton pour "Champions League"
        championsLeagueButton = new Button("Champions League");
        styleButton(championsLeagueButton, "#ff4500", "#b22222"); // Couleurs orange et rouge

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
