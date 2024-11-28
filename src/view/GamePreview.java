/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.structure.Match;

/**
 *
 * @author lenovo
 */
public class GamePreview {
    private MediaView mediaView;
    private Button startButton;
    private Scene scene;
    private Match match;
    
    public GamePreview(Match match){
        this.match=match;
        // Créer une vidéo en arrière-plan
        String videoPath = getClass().getResource("/images/Football.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0);
        mediaPlayer.setCycleCount(1); // Lire une seule fois
        mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(900);
        mediaView.setFitHeight(600);
        ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.png")));
        backgroundImage.setFitWidth(900);
        backgroundImage.setFitHeight(600);
        backgroundImage.setVisible(false); // Masquer initialement
        Text titleText = new Text(match.affichageAbr());
        titleText.setFont(Font.font("Sports World", 60));
        titleText.setStyle(
            "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
            "-fx-stroke: black;" +                                                   // Contour noir
            "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
        );
        titleText.setVisible(false); // Masquer initialement
        
        startButton = new Button("Click Here To Start !");
        startButton.setStyle(
            "-fx-background-color: #00FFFFFF;" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 24px;" +                                                // Taille du texte
            "-fx-padding: 15px 30px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            "-fx-border-color: #00FFFFFF;" +                                          // Bordure verte
            "-fx-border-width: 3px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"   // Ombre portée
        );
        startButton.setVisible(false); // Masquer initialement
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(mediaView, backgroundImage, titleText, startButton);

        // Positionnement
        StackPane.setAlignment(titleText, Pos.TOP_CENTER);
        StackPane.setMargin(titleText, new javafx.geometry.Insets(100, 0, 0, 0));
        StackPane.setMargin(startButton, new javafx.geometry.Insets(0, 0, 100, 0));
        
        scene = new Scene(layout, 900, 600);
        
        // Définir les transitions
        setupTransitions(mediaPlayer, backgroundImage, titleText, startButton);

    }
    private void setupTransitions(MediaPlayer mediaPlayer, ImageView backgroundImage, Text titleText, Button startButton) {
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
            FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(2), backgroundImage);
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
        });

        // Lancer les transitions
        showImageTransition.play();
        showTextAndButtonsTransition.play();
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public void setMatch(Match match){
        this.match=match;
    }
    public Button getNextButton(){
        return this.startButton;
    }
   
}
