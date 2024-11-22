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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.elements.Equipe;

public class BracketView {

    private VBox leftSideBox;
    private VBox rightSideBox;
    private VBox quarterFinalsLeft;
    private VBox quarterFinalsRight;
    private VBox semiFinalsLeft;
    private VBox semiFinalsRight;
    private VBox finalMatchBox;

    public BracketView(List<Equipe> teams) {
        // Creating the structure
        
        
        leftSideBox = new VBox(60);
        rightSideBox = new VBox(60);
        quarterFinalsLeft = new VBox(150);
        quarterFinalsRight = new VBox(150);
        semiFinalsLeft = new VBox(290);
        semiFinalsRight = new VBox(290);
        finalMatchBox = new VBox(290);
        
        // Filling in the brackets
        createFirstRound(teams);
        createQuarterFinals();
        createSemiFinals();
        createFinalMatch();
    }

    private void createFirstRound(List<Equipe> teams) {
        // First Round - Last 16 matches
        Collections.shuffle(teams);
        for (int i = 0; i < 15; i++ ) {
            String match = teams.get(i).getAbr() + " vs " + teams.get(i + 1).getAbr();
            if (i<8) {
                Button matchs=new Button(match);
                matchs.setPrefWidth(200); // Adjust button width
                matchs.setMinWidth(100); // Adjust button width
                matchs.setWrapText(true); // Allow wrapping for long text
                matchs.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;" 
                );
                
                leftSideBox.getChildren().add(matchs);
                leftSideBox.setPadding(new Insets(100, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px

                i++;
            } else {
                Button matchs=new Button(match);
                matchs.setPrefWidth(200); // Adjust button width
                matchs.setMinWidth(100); // Adjust button width
                matchs.setWrapText(true); // Allow wrapping for long text
                matchs.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
                rightSideBox.getChildren().add(matchs);
                rightSideBox.setPadding(new Insets(100, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px

                i++;
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
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
                match2.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
                match3.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
                match4.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
        quarterFinalsLeft.getChildren().add(match1);
        quarterFinalsLeft.getChildren().add(match2);
        
        quarterFinalsRight.getChildren().add(match3);
        quarterFinalsRight.getChildren().add(match4);
        quarterFinalsRight.setPadding(new Insets(150, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px
        quarterFinalsLeft.setPadding(new Insets(150, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px


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
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
                match2.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
        // Semi-finals (Empty Boxes)
        semiFinalsLeft.getChildren().add(match1);
        semiFinalsRight.getChildren().add(match2);
        semiFinalsRight.setPadding(new Insets(240, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px
        semiFinalsLeft.setPadding(new Insets(240, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px


    }

    private void createFinalMatch() {
        // Final (Empty Box)
        Button match=new Button("SF1 vs SF2");
        match.setPrefWidth(200); // Adjust button width
        match.setMinWidth(100); // Adjust button width
        match.setWrapText(true); // Allow wrapping for long text
        match.setStyle( 
                    "-fx-background-color: #1e90ff;" +                                      // Dégradé vert (vert clair à vert foncé)
                    "-fx-font-family: 'Sports World';" +                                    // Police Sportive
                    "-fx-text-fill: white;" +                                               // Texte en blanc                                   // Police Sportive
                    "-fx-font-size: 10px;" +                                                // Taille du texte
                    "-fx-padding: 10px 10px;" +                                             // Espacement interne
                    "-fx-background-radius: 20px;" +                                        // Coins arrondis
                    "-fx-border-radius: 20px;" +                                            // Bordure arrondie                                           // Largeur de la bordure
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+   // Ombre portée
                    "-fx-border-color: #006400;" +                                          // Bordure verte
                    "-fx-border-width: 3px;"   
                );
        finalMatchBox.getChildren().add(match);
        finalMatchBox.setPadding(new Insets(240, 0, 0, 0)); // Top: 20px, Right: 0px, Bottom: 0px, Left: 0px

    }

    public Scene getBracketScene() {
        // Creating the layout for the whole bracket
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));  // Exemple d'image d'un terrain de foot
        background.setFitWidth(900);
        background.setFitHeight(600);
        StackPane layout = new StackPane();
        HBox fullBracket = new HBox(0);
        fullBracket.getChildren().addAll(leftSideBox, quarterFinalsLeft, semiFinalsLeft, finalMatchBox, semiFinalsRight, quarterFinalsRight, rightSideBox);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(background, fullBracket);
        return new Scene(layout, 800, 600);
    }
    
    // Example for setting up the window and showing the bracket
    public static void showBracket(List<Equipe> teams) {
        Stage stage = new Stage();
        BracketView bracketView = new BracketView(teams);
        stage.setTitle("Tournament Bracket");
        stage.setScene(bracketView.getBracketScene());
        stage.show();
    }
}
