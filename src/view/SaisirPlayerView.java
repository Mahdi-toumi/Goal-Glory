package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SaisirPlayerView {

    private Scene scene;
    private TextField nomField;
    private Button validerButton;
    private Button gobackButton;

    public SaisirPlayerView() {
        // Main container
        StackPane root = new StackPane();

        // Background image with a football field theme
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        background.setFitWidth(900);
        background.setFitHeight(600);

        // Label: "Enter Your Name"
        Label label = new Label("Saisir votre nom :");
        label.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-family: 'Sports World';" +
            "-fx-pref-width: 300px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;" + // White color for contrast
            "-fx-effect: dropshadow(gaussian, black, 4, 0.5, 1, 1);" // Shadow for better visibility
        );

        // TextField for player name
        nomField = new TextField();
        nomField.setPromptText("Entrez votre nom");
        nomField.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-family: 'Sports World';" +
            "-fx-pref-width: 170px;" +
            "-fx-max-width: 170px;" +
            "-fx-padding: 10px;" +
            "-fx-border-color: #1abc9c;" + // Green border
            "-fx-border-radius: 15px;" +
            "-fx-background-radius: 15px;" +
            "-fx-background-color: #ffffff;" // White background for clarity
        );

        // "Valider" Button
        validerButton = new Button("Valider");
        validerButton.setStyle(
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
        validerButton.setOnMouseEntered(e -> {
            validerButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #32CD32, #006400);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });

        validerButton.setOnMouseExited(e -> {
            validerButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });

        // "Retour" Button
        gobackButton = new Button("Retour");
        gobackButton.setStyle(
            "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
            "-fx-font-size: 16px;" +                                                // Taille du texte
            "-fx-padding: 10px 10px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
            "-fx-border-color: #006400;" +                                          // Bordure verte
            "-fx-border-width: 3px;"                                               // Largeur de la bordure
        );
        
        gobackButton.setOnMouseEntered(e -> {
            gobackButton.setStyle(
                "-fx-background-color: #1e90ff;" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                "-fx-font-size: 16px;" +                                                // Taille du texte
                "-fx-padding: 10px 10px;" +                                             // Espacement interne
                "-fx-background-radius: 20px;" +                                        // Coins arrondis
                "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-border-color: #006400;" +                                          // Bordure verte
                "-fx-border-width: 3px;"  +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });

        gobackButton.setOnMouseExited(e -> {
            gobackButton.setStyle(
                 "-fx-background-color: #1e90ff;" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                "-fx-font-size: 16px;" +                                                // Taille du texte
                "-fx-padding: 10px 10px;" +                                             // Espacement interne
                "-fx-background-radius: 20px;" +                                        // Coins arrondis
                "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-border-color: #006400;" +                                          // Bordure verte
                "-fx-border-width: 3px;"  +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });

        // Layout: Centered elements
        VBox vbox = new VBox(15, label, nomField, validerButton, gobackButton); // 15px spacing
        label.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        
        vbox.setPadding(new Insets(20)); // Padding around the VBox
        VBox.setMargin(gobackButton, new Insets(80, 0, 0, 0)); // Extra margin for "Retour" button
        VBox.setMargin(validerButton, new Insets(30, 0, 30, 0)); // Extra margin for "Retour" button

        // Add all elements to the main container
        root.getChildren().addAll(background, vbox);

        // Create the scene
        scene = new Scene(root, 900, 600);
    }

    // Getters for scene and buttons
    public Scene getScene() {
        return scene;
    }

    public TextField getNomField() {
        return nomField;
    }

    public Button getValiderButton() {
        return validerButton;
    }

    public Button getBackButton() {
        return gobackButton;
    }

    // Close method
    public void close() {
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }
}
