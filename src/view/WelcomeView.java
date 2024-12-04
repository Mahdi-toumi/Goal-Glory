package view;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class WelcomeView {

    private MediaView mediaView;
    private MediaPlayer song;
    private Button startButton;
    private Button quitButton;
    private Stage primaryStage;

    public WelcomeView(Stage primaryStage) {
        this.primaryStage = primaryStage;

        
        
        String MenuSong = getClass().getResource("/audio/MenuSong.mp3").toExternalForm();
        song = new MediaPlayer(new Media(MenuSong));
        song.setVolume(0.4);
        
        
        // Créer une vidéo en arrière-plan
        String videoPath = getClass().getResource("/images/Intro.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0);
        mediaPlayer.setCycleCount(1); // Lire une seule fois
        mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(900);
        mediaView.setFitHeight(600);
        




        // Créer une image pour l'arrière-plan qui s'affiche après 4 secondes
        ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        backgroundImage.setFitWidth(900);
        backgroundImage.setFitHeight(600);
        backgroundImage.setVisible(false); // Masquer initialement

        // Texte du titre
        Text titleText = new Text("Goal Glory");
        titleText.setFont(Font.font("Sports World", 60));
        titleText.setStyle(
            "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
            "-fx-stroke: black;" +                                                   // Contour noir
            "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
        );
        titleText.setVisible(false); // Masquer initialement

        // Initialiser les boutons "Start" et "Quit"
        startButton = new Button("Start");
        quitButton = new Button("Quit");
        startButton.setFont(Font.font("Sports World", 20)); // Police Verdana, taille 20
        quitButton.setFont(Font.font("Sports World", 20)); // Même style pour les deux boutons
        // Pour le bouton "Start"
        startButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 24px;" +                                                // Taille du texte
            "-fx-padding: 15px 30px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            "-fx-border-color: #006400;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );

        // Pour le bouton "Quit"
        quitButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #FF4500, #8B0000);" +  // Dégradé rouge (orange vif à rouge foncé)
            "-fx-text-fill: white;" +                                                // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                     // Police Sportive
            "-fx-font-size: 24px;" +                                                 // Taille du texte
            "-fx-padding: 15px 30px;" +                                              // Espacement interne
            "-fx-background-radius: 20px;" +                                         // Coins arrondis
            "-fx-border-radius: 20px;" +                                             // Bordure arrondie
            "-fx-border-color: #800000;" +                                           // Bordure rouge
            "-fx-border-width: 3px;" +                                               // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"    // Ombre portée
        );

        // Pour l'effet de survol (hover)
        startButton.setOnMouseEntered(e -> {
            startButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #32CD32, #006400);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });

        startButton.setOnMouseExited(e -> {
            startButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });

        quitButton.setOnMouseEntered(e -> {
            quitButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #FF6347, #800000);" +  // Dégradé rouge-orangé
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #800000;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +
                "-fx-scale-y: 1.1;"
            );
        });

        quitButton.setOnMouseExited(e -> {
            quitButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #FF4500, #8B0000);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 24px;" +
                "-fx-padding: 15px 30px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #800000;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +
                "-fx-scale-y: 1;"
            );
        });

        startButton.setVisible(false); // Masquer initialement
        quitButton.setVisible(false); // Masquer initialement

        // Ajouter les éléments au layout
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(mediaView, backgroundImage, titleText, startButton, quitButton);

        // Positionnement
        StackPane.setAlignment(titleText, Pos.TOP_CENTER);
        StackPane.setMargin(titleText, new javafx.geometry.Insets(100, 0, 0, 0));
        StackPane.setMargin(startButton, new javafx.geometry.Insets(0, 0, 100, 0));
        StackPane.setAlignment(quitButton, Pos.CENTER);
        StackPane.setMargin(quitButton, new javafx.geometry.Insets(100, 0, 0, 0));

        
        
        // Créer la scène
        Scene welcomeScene = new Scene(layout, 900, 600);
        song.play();
        // Configurer la scène et afficher la fenêtre
        primaryStage.setTitle("Welcome to Goal Glory");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

        // Définir les transitions
        setupTransitions(mediaPlayer, backgroundImage, titleText, startButton, quitButton);
    }

        private void setupTransitions(MediaPlayer mediaPlayer, ImageView backgroundImage, Text titleText, Button startButton, Button quitButton) {
        // Transition pour afficher l'image après 4 secondes
        PauseTransition showImageTransition = new PauseTransition(Duration.seconds(6.3));
        showImageTransition.setOnFinished(event -> {
            mediaPlayer.stop(); // Arrêter la vidéo
            mediaView.setVisible(false); // Masquer la vidéo

            // Appliquer un flou initial sur l'image
            GaussianBlur blur = new GaussianBlur(10); // Flou de départ
            backgroundImage.setEffect(blur);
            backgroundImage.setVisible(true); // Afficher l'image

            // Transition de flou à nette (flou -> net) sur 1 seconde
            Timeline blurToClearTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(backgroundImage.effectProperty(), blur)), // Début avec flou
                new KeyFrame(Duration.seconds(1), new KeyValue(backgroundImage.effectProperty(), new GaussianBlur(0))) // Fin sans flou
            );

            // Transition de fondu de l'image (apparaît progressivement)
            FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), backgroundImage);
            fadeInTransition.setFromValue(0); // Commencer à partir d'une opacité nulle
            fadeInTransition.setToValue(1); // Finir avec une opacité de 1

            // Lancer les deux transitions simultanément
            fadeInTransition.play();
            blurToClearTimeline.play();
        });

        // Transition pour afficher les boutons et le texte après 4.5 secondes
        PauseTransition showTextAndButtonsTransition = new PauseTransition(Duration.seconds(6.3));
        showTextAndButtonsTransition.setOnFinished(event -> {
            titleText.setVisible(true); // Afficher le texte
            startButton.setVisible(true); // Afficher le bouton "Start"
            quitButton.setVisible(true); // Afficher le bouton "Quit"
        });

        // Lancer les transitions
        showImageTransition.play();
        showTextAndButtonsTransition.play();
    }


    

    // Getters pour les boutons
    
     public Stage getPrimaryStage() {
        return primaryStage;
    }
    public Button getStartButton() {
        return startButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }
}
