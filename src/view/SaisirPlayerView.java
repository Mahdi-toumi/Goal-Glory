/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaisirPlayerView {

    private Scene scene;
    private TextField nomField;
    private Button validerButton;

    public SaisirPlayerView() {
        // Création du conteneur principal
        StackPane root = new StackPane();

        // Ajouter une image en arrière-plan
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.png")));
        background.setFitWidth(900);
        background.setFitHeight(500);
        
         // Ajouter un texte avant l'input (label)
        Label label = new Label("Saisir votre nom:");
        label.setStyle(
                "-fx-font-size: 18px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: white;" // Ajouter la couleur blanche
        );

        // Champ pour saisir le nom du joueur
        nomField = new TextField();
        nomField.setPromptText("Entrez votre nom");
        nomField.setStyle(
                "-fx-font-size: 18px; " +
                "-fx-pref-width: 100px; " +
                "-fx-padding: 10px; " +
                "-fx-border-color: lightgray; " +
                "-fx-border-radius: 10px; " +
                "-fx-background-radius: 10px;"
        );

        // Bouton "Valider"
        validerButton = new Button("Valider");
        validerButton.setStyle(
                "-fx-font-size: 18px; " +
                "-fx-padding: 10px 20px; " +
                "-fx-border-radius: 15px; " +
                "-fx-background-radius: 15px; " +
                "-fx-background-color: #3498db; " +
                "-fx-text-fill: white;"
        );

        // Positionner les éléments au centre
        VBox vbox = new VBox(10, label, nomField, validerButton); // Espacement de 10px entre les éléments
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(300); // Optionnel : définir une largeur fixe pour la VBox
        nomField.setMaxWidth(200); // Limiter la largeur du champ de texte

        // Ajouter les éléments au conteneur principal
        root.getChildren().addAll(background, vbox);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }

    // Getter pour la scène
    public Scene getScene() {
        return scene;
    }

    // Getter pour le champ de saisie
    public TextField getNomField() {
        return nomField;
    }

    // Getter pour le bouton
    public Button getValiderButton() {
        return validerButton;
    }
    
    public void close() {
    Stage stage = (Stage) nomField.getScene().getWindow(); // Récupérer le stage de la scène
    stage.close();
}
}

