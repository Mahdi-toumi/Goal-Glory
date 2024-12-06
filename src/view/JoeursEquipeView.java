/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.elements.Equipe;
import model.elements.Joueur;
import model.structure.Jeu;
import model.structure.Match;

/**
 *
 * @author toumi
 */
public class JoeursEquipeView {
    private Scene scene;
    private Equipe equipe ; 
    private Button gobackButton;
    private Jeu jeu ;

    public JoeursEquipeView(Jeu jeu , Equipe equipe) {
        
        this.jeu = jeu ;
        this.equipe = equipe ;



        // Fond d'écran
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        background.setFitWidth(900);
        background.setFitHeight(600);

        // Conteneur principal
        StackPane root = new StackPane();

        // Titre
        int tour = this.jeu.getTour()+1;
        Label title = new Label(equipe.getNom());
        title.setFont(Font.font("Sports World", FontWeight.BOLD, 30));
        title.setTextFill(Color.WHITE);

        // Tableau des équipes
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(0);
        
        gridPane.setPrefWidth(500);  // Largeur préférée de 500 px

        gridPane.setMaxWidth(500);   // Largeur maximale de 600 px

        gridPane.setMinWidth(500);   // Largeur minimale de 400 px
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: rgba(0, 50, 0, 0.85); " +
                "-fx-background-radius: 10; " +
                "-fx-padding: 10; " +
                "-fx-border-color: yellow; " +
                "-fx-border-radius: 10; -fx-border-width: 2;"+
                "-fx-alignment: center;"+
                 "-fx-text-alignment: center;" );

        // En-têtes de colonnes
        Label team1Header = new Label("Nom");
        Label team2Header = new Label("Poste");
        team1Header.setAlignment(Pos.CENTER);
        team2Header.setAlignment(Pos.CENTER);
        styleHeader(team1Header);
        styleHeader(team2Header);

        gridPane.add(team1Header, 0, 0);
        gridPane.add(team2Header, 2, 0);
        gridPane.setAlignment(Pos.CENTER);

        

    for (int i = 0; i < equipe.getJoueurs().size(); i++) {
        Joueur joueur = equipe.getJoueurs().get(i);

        // Créer les labels pour afficher le classement

        Label Nomjoeur = new Label(joueur.getPrenom() +" " +joueur.getNom());
        Label Poste = new Label(joueur.getPoste().toString());
        Nomjoeur.setAlignment(Pos.CENTER);
        Poste.setAlignment(Pos.CENTER);

        // Appliquer le style à chaque cellule (optionnel)
        styleCell(Nomjoeur);
        styleCell(Poste);

        // Ajouter les labels à la GridPane
        gridPane.add(Nomjoeur, 0, i + 1); // La première colonne est pour le rang
        gridPane.add(Poste, 2, i + 1); // La troisième colonne est pour les points
        gridPane.setAlignment(Pos.CENTER);
    }

        // Barre de défilement
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(false);
        scrollPane.setStyle("-fx-background: transparent; -fx-padding: 0;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        scrollPane.setPrefHeight(400);  // Largeur préférée de 500 px
        
        scrollPane.setPrefWidth(500);  // Largeur préférée de 500 px

        scrollPane.setMaxWidth(500);   // Largeur maximale de 600 px

        scrollPane.setMinWidth(500);   // Largeur minimale de 400 px

        // Boutons
        gobackButton = createStyledButton("Retour", "#1e90ff", "#4682b4");
        
        HBox  hbox = new HBox (20 , gobackButton) ;
        hbox.setAlignment(Pos.CENTER);

        // Conteneur principal vertical
        VBox vbox = new VBox(20, title, scrollPane, hbox);
        vbox.setAlignment(Pos.CENTER);

        // Ajouter les éléments au StackPane
        root.getChildren().addAll(background, vbox);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }

    private void styleHeader(Label label) {
    label.setStyle("-fx-font-weight: bold; " +
                   "-fx-font-family: 'Sports World'; " +
                   "-fx-padding: 15; " +
                   "-fx-text-fill: yellow; " +
                   "-fx-text-alignment: center; " +
                   "-fx-font-size: 18px; " +
                   "-fx-alignment: center;"); // Ensure CSS alignment
    label.setAlignment(Pos.CENTER); // Ensure programmatic alignment
}

    

    private void styleCell(Label label) {
    label.setStyle("-fx-text-fill: white; " +
                   "-fx-padding: 15; " +
                   "-fx-font-family: 'Sports World'; " +
                   "-fx-font-size: 14px; " +
                   "-fx-text-alignment: center; " + // Center text inside label
                   "-fx-alignment: center;"); // Align in cell
    label.setAlignment(Pos.CENTER); // Programmatic alignment
}


    private Button createStyledButton(String text, String color, String hoverColor) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: " + color + ";" +
                "-fx-text-fill: white;" +                                               // Texte en blanc
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-font-size: 20px;" +                                                // Taille du texte
                "-fx-padding: 10px 15px;" +                                             // Espacement interne
                "-fx-background-radius: 20px;" +                                        // Coins arrondis
                "-fx-border-radius: 20px;" +                                            // Bordure arrondie
                "-fx-border-color: #006400;" +                                          // Bordure verte
                "-fx-border-width: 3px;" +                                              // Largeur de la bordure
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: " + hoverColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 10px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
                
        ));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: " + color + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 10px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
        ));
        return button;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getBackButton(){
        return this.gobackButton ;
    }
    
    
}
    

