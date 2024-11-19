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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ChoisirTournoiView {

    private Scene scene;
    private Button coupeButton;
    private Button championnatButton;

    public ChoisirTournoiView() {
        // Création du conteneur principal
        StackPane root = new StackPane();

        // Ajouter une image en arrière-plan
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        background.setFitWidth(900);
        background.setFitHeight(600);
        
        ImageView imagecoupe = new ImageView(new Image(getClass().getResourceAsStream("/images/coupe.png")));
        imagecoupe.setFitWidth(250);
        imagecoupe.setFitHeight(200);
        
        ImageView imagechompionnat = new ImageView(new Image(getClass().getResourceAsStream("/images/Chompionnat.png")));
        imagechompionnat.setFitWidth(250);
        imagechompionnat.setFitHeight(200);
            
        // Label d'instruction
        Label label = new Label("Choisissez le type de tournoi : ");
        label.setStyle(
                "-fx-font-size: 20px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: white;"
        );

        // Bouton pour "Coupe"
        coupeButton = new Button("Coupe");
         styleButton(coupeButton);

        // Bouton pour "Championnat"
        championnatButton = new Button("Championnat");
         styleButton(championnatButton);
        
        VBox coupe = new VBox(20, imagecoupe, coupeButton); // Espacement de 20px
        coupe.setAlignment(Pos.CENTER);
        
        VBox chompionnat = new VBox(20, imagechompionnat, championnatButton); // Espacement de 20px
        chompionnat.setAlignment(Pos.CENTER);

        // Positionner les éléments au centre
        HBox hbox = new HBox(100,coupe, chompionnat); // Espacement de 20px
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, label, hbox); // Espacement de 20px
        vbox.setAlignment(Pos.CENTER);
        
        
        StackPane.setAlignment(coupeButton, Pos.BOTTOM_CENTER); // Aligner le VBox en bas
        StackPane.setAlignment(championnatButton, Pos.BOTTOM_CENTER); // Aligner le VBox en bas
        

        // Ajouter les éléments au conteneur principal
        root.getChildren().addAll(background, vbox);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }
    
    private void styleButton(Button button) {
        button.setStyle(
                "-fx-font-size: 18px; " +
                "-fx-padding: 10px 40px; " + // Assurez-vous que tous les boutons aient la même largeur
                "-fx-border-radius: 15px; " +
                "-fx-background-radius: 15px; " +
                "-fx-background-color: #3498db; " +
                "-fx-text-fill: white;"
        );
        button.setMinWidth(200); // Largeur minimale pour uniformiser les boutons
        button.setPrefWidth(200); // Largeur préférée identique pour tous
    }

    // Getters pour la scène et les boutons
    public Scene getScene() {
        return scene;
    }

    public Button getCoupeButton() {
        return coupeButton;
    }

    public Button getChampionnatButton() {
        return championnatButton;
    }
}

