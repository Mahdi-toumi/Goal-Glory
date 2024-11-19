/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.structure.Player;
import view.SaisirPlayerView;

public class SaisirPlayerController {

    private SaisirPlayerView view;
    private Player player;

    public SaisirPlayerController(SaisirPlayerView view) {
        this.view = view;

        // Gérer l'événement de clic sur le bouton "Valider"
        view.getValiderButton().setOnAction(e -> {
            String nom = view.getNomField().getText();

            if (!nom.isEmpty()) {
                player = new Player(nom, 0); // Créer le joueur avec un score initial de 0
                view.close();
            } else {
                System.out.println("Veuillez saisir un nom.");
            }
        });
    }

    public Player getPlayer() {
        return player;
    }
}


