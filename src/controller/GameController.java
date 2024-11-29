package controller;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import view.GameView;

import java.util.Random;
import javafx.scene.layout.Pane;
import model.structure.Jeu;

public class GameController {

    private GameView gameView;
    private Jeu jeu;
    private boolean isPlayerTurn = true; // Start with the player's turn
    private int playerScore = 0;
    private int aiScore = 0;
    private int maxRounds = 5; // Maximum rounds for the game
    private int currentRound = 1; // Track the current round

    public GameController(GameView gameView, Jeu jeu) {
        this.gameView = gameView;
        this.jeu = jeu;
        setupPlayerControls();
    }

    private void setupPlayerControls() {      //ki ticklicki, y9ayed click mteek
        gameView.getPane().setOnMouseClicked(event -> {
            if (isPlayerTurn) {
                double clickX = event.getX();
                double clickY = event.getY();
                handlePlayerTurn(clickX, clickY);
            }
        });
    }

    private void handlePlayerTurn(double clickX, double clickY) { //animation, random ai, 
        System.out.println("Your Turn to Shoot!");

        // Animate the ball to the target position
        gameView.animateBallToPosition(clickX, clickY);

        // Check if the AI goalkeeper saves the shot
        double[] aiGlovesPosition = randomGoalkeeperPosition();
        gameView.animateGlovesToPosition(aiGlovesPosition[0], aiGlovesPosition[1]);

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> {
            boolean isSaved = checkIfSaved(new double[]{clickX, clickY}, aiGlovesPosition);

            if (isSaved) {
                System.out.println("AI saved your shot!");
            } else {
                System.out.println("You scored!");
                playerScore++;
                gameView.updateScoreBoard(playerScore, aiScore);

            }

            resetPositions();

           
            isPlayerTurn = false; // Switch turn to AI
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
                } else {
                    System.out.println("AI scored!");
                    aiScore++;
                    gameView.updateScoreBoard(playerScore, aiScore);

                }

                resetPositions();

                // Check if the game should end or switch back to player's turn
                if (checkGameOver()) {
                    displayGameOver();
                } else {
                    isPlayerTurn = true;
                    setupPlayerControls();// Switch turn to player
                    System.out.println("Next Round: Player's Turn!");
                    currentRound++; // Increment round count
                }
            });
            pause.play();
            gamePane.setOnMouseClicked(null); // Clear click handler for the AI's turn
        });
    }

    private void resetPositions() {
        gameView.resetBallPosition();
        gameView.resetGlovesPosition();
    }

    private boolean checkIfSaved(double[] ballTarget, double[] glovesTarget) {
        // Simple collision detection: Check if the ball and gloves are in the same area
        double tolerance = 50; // Adjust as needed
        return Math.abs(ballTarget[0] - glovesTarget[0]) < tolerance &&
               Math.abs(ballTarget[1] - glovesTarget[1]) < tolerance;
    }

    private double[] randomGoalkeeperPosition() {
        // Randomly choose one of the five goal positions
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
        return randomGoalkeeperPosition(); // AI uses the same logic for shots
    }

    private boolean checkGameOver() {
        // Game ends after the maximum number of rounds
        if (currentRound >= maxRounds) {
            if (aiScore==playerScore)
                maxRounds++;
            else
                return true;
        }
        return false;
        // Game can also end if either player reaches a winning score
        /*int winningScore = maxRounds / 2 + 1; // Majority wins
        return playerScore >= winningScore || aiScore >= winningScore;*/
    }

    private void displayGameOver() {
        // Display the result of the game
        System.out.println("Game Over!");
        if (playerScore > aiScore) {
            System.out.println("You win! Final Score: " + playerScore + " - " + aiScore);
        } else if (playerScore < aiScore) {
            System.out.println("You lose! Final Score: " + playerScore + " - " + aiScore);
        }

        // Optionally, reset the game or stop interactions
        resetPositions();
        gameView.getPane().setOnMouseClicked(null); // Disable further clicks
    }
}
