package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.elements.Ballon;
import view.GameView;
import model.elements.TirAuBut;
import model.structure.Jeu;

public class GameController {

    private Jeu jeu;
    private GameView gameView;
    private TirAuBut Tir;

    public GameController(GameView view, Jeu jeu) {
        this.jeu=jeu;
        this.gameView=view;
        // Créer la vue de jeu
        Ballon ballon= new Ballon(gameView.getBallonView());
        Tir=new TirAuBut(ballon,"");
        // Réinitialiser l'événement de clic de la souris dans la vue de jeu
        String Position=ShotPosition(Tir);  
    }
    
    public String ShotPosition(TirAuBut Tir){
        gameView.getPane().setOnMouseClicked(event -> {
            double BallonX = event.getX();
            double BallonY = event.getY();
            gameView.animateBallToPosition(BallonX, BallonY);// Déplacer le ballon vers la position cliquée
            gameView.setBallonXY(BallonX,BallonY);
             if (BallonX>=216.0 && BallonX<360.0){
            if (BallonY>=180){
                Tir.setPosition("BL");
            }
            else if (95<=BallonY && BallonY<180){
                Tir.setPosition("TL");
            }
            else
                Tir.setPosition("OUT");
        }
        else if (360<=BallonX && BallonX<503){
            if (95<=BallonY && BallonY<272){
                Tir.setPosition("M");
            }
            else
                Tir.setPosition("OUT");
        }
        else if (503<=BallonX && BallonX<650){
            if (BallonY>=180){
                Tir.setPosition("BR");
            }
            else if (95<=BallonY && BallonY<180){
                Tir.setPosition("TR");
            }
            else
                Tir.setPosition("OUT");
        }
        else
            Tir.setPosition("OUT");
        System.out.print(Tir.getPosition());
        });
        return Tir.getPosition();

       
    }
}
