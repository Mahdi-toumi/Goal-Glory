package view;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import model.elements.Equipe;
import model.structure.Match;

public class BracketView {

    private VBox leftSideBox;
    private VBox rightSideBox;
    private VBox quarterFinalsLeft;
    private VBox quarterFinalsRight;
    private VBox semiFinalsLeft;
    private VBox semiFinalsRight;
    private VBox finalMatchBox;
    private Button gobackButton ;
    private Button NextButton ;
    private List<Match> Matchs ;

    public BracketView(List<Match> Matchs) {
        
        
        this.Matchs = Matchs ;
        leftSideBox = new VBox(60);
        rightSideBox = new VBox(60);
        quarterFinalsLeft = new VBox(150);
        quarterFinalsRight = new VBox(150);
        semiFinalsLeft = new VBox(290);
        semiFinalsRight = new VBox(290);
        finalMatchBox = new VBox(290);

        
        // Filling in the brackets
        createFirstRound(Matchs);
        createQuarterFinals();
        createSemiFinals();
        createFinalMatch();
        
        gobackButton = new Button("Retour");
        gobackButton.setStyle(
            "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
            "-fx-font-size: 16px;" +                                                // Taille du texte
            "-fx-padding: 15px 15px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
            "-fx-border-color: #006400;" +                                          // Bordure verte
            "-fx-border-width: 2px;"                                               // Largeur de la bordure
        );
        
        gobackButton.setOnMouseEntered(e -> {
            gobackButton.setStyle(
                "-fx-background-color: #1e90ff;" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                "-fx-font-size: 16px;" +                                                // Taille du texte
                "-fx-padding: 15px 15px;" +                                             // Espacement interne
                "-fx-background-radius: 20px;" +                                        // Coins arrondis
                "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-border-color: #006400;" +                                          // Bordure verte
                "-fx-border-width: 2px;"  +
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
                "-fx-padding: 15px 15px;" +                                             // Espacement interne
                "-fx-background-radius: 20px;" +                                        // Coins arrondis
                "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                "-fx-border-color: #006400;" +                                          // Bordure verte
                "-fx-border-width: 2px;"  +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
            );
        });
       

        // Bouton de validation
        NextButton = new Button("Next");
        NextButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Dégradé vert (vert clair à vert foncé)
            "-fx-text-fill: white;" +                                               // Texte en blanc
            "-fx-font-family: 'Sports World';" +                                    // Police Sportive
            "-fx-font-size: 18px;" +                                                // Taille du texte
            "-fx-padding: 15px 15px;" +                                             // Espacement interne
            "-fx-background-radius: 20px;" +                                        // Coins arrondis
            "-fx-border-radius: 20px;" +                                            // Bordure arrondie
            "-fx-border-color: #006400;" +                                          // Bordure verte
            "-fx-border-width: 2px;" +                                              // Largeur de la bordure
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" 
        );

        // Appliquer l'effet hover sur le bouton de validation
        NextButton.setOnMouseEntered(e -> NextButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #32CD32, #006400);" +  // Dégradé vert (vert clair à vert foncé)
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 2px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
        ));
        NextButton.setOnMouseExited(e -> NextButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #00FF00, #008000);" +  // Retour au dégradé initial
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Sports World';" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15px 15px;" +
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #006400;" +
                "-fx-border-width: 2px;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);" +
                "-fx-scale-x: 1;" +  // Réduire la taille du bouton après le survol
                "-fx-scale-y: 1;"    // Réduire la taille du bouton après le survol
        ));
        
        
        
        
    }

    private void createFirstRound(List<Match> Matchs) {
        for (int i = 0; i < 8; i++ ) {
            String match  ;
            match = Matchs.get(i).affichageAbr() ;
            if (i<4) {
                Button matchs=new Button(match );
                matchs.setPrefWidth(200); // Adjust button width
                matchs.setMinWidth(100); // Adjust button width
                matchs.setWrapText(true); // Allow wrapping for long text
                matchs.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;" 
                );
                
                leftSideBox.getChildren().add(matchs);
                leftSideBox.setPadding(new Insets(60, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px

                
            } else {
                Button matchs=new Button(match);
                matchs.setPrefWidth(200); // Adjust button width
                matchs.setMinWidth(100); // Adjust button width
                matchs.setWrapText(true); // Allow wrapping for long text
                matchs.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"   
                );
                rightSideBox.getChildren().add(matchs);
                rightSideBox.setPadding(new Insets(60, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px

                
            }
        }
        
    }

    private void createQuarterFinals() {
        // Quarter-finals (Empty Boxes)
        Button match1=new Button("M1 vs M2");
        Button match2=new Button("M3 vs M4");
        Button match3=new Button("M5 vs M6");
        Button match4=new Button("M7 vs M8");
        
        match1.setPrefWidth(200); // Adjust button width
        match1.setWrapText(true); // Allow wrapping for long text
        match1.setMinWidth(100); // Adjust button width

        match2.setPrefWidth(200); // Adjust button width
        match2.setWrapText(true); // Allow wrapping for long text                
        match2.setMinWidth(100); // Adjust button width

        match3.setPrefWidth(200); // Adjust button width
        match3.setWrapText(true); // Allow wrapping for long text
        match3.setMinWidth(100); // Adjust button width

        match4.setPrefWidth(200); // Adjust button width
        match4.setWrapText(true); // Allow wrapping for long text
        match4.setMinWidth(100); // Adjust button width

        match1.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"   
                );
                match2.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"   
                );
                match3.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"   
                );
                match4.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"   
                );
        quarterFinalsLeft.getChildren().add(match1);
        quarterFinalsLeft.getChildren().add(match2);
        
        quarterFinalsRight.getChildren().add(match3);
        quarterFinalsRight.getChildren().add(match4);
        quarterFinalsRight.setPadding(new Insets(110, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px
        quarterFinalsLeft.setPadding(new Insets(110, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px


    }

    private void createSemiFinals() {
        Button match1=new Button("QF1 vs QF2");
        Button match2=new Button("QF3 vs QF4");
        match1.setPrefWidth(200); // Adjust button width
        match1.setWrapText(true); // Allow wrapping for long text
        match1.setMinWidth(100); // Adjust button width

        match2.setPrefWidth(200); // Adjust button width
        match2.setWrapText(true); // Allow wrapping for long text
        match2.setMinWidth(100); // Adjust button width

        match1.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"   
                );
                match2.setStyle( 
                    "-fx-background-color: linear-gradient(#32cd32, #228b22);" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: white;" +                                          // Bordure verte
                    "-fx-border-width: 2px;"    
                );
        // Semi-finals (Empty Boxes)
        semiFinalsLeft.getChildren().add(match1);
        semiFinalsRight.getChildren().add(match2);
        semiFinalsRight.setPadding(new Insets(200, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px
        semiFinalsLeft.setPadding(new Insets(200, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px


    }

    private void createFinalMatch() {
        // Final (Empty Box)
        Button match=new Button("Final");
        match.setPrefWidth(200); // Adjust button width
        match.setMinWidth(100); // Adjust button width
        match.setWrapText(true); // Allow wrapping for long text
        match.setStyle( 
                    "-fx-background-color: #A57C00;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 9px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #FFB300;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
        finalMatchBox.getChildren().add(match);
        finalMatchBox.setPadding(new Insets(200, 0, 0, 0)); // Top: 240px, Right: 0px, Bottom: 0px, Left: 0px

    }

    public Scene getBracketScene() {
        // Creating the layout for the whole bracket
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg"))); // Exemple d'image d'un terrain de foot
        background.setFitWidth(900);
        background.setFitHeight(600);

        StackPane layout = new StackPane();
        HBox fullBracket = new HBox(0);
        fullBracket.getChildren().addAll(leftSideBox, quarterFinalsLeft, semiFinalsLeft, finalMatchBox, semiFinalsRight, quarterFinalsRight, rightSideBox);

        HBox Buttons = new HBox(20);
        Buttons.getChildren().addAll(gobackButton, NextButton);
        Buttons.setAlignment(Pos.CENTER);
        

        VBox fullScene = new VBox(0);
        VBox.setMargin(Buttons,new Insets(20,0,0,0) ) ;
        VBox.setMargin(fullBracket,new Insets(0,0,0,0) ) ;
        fullScene.setAlignment(Pos.CENTER);



        fullScene.getChildren().addAll(fullBracket,  Buttons);

        layout.getChildren().addAll(background, fullScene);
        return new Scene(layout, 900, 600);
    }
    
    public Button getBackButton(){
        return this.gobackButton ;
    }
    
    public Button getNextButton(){
        return this.NextButton ;
    }
    
    public List<Equipe> getEquipes (){
        List<Equipe> equipes = new ArrayList<Equipe>() ;
        for (Match match : Matchs ){
            equipes.add(match.getEquipe1() ) ; 
            equipes.add(match.getEquipe2() ) ; 
        }
        return equipes ;
    }

}

