package controller;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import view.GameView;
import model.structure.Jeu;

import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.elements.Equipe;
import model.structure.Match;
import model.structure.Player;
import view.RankingView;

public class GameController {

    private GameView gameView;
    private Jeu jeu;
    private boolean isPlayerTurn = true; // Start with the player's turn
    private int playerScore = 0;
    private int aiScore = 0;
    private int maxRounds = 5; // Maximum penalty rounds per side
    private int currentRound = 1; // Current round
    private boolean suddenDeath = false; // Sudden death indicator


    public GameController(GameView gameView, Jeu jeu) {
        this.gameView = gameView;
        this.jeu = jeu;
        setupPlayerControls();
    }

    private void setupPlayerControls() {
        gameView.getPane().setOnMouseClicked(event -> {
            if (isPlayerTurn) {
                double clickX = event.getX();
                double clickY = event.getY();
                handlePlayerTurn(clickX, clickY);
            }
        });
    }

    private void handlePlayerTurn(double clickX, double clickY) {
        System.out.println("Your Turn to Shoot!");

        // Animate the ball to the target position
        gameView.animateBallToPosition(clickX, clickY);

        // AI Goalkeeper random position
        double[] aiGlovesPosition = randomGoalkeeperPosition();
        gameView.animateGlovesToPosition(aiGlovesPosition[0], aiGlovesPosition[1]);

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> {
            boolean isSaved = checkIfSaved(new double[]{clickX, clickY}, aiGlovesPosition);

            if (isSaved) {
                System.out.println("AI saved your shot!");
            } else {
                System.out.println("You scored!");
                this.jeu.getPlayer().setScore(this.jeu.getPlayer().getScore()+10);
                playerScore++;
                gameView.updateScoreBoard(playerScore, aiScore);
            }

            resetPositions();
            isPlayerTurn = false;
            handleAITurn();
        });
        pause.play();
    }

    private void handleAITurn() {
        System.out.println("AI's Turn!");

        resetPositions();

        double[] aiShotTarget = randomShotPosition();
        System.out.println("Move your gloves to save the shot!");

        Pane gamePane = gameView.getPane();
        gamePane.setOnMouseClicked(event -> {
            double playerGlovesX = event.getX();
            double playerGlovesY = event.getY();

            gameView.animateGlovesToPosition(playerGlovesX, playerGlovesY);
            gameView.animateBallToPosition(aiShotTarget[0], aiShotTarget[1]);

            PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
            pause.setOnFinished(e -> {
                boolean isSaved = checkIfSaved(aiShotTarget, new double[]{playerGlovesX, playerGlovesY});

                if (isSaved) {
                    System.out.println("You saved the shot!");
                    this.jeu.getPlayer().setScore(this.jeu.getPlayer().getScore()+15);
                } else {
                    System.out.println("AI scored!");
                    aiScore++;
                    gameView.updateScoreBoard(playerScore, aiScore);
                }

                resetPositions();

                if (checkGameOver()) {
                    displayGameOver();
                } else {
                    isPlayerTurn = true;
                    System.out.println("Next Round: Player's Turn!");
                    currentRound++;
                    setupPlayerControls();
                }
            });
            pause.play();
            gamePane.setOnMouseClicked(null); // Clear click handler for AI's turn
        });
    }

    private void resetPositions() {
        gameView.resetBallPosition();
        gameView.resetGlovesPosition();
    }
    

    
    
    //Hedi Te5demem jawha behi
    public boolean checkIfSaved(double[] ballTarget, double[] glovesTarget) { 
        // Iterate through all cage rectangles
        Rectangle rectangle1 = this.gameView.getCageRects()[0];
        Rectangle rectangle2 = this.gameView.getCageRects()[1];
        Rectangle rectangle3 = this.gameView.getCageRects()[2];
        Rectangle rectangle4 = this.gameView.getCageRects()[3];
        Rectangle rectangle5 = this.gameView.getCageRects()[4];
        boolean isBallInRectangle1 = rectangle1.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle2 = rectangle2.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle3 = rectangle3.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle4 = rectangle4.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle5 = rectangle5.contains(ballTarget[0], ballTarget[1]);
 
            // If the ball is not in any rectangle, return true
            if (!isBallInRectangle1 && !isBallInRectangle2 && !isBallInRectangle3 && !isBallInRectangle4 && !isBallInRectangle5 ) {
                return true;
            }
            
            else {
                for (int i = 0; i < 5; i++) {
                     Rectangle rectangle = this.gameView.getCageRects()[i]; // Get the current rectangle

                    // Check if both the ball and gloves are in the same rectangle
                    boolean isBallInRectangle = rectangle.contains(ballTarget[0], ballTarget[1]);
                    boolean isGlovesInRectangle = rectangle.contains(glovesTarget[0], glovesTarget[1]);

                    // If both are in the same rectangle, return true
                    if (isBallInRectangle && isGlovesInRectangle) {
                        return true;
                    }
                }
                // If no rectangles match, return false
                return false;
                
            }
    }

    
    

    private double[] randomGoalkeeperPosition() {
        Random random = new Random();
        int choice = random.nextInt(5);

        switch (choice) {
            case 0: return new double[]{220, 110}; // Top left
            case 1: return new double[]{220, 200}; // Bottom left
            case 2: return new double[]{540, 110}; // Top right
            case 3: return new double[]{540, 200}; // Bottom right
            default: return new double[]{410, 140}; // Middle
        }
    }

    private double[] randomShotPosition() {
        return randomGoalkeeperPosition();
    }

    
    
    private boolean checkGameOver() {
        // If we're in the normal rounds
        if (!suddenDeath) {
            // Check if the max rounds have been completed
            if (currentRound >= maxRounds) {
                // If scores are not tied, the game is over
                if (playerScore != aiScore) {
                    return true;
                }
                // Trigger sudden death if scores are tied
                suddenDeath = true;
            }
        } else {
            // In sudden death, the game ends as soon as one player scores and the other doesn't
            if (Math.abs(playerScore - aiScore) > 0) {
                return true;
            }
        }

        // Game continues
        return false;
    }


    private void displayGameOver() {
        if (this.jeu.getChampionnat()!= null){
        System.out.println("Game Over!");
        Text gameOverText = new Text();
        gameOverText.setFont(Font.font("Sports World", 30));
        gameOverText.setFill(Color.WHITE);
        gameOverText.setLayoutX(300); // Center the text horizontally
        gameOverText.setLayoutY(250); // Position it vertically

        if (playerScore > aiScore) {
            this.jeu.getChampionnat().AjoutPointsEquipe(3, this.jeu.getPlayer().getEquipe()); // bech yetzedoulek el poinet 
            System.out.println("You win! Final Score: " + playerScore + " - " + aiScore);
            gameOverText.setText("You Win!");
            gameOverText.setFont(Font.font("Sports World", 60));
            gameOverText.setStyle(
                "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
                "-fx-stroke: black;" +                                                   // Contour noir
                "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
            );

        } else {
            for( Match match : this.jeu.getChampionnat().getTours().get(this.jeu.getTour()).getMatchs() ){
                if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom() || match.getEquipe2().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                    this.jeu.getChampionnat().AjoutPointsEquipe(3, match.getEquipe2()); 
                }
                else {
                    this.jeu.getChampionnat().AjoutPointsEquipe(3, match.getEquipe1()); 
                }}
                    
            }
            System.out.println("You lose! Final Score: " + playerScore + " - " + aiScore);
            gameOverText.setText("You Lose!");
            gameOverText.setFont(Font.font("Sports World", 60));
            gameOverText.setStyle(
                "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #FF0000, #8B0000);" + // Dégradé rouge clair à rouge foncé
                "-fx-stroke: black;" +                                                   // Contour noir
                "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
            );
        }

        // Add the game over message to the pane
        gameView.getPane().getChildren().add(gameOverText);

        // Pause for 5 seconds before transitioning to the RankingView
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(e -> {
            // Remove the game over text
            gameView.getPane().getChildren().remove(gameOverText);
            
            
            
                
                if (this.jeu.getTour()<=16 ){
                
                 // Transition to RankingView (assuming you have a method to switch views)
                // this.jeu.getChampionnat().randomizeTour(this.jeu.getPlayer().getEquipe(),this.jeu.getTour())  ;
                for (Match match : this.jeu.getChampionnat().getTours().get(this.jeu.getTour()+1).getMatchs()) {
                     Equipe equipe1 = match.getEquipe1();
                     Equipe equipe2 = match.getEquipe2();

                     // Si l'équipe donnée ne participe pas au match, générer un résultat aléatoire
                     if (!equipe1.equals(this.jeu.getPlayer().getEquipe()) && !equipe2.equals(this.jeu.getPlayer().getEquipe())) {
                         Random rand = new Random();
                         // Générer un gagnant aléatoire
                         Equipe gagnant = rand.nextBoolean() ? equipe1 : equipe2;

                         // Ajouter des points à l'équipe gagnante
                         this.jeu.getChampionnat().AjoutPointsEquipe(3, gagnant);


                         // Afficher le résultat
                         System.out.println("Match entre " + equipe1.getNom() + " et " + equipe2.getNom() + " : " 
                                            + gagnant.getNom() + " gagne !");
                     }
                 }
                 this.jeu.setTour(this.jeu.getTour()+1) ;

                 transitionToRankingView();
                }
                

                 
            if (this.jeu.getCoupe()!= null){
                //lena barcketView
            }

           
        });
        pause.play(); }
        else {
                    // la3ba wfet hazit chompionnat wela le 
                }
    }

    private void transitionToRankingView() {
            // Create an instance of RankingView
            RankingView rankingView = new RankingView(jeu);  // Replace with actual ranking view creation

            // Get the current stage (existing window) from the game scene
            Stage currentStage = (Stage) gameView.getScene().getWindow();

            // Set the new scene for the existing stage
            currentStage.setScene(rankingView.getScene());

            // Optionally, create a new controller for the ranking view if needed
            new RankingController(rankingView, jeu);
        }

    
    
    
}
