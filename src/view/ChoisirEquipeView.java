/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.elements.Equipe;

import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.structure.Jeu;

public class ChoisirEquipeView {

    private Scene scene;
    private HBox equipesContainer; // Conteneur pour afficher les équipes
    private Button validerButton;
    private Button gobackButton;
    private Button EquipeButton ;
    private Button selectedButton = null; // Bouton actuellement sélectionné
    private  List <Equipe> equipes  ;


    public ChoisirEquipeView(Jeu jeu) {
        // Conteneur principal
         
        if (jeu.getCoupe()!= null ){
        this.equipes = jeu.getCoupe().getEquipes() ;}
        else if (jeu.getChampionnat()!= null ){
        this.equipes = jeu.getChampionnat().getEquipes() ;}
        
        
        
        
        StackPane root = new StackPane();

        
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));  // Exemple d'image d'un terrain de foot
        background.setFitWidth(900);
        background.setFitHeight(600);
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
        
        EquipeButton = new Button(" ? ");
        EquipeButton.setVisible(false);
        EquipeButton.setStyle(
            "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
            "-fx-font-size: 16px;" +                                                // Taille du texte
            "-fx-padding: 10px 10px;" +                                             // Espacement interne
            "-fx-background-radius: 25px;" +                                        // Coins arrondis
            "-fx-border-radius: 25px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
            "-fx-border-color: #1e90ff;" +                                          // Bordure verte
            "-fx-border-width: 3px;"                                               // Largeur de la bordure
        );
        
        EquipeButton.setOnMouseEntered(e -> {
            EquipeButton.setStyle(
                "-fx-background-color: #1e90ff;" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                "-fx-font-size: 16px;" +                                                // Taille du texte
                "-fx-padding: 10px 10px;" +                                             // Espacement interne
                "-fx-background-radius: 25px;" +                                        // Coins arrondis
                "-fx-border-radius: 25px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-border-color: #1e90ff;" +                                          // Bordure verte
                "-fx-border-width: 3px;"  +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            );
        });

        EquipeButton.setOnMouseExited(e -> {
            EquipeButton.setStyle(
                 "-fx-background-color: #1e90ff;" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                "-fx-font-size: 16px;" +                                                // Taille du texte
                "-fx-padding: 10px 10px;" +                                             // Espacement interne
                "-fx-background-radius: 25px;" +                                        // Coins arrondis
                "-fx-border-radius: 25px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-border-color: #1e90ff;" +                                          // Bordure verte
                "-fx-border-width: 3px;"  +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });
        // Titre
        Label label = new Label("Choisissez une équipe :");
        label.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-family: 'Sports World';" +
            "-fx-pref-width: 800px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;" + // White color for contrast
            "-fx-effect: dropshadow(gaussian, black, 4, 0.5, 1, 1);" +// Shadow for better visibility
            "-fx-alignment: center;" +  
            "-fx-text-alignment: center;"  
        );

        // Conteneur pour afficher les équipes
        equipesContainer = new HBox(20);  // Espacement de 20px entre chaque VBox
        equipesContainer.setAlignment(Pos.CENTER);
        equipesContainer.setPadding(new Insets(20));

        // Ajouter des équipes par groupes de 4 dans des VBox
        for (int i = 0; i < equipes.size(); i += 4) {
            // Créer un VBox pour chaque groupe de 4 équipes
            VBox vboxEquipe = new VBox(10);  // Espacement de 10px entre les boutons d'équipes
            vboxEquipe.setAlignment(Pos.CENTER);
            vboxEquipe.setPadding(new Insets(10));

            // Ajouter jusqu'à 4 équipes dans chaque VBox
            for (int j = 0; j < 4 && (i + j) < equipes.size(); j++) {
                Equipe equipe = equipes.get(i + j);
                Button equipeButton = new Button(equipe.getNom());
                styleEquipeButton(equipeButton); // Appliquer le style personnalisé
                /*equipeButton.setOnAction(e -> {
                    selectButton(equipeButton);          
                });*/
                
                 // Add a click listener to handle selection
                vboxEquipe.getChildren().add(equipeButton);
            }

            // Ajouter le VBox au HBox
            equipesContainer.getChildren().add(vboxEquipe);
        }

        // Bouton de validation
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
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" 
        );

        // Appliquer l'effet hover sur le bouton de validation
        validerButton.setOnMouseEntered(e -> validerButton.setStyle(
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
        ));
        validerButton.setOnMouseExited(e -> validerButton.setStyle(
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
        ));
        HBox header = new HBox ( label , gobackButton );
        // Conteneur principal vertical
        VBox mainContainer = new VBox(20, header,equipesContainer, validerButton,EquipeButton );
        mainContainer.setAlignment(Pos.CENTER);

        root.getChildren().addAll(background, mainContainer);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }

    /**
     * Appliquer un style spécifique aux boutons d'équipe.
     */
    private void styleEquipeButton(Button button) {
        
        if (button!=selectedButton){
            button.setStyle(
                "-fx-background-color: #3498db;" +  // Dégradé vert (vert clair à vert foncé)
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
            button.setMinWidth(150);

            // Appliquer l'effet hover sur chaque bouton d'équipe
            button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #3498db;" +  // Dégradé vert (vert clair à vert foncé)
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
            ));
            button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: #3498db;" +  // Retour au dégradé initial
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
            ));
        }
        else{
            button.setStyle(
                "-fx-background-color: yellow;" +  // Highlight with yellow
                "-fx-text-fill: black;" +          // Black text for contrast
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #FFD700;" +     // Yellow border
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"
            );
            button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: yellow;" +  // Highlight with yellow
                "-fx-text-fill: black;" +          // Black text for contrast
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #FFD700;" +     // Yellow border
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
            ));
            button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: yellow;" +  // Highlight with yellow
                "-fx-text-fill: black;" +          // Black text for contrast
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #FFD700;" +     // Yellow border
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            ));
        }
    }
    public void selectButton(Button button ){
        if (selectedButton != null) {
                        // Reset the previously selected button's style
                        selectedButton.setStyle(
                             "-fx-background-color: #3498db;" +  // Reset to default blue
                            "-fx-text-fill: white;" +
                            "-fx-font-family: 'Sports World';" +
                            "-fx-font-size: 18px;" +
                            "-fx-padding: 15px 15px;" +
                            "-fx-background-radius: 20px;" +
                            "-fx-border-radius: 20px;" +
                            "-fx-border-color: #006400;" +
                            "-fx-border-width: 3px;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"
                        );
                        selectedButton.setOnMouseEntered(e -> selectedButton.setStyle(
                            "-fx-background-color: #3498db;" +  // Dégradé vert (vert clair à vert foncé)
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
                        ));
                        selectedButton.setOnMouseExited(e -> selectedButton.setStyle(
                            "-fx-background-color: #3498db;" +  // Retour au dégradé initial
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
                        ));
                    }
                    selectedButton=null;
                    // Set the new selected button and change its style
                    selectedButton = button;
                    styleEquipeButton(button);  
    }

    // Getters pour la scène et les éléments
    public Scene getScene() {
        return scene;
    }

    public HBox getEquipesContainer() {
        return equipesContainer;
    }

    public Button getValiderButton() {
        return validerButton;
    }
    
    public Button getBackButton() {
        return gobackButton;
    }
    public Button getEquipeButton() {
        return EquipeButton;
    }
    
    
}


