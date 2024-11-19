/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class WelcomeView {

    private MediaView mediaView;
    private Button startButton;
    private Button quitButton;
    private Stage primaryStage; // Stage principal

    // Constructeur modifié pour prendre primaryStage
    public WelcomeView(Stage primaryStage) {
        this.primaryStage = primaryStage; // Initialiser primaryStage

        // Créer le texte "Goal Glory"
        Text titleText = new Text("Goal Glory");
        StackPane.setAlignment(titleText, Pos.TOP_CENTER);  // Positionner le texte en haut au centre
        
        // Appliquer une police à ce texte
        titleText.setFont(Font.font("Verdana", 50));  // Utilisation de la police Verdana avec une taille de 50
        titleText.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1px;");  // Style blanc avec un contour noir

        // Initialiser les boutons "Start" et "Quit"
        startButton = new Button("Start");
        quitButton = new Button("Quit");

        // Styliser les boutons
        styleButton(startButton);
        styleButton(quitButton);

        // Créer la vidéo en arrière-plan
        String videoPath = getClass().getResource("/images/Football.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);  // Lecture automatique
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);  // Lire en boucle
        mediaView = new MediaView(mediaPlayer);

        // Adapter la taille de la vidéo
        mediaView.setFitWidth(900);
        mediaView.setFitHeight(600);

        // Créer un layout pour organiser les éléments
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(mediaView, titleText, startButton, quitButton);

        // Ajuster l'espacement entre le texte et les boutons
        StackPane.setMargin(titleText, new javafx.geometry.Insets(100, 0, 0, 0));  // Déplacer le texte vers le bas de 100 pixels
        StackPane.setMargin(startButton, new javafx.geometry.Insets(0, 0, 100, 0));  // Ajuster l'espacement entre bouton Start et Quit
        StackPane.setMargin(quitButton, new javafx.geometry.Insets(100, 0, 0, 0));  // Ajuster l'espacement en bas des boutons

        // Créer la scène de bienvenue avec le layout
        Scene welcomeScene = new Scene(layout, 900, 600);

        // Configurer la scène
        primaryStage.setTitle("Welcome to Goal Glory");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    // Getter pour primaryStage
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    // Getter pour les boutons
    public Button getStartButton() {
        return startButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    // Méthode pour styliser un bouton
    private void styleButton(Button button) {
        button.setStyle(
            "-fx-background-color: transparent;" +    // Fond transparent
            "-fx-border-color: white;" +               // Bordure blanche
            "-fx-border-width: 2;" +                   // Largeur de la bordure
            "-fx-text-fill: white;" +                   // Texte en blanc
            "-fx-font-size: 30px;" +                    // Taille de la police plus grande
            "-fx-padding: 10px 20px;" +                 // Espacement interne pour un bouton plus grand
            "-fx-background-radius: 15px;" +            // Coins arrondis
            "-fx-border-radius: 15px;"                  // Bordure arrondie
        );
    }
}

