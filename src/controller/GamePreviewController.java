/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javafx.stage.Stage;
import model.elements.Equipe;
import model.structure.Jeu;
import model.structure.Match;
import view.GamePreview;
import view.GameView;

/**
 *
 * @author lenovo
 */
public class GamePreviewController {
    private final Jeu jeu;
    private final GamePreview view;
    
    
    public GamePreviewController(GamePreview view, Jeu jeu){
        this.view=view;
        this.jeu=jeu;
        view.getNextButton().setOnAction(e-> redirectToGameView());
    }
    
    private void redirectToGameView(){
        view.getSong().pause();
        GameView GameView= new GameView(jeu);
        Stage stage = (Stage) view.getNextButton().getScene().getWindow();
        stage.setScene(GameView.getScene());
        new GameController(GameView, jeu);
               
        
    }
}
