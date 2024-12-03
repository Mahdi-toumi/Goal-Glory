/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.structure.Jeu;

/**
 *
 * @author lenovo
 */
public class ChampionsView {
    private Scene scene;
    private Button restartButton;
    private Button quitButton;
    private Text titleText;
    
    
    
    public ChampionsView(Jeu jeu){
        ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        backgroundImage.setFitWidth(900);
        backgroundImage.setFitHeight(600);
        ImageView Trophy= new ImageView();
        // Texte du titre
        if (jeu.getCoupe()!=null){
            
            if (jeu.getCoupe().getNom()=="World Cup"){
                titleText = new Text("\tCongratulations \n  You Won The " + jeu.getCoupe().getNom()+" !");
                titleText.setFont(Font.font("Sports World", 30));
                titleText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé rouge clair à rouge foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-alignement : center;"+
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
                 Trophy=new ImageView(new Image(getClass().getResourceAsStream("/images/WC Trophy.png"))); 
                 Trophy.setFitWidth(90);
                 Trophy.setFitHeight(120);
            }
            else{
                titleText = new Text("\t       Congratulations \n  You Won The " + jeu.getCoupe().getNom()+" !");
                titleText.setFont(Font.font("Sports World", 30));
                titleText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé rouge clair à rouge foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-alignement : center;"+
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
                 Trophy=new ImageView(new Image(getClass().getResourceAsStream("/images/CL Trophy.png")));  
                 Trophy.setFitWidth(90);
                 Trophy.setFitHeight(120);
            }
        }
        else if (jeu.getChampionnat()!=null){
            
            if (jeu.getChampionnat().getNom()=="La Liga"){
                titleText = new Text("     Congratulations \n You Won The " + jeu.getChampionnat().getNom()+" !");
                titleText.setFont(Font.font("Sports World", 30));
                titleText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé rouge clair à rouge foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-alignement : center;"+
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"  // Ombre portée pour le texte
                );
                 Trophy=new ImageView(new Image(getClass().getResourceAsStream("/images/LaLiga Trophy.png")));
                 Trophy.setFitWidth(140);
                 Trophy.setFitHeight(120);
            }
            else{
                titleText = new Text("           Congratulations \n You Won The " + jeu.getChampionnat().getNom()+" !");
                titleText.setFont(Font.font("Sports World", 30));
                titleText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé rouge clair à rouge foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-alignement : center;"+
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"  // Ombre portée pour le texte
                );
                 Trophy=new ImageView(new Image(getClass().getResourceAsStream("/images/PL Trophy.png")));    
                 Trophy.setFitWidth(160);
                 Trophy.setFitHeight(140);
            }
        }
        
        
        // Initialiser les boutons "Start" et "Quit"
        restartButton = new Button("Restart");
        quitButton = new Button("Quit");
        restartButton.setFont(Font.font("Sports World", 20)); // Police Verdana, taille 20
        quitButton.setFont(Font.font("Sports World", 20)); // Même style pour les deux boutons
        // Pour le bouton "Start"
        restartButton.setStyle(
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
        restartButton.setOnMouseEntered(e -> {
            restartButton.setStyle(
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

        restartButton.setOnMouseExited(e -> {
            restartButton.setStyle(
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


        // Ajouter les éléments au layout
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll( backgroundImage, titleText, Trophy,restartButton, quitButton);

        // Positionnement
        StackPane.setAlignment(titleText, Pos.TOP_CENTER);
        StackPane.setMargin(titleText, new javafx.geometry.Insets(100, 0, 0, 0));
        StackPane.setMargin(restartButton, new javafx.geometry.Insets(350, 0, 100, 0));
        StackPane.setAlignment(quitButton, Pos.CENTER);
        StackPane.setMargin(quitButton, new javafx.geometry.Insets(450, 0, 0, 0));

        // Créer la scène
        scene = new Scene(layout, 900, 600);

    }
    
    public Button getRestartButton(){
        return restartButton;
    }
    public Button getQuitButton(){
        return quitButton;
    }
    public Scene getScene(){
        return scene;
    }
    public Text getText(){
        return titleText;
    }
    public void setText(Text txt){
        this.titleText=txt;
    }
}
