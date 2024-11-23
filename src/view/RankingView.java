package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.elements.Equipe;
import model.structure.Jeu;

import java.util.List;

public class RankingView {

    private Scene scene;
    private Button NextButton;
    private Button gobackButton;
    private List<Equipe> equipes;

    public RankingView(Jeu jeu) {

        // Récupérer les équipes
        if (jeu.getCoupe() != null) {
            this.equipes = jeu.getCoupe().getEquipes();
        } else if (jeu.getChampionnat() != null) {
            this.equipes = jeu.getChampionnat().getEquipes();
        }

        // Fond d'écran
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));
        background.setFitWidth(900);
        background.setFitHeight(600);

        // Conteneur principal
        StackPane root = new StackPane();

        // Titre
        Label title = new Label("Classement du Championnat");
        title.setFont(Font.font("Sports World", FontWeight.BOLD, 30));
        title.setTextFill(Color.WHITE);

        // Tableau des équipes
        GridPane gridPane = new GridPane();
        gridPane.setHgap(15);
        gridPane.setVgap(10);
        
        gridPane.setPrefWidth(400);  // Largeur préférée de 500 px

        gridPane.setMaxWidth(400);   // Largeur maximale de 600 px

        gridPane.setMinWidth(400);   // Largeur minimale de 400 px
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: rgba(0, 50, 0, 0.85); " +
                "-fx-background-radius: 10; " +
                "-fx-padding: 10; " +
                "-fx-border-color: yellow; " +
                "-fx-border-radius: 10; -fx-border-width: 2;");

        // En-têtes de colonnes
        Label rankHeader = new Label("Position");
        Label teamHeader = new Label("Équipe");
        Label pointsHeader = new Label("Points");

        styleHeader(rankHeader);
        styleHeader(teamHeader);
        styleHeader(pointsHeader);

        gridPane.add(rankHeader, 0, 0);
        gridPane.add(teamHeader, 1, 0);
        gridPane.add(pointsHeader, 2, 0);

        // Remplir les données des équipes
        for (int i = 0; i < equipes.size(); i++) {
            Equipe equipe = equipes.get(i);

            Label rankLabel = new Label((i + 1) + ".");
            Label teamLabel = new Label(equipe.getNom());
            Label pointsLabel = new Label(String.valueOf(equipe.getPoints()));

            styleCell(rankLabel);
            styleCell(teamLabel);
            styleCell(pointsLabel);

            gridPane.add(rankLabel, 0, i + 1);
            gridPane.add(teamLabel, 1, i + 1);
            gridPane.add(pointsLabel, 2, i + 1);
            
            
        }

        // Barre de défilement
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(false);
        scrollPane.setStyle("-fx-background: transparent; -fx-padding: 0;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        scrollPane.setPrefWidth(400);  // Largeur préférée de 500 px

        scrollPane.setMaxWidth(400);   // Largeur maximale de 600 px

        scrollPane.setMinWidth(400);   // Largeur minimale de 400 px

        // Boutons
        NextButton = createStyledButton("Next", "#00FF00", "#32CD32");
        gobackButton = createStyledButton("Retour", "#1e90ff", "#4682b4");

        // Conteneur principal vertical
        VBox vbox = new VBox(20, title, scrollPane, NextButton, gobackButton);
        vbox.setAlignment(Pos.CENTER);

        // Ajouter les éléments au StackPane
        root.getChildren().addAll(background, vbox);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }

    private void styleHeader(Label label) {
        label.setStyle("-fx-font-weight: bold; -fx-font-family: 'Sports World';  -fx-text-fill: yellow; -fx-text-alignment: center; -fx-font-size: 18px;");
    }

    private void styleCell(Label label) {
        label.setStyle("-fx-text-fill: white; -fx-font-family: 'Sports World'; -fx-text-alignment: center; -fx-font-size: 14px;");
    }

    private Button createStyledButton(String text, String color, String hoverColor) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-family: 'Sports World';" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-width: 2px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"
        );
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: " + hoverColor + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-family: 'Sports World';" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-width: 2px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+
                        "-fx-scale-x: 1.1;" +  // Agrandissement du bouton au survol
                        "-fx-scale-y: 1.1;"    // Agrandissement du bouton au survol
                
        ));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-family: 'Sports World';" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-width: 2px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 8, 0.5, 0, 4);"+
                        "-fx-scale-x: 1;" +  // Agrandissement du bouton au survol
                         "-fx-scale-y: 1;"    // Agrandissement du bouton au survol
        ));
        return button;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getGobackButton() {
        return gobackButton;
    }
}
