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
import javafx.scene.media.MediaPlayer;

public class ChoisirTournoiView {

    private Scene scene;
    private Button worldCupButton;
    private Button championsLeagueButton;
    private Button laLigaButton ; 
    private Button premierLeagueButton ;
    


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
             "-fx-alignment: center;"  +  
            "-fx-text-alignment: center;"  
        );

        // Bouton pour "World Cup"
        worldCupButton = new Button("World Cup");
        worldCupButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #32CD32, #228B22);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 24px;" +                                                // Taille du texte
            "-fx-padding: 15px 30px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            " -fx-border-color: yellow;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
         
        worldCupButton.setOnMouseEntered(e -> {
            worldCupButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #32CD32, #228B22);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                " -fx-border-color: yellow;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });    
        
        worldCupButton.setOnMouseExited(e -> {
            worldCupButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #32CD32, #228B22);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                " -fx-border-color: yellow;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });
        // Bouton pour "Champions League"
        championsLeagueButton = new Button("Champions League");
        championsLeagueButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #1E3A6F, #14274E);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 24px;" +                                                // Taille du texte
            "-fx-padding: 15px 30px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            "-fx-border-color: gray;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
         
        championsLeagueButton.setOnMouseEntered(e -> {
            championsLeagueButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #1E3A6F, #14274E);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: gray;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });    
        
        championsLeagueButton.setOnMouseExited(e -> {
            championsLeagueButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #1E3A6F, #14274E);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: gray;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });
        
        laLigaButton = new Button("La Liga");
        laLigaButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #8B0000, #FF4500);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 24px;" +                                                // Taille du texte
            "-fx-padding: 15px 30px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            " -fx-border-color: white;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
         
        laLigaButton.setOnMouseEntered(e -> {
            laLigaButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #8B0000, #FF4500);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                " -fx-border-color: white;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });    
        
        laLigaButton.setOnMouseExited(e -> {
            laLigaButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #8B0000, #FF4500);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                " -fx-border-color: white;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });
        
        premierLeagueButton = new Button("Premier League");
        premierLeagueButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #5B0E96, #A349A4);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 24px;" +                                                // Taille du texte
            "-fx-padding: 15px 30px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            " -fx-border-color: gold;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
         
        premierLeagueButton.setOnMouseEntered(e -> {
            premierLeagueButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #5B0E96, #A349A4);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                " -fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });    
        
        premierLeagueButton.setOnMouseExited(e -> {
            premierLeagueButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #5B0E96, #A349A4);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                " -fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });
        
        worldCupButton.setMinWidth(350); // Largeur minimale pour uniformité
        worldCupButton.setPrefWidth(350); // Largeur préférée
        championsLeagueButton.setMinWidth(350); // Largeur minimale pour uniformité
        championsLeagueButton.setPrefWidth(350); // Largeur préférée
        laLigaButton.setMinWidth(350); // Largeur minimale pour uniformité
        laLigaButton.setPrefWidth(350); // Largeur préférée
        premierLeagueButton.setMinWidth(350); // Largeur minimale pour uniformité
        premierLeagueButton.setPrefWidth(350); // Largeur préférée
        
        
        
        // Positionner les boutons dans deux colonnes
        VBox vbox1 = new VBox(40, worldCupButton, championsLeagueButton); // Espacement de 40px entre les boutons
        vbox1.setAlignment(Pos.CENTER);

        VBox vbox2 = new VBox(40, laLigaButton, premierLeagueButton); // Espacement de 40px entre les boutons
        vbox2.setAlignment(Pos.CENTER);

        // Disposer les deux colonnes côte à côte
        HBox hbox = new HBox(40, vbox1, vbox2); // Espacement de 40px entre les colonnes
        hbox.setAlignment(Pos.CENTER);

        // Ajouter le label au-dessus des boutons
        VBox vbox = new VBox(40, label, hbox); // Espacement de 40px entre le label et le HBox
        vbox.setAlignment(Pos.CENTER);

        // Ajouter les éléments au conteneur principal
        root.getChildren().addAll(background, vbox);


        // Créer la scène
        scene = new Scene(root, 900, 600);
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
    
    public Button getlaLigaButton() {
        return this.laLigaButton;
    }

    public Button getpremierLeagueButton() {
        return this.premierLeagueButton;
    }
}

