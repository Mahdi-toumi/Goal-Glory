/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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

public class ChoisirEquipeView {

    private Scene scene;
    private HBox equipesContainer; // Conteneur pour afficher les équipes
    private Button validerButton;

    public ChoisirEquipeView(List<Equipe> equipes) {
        // Conteneur principal
        StackPane root = new StackPane();

        // Ajouter un fond (thème football)
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/Background.jpeg")));  // Exemple d'image d'un terrain de foot
        background.setFitWidth(900);
        background.setFitHeight(600);

        // Titre
        Label label = new Label("Choisissez une équipe :");
        label.setStyle(
            "-fx-font-size: 28px;" +
            "-fx-font-family: 'Arial Black';" + 
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;" +
            "-fx-background-color: rgba(0, 0, 0, 0.5);" + // Ombre légère pour un meilleur contraste
            "-fx-padding: 10px 20px;" +
            "-fx-border-radius: 10px;"
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
                vboxEquipe.getChildren().add(equipeButton);
            }

            // Ajouter le VBox au HBox
            equipesContainer.getChildren().add(vboxEquipe);
        }

        // Bouton de validation
        validerButton = new Button("Valider");
        validerButton.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-family: 'Arial Black';" +
            "-fx-background-color: #27ae60;" +  // Couleur verte du football
            "-fx-text-fill: white;" +
            "-fx-padding: 15px 30px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.4), 8, 0.5, 0, 0);"  // Effet d'ombre pour un bouton dynamique
        );

        // Appliquer l'effet hover sur le bouton de validation
        validerButton.setOnMouseEntered(e -> validerButton.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-family: 'Arial Black';" +
            "-fx-background-color: #2ecc71;" +  // Couleur plus claire au survol
            "-fx-text-fill: white;" +
            "-fx-padding: 15px 30px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 8, 0.5, 0, 0);"  // Ombre plus marquée au survol
        ));
        validerButton.setOnMouseExited(e -> validerButton.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-family: 'Arial Black';" +
            "-fx-background-color: #27ae60;" +  // Retour à la couleur initiale
            "-fx-text-fill: white;" +
            "-fx-padding: 15px 30px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.4), 8, 0.5, 0, 0);"  // Retour à l'ombre initiale
        ));

        // Conteneur principal vertical
        VBox mainContainer = new VBox(20, label, equipesContainer, validerButton);
        mainContainer.setAlignment(Pos.CENTER);

        root.getChildren().addAll(background, mainContainer);

        // Créer la scène
        scene = new Scene(root, 900, 600);
    }

    /**
     * Appliquer un style spécifique aux boutons d'équipe.
     */
    private void styleEquipeButton(Button button) {
        button.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-family: 'Arial';" +
            "-fx-background-color: #3498db;" + // Bleu pour les boutons
            "-fx-text-fill: white;" +
            "-fx-padding: 10px 20px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.3), 6, 0.5, 0, 0);" // Ombre légère pour chaque bouton
        );
        button.setMinWidth(150);

        // Appliquer l'effet hover sur chaque bouton d'équipe
        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-family: 'Arial';" +
            "-fx-background-color: #2980b9;" +  // Changer la couleur au survol
            "-fx-text-fill: white;" +
            "-fx-padding: 10px 20px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5), 6, 0.5, 0, 0);" // Ombre plus marquée au survol
        ));
        button.setOnMouseExited(e -> button.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-family: 'Arial';" +
            "-fx-background-color: #3498db;" +  // Retour à la couleur initiale
            "-fx-text-fill: white;" +
            "-fx-padding: 10px 20px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.3), 6, 0.5, 0, 0);" // Retour à l'ombre initiale
        ));
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
}


