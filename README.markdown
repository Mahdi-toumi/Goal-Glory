# Goal Glory: Penalty Shootout Simulator

## About
Goal Glory is an immersive Java-based penalty shootout simulator developed as a university project by Youssef Srasra and Mahdi Toumi at the National Engineering School of Carthage. The application combines strategic decision-making with an engaging user experience, allowing players to participate in tournament-style penalty shootouts. Players can alternate between the roles of shooter and goalkeeper, selecting from five target zones (top-left, top-right, bottom-left, bottom-right, center) to score or save goals. The game supports two tournament modes: **Cup** (direct elimination) and **Championship** (point-based ranking). Built using Java for core logic and JavaFX for the graphical interface, Goal Glory follows the MVC architecture to ensure modularity and maintainability. The project includes animations, multimedia elements, and a robust class structure to deliver a seamless and competitive gaming experience.

## Features
- **Tournament Modes**: Choose between Cup (elimination) or Championship (points-based) formats.
- **Team Selection**: Pick from 16 teams, each with a roster of players for penalty shootouts.
- **Gameplay Mechanics**: As a shooter, select a target zone; as a goalkeeper, predict the shot's trajectory.
- **Scoring System**: Earn points for successful shots and saves, with real-time score tracking.
- **User Interface**: Intuitive JavaFX interface with animations, audio, and smooth transitions.
- **Modular Design**: Organized using MVC architecture for scalability and maintainability.

## Installation
1. **Prerequisites**:
   - Java Development Kit (JDK) 17 or higher
   - JavaFX SDK 17
   - NetBeans 15 (recommended IDE)
2. **Setup**:
   - Clone the repository: `git clone https://github.com/yourusername/goal-glory.git`
   - Configure JavaFX in your IDE (refer to [JavaFX documentation](https://openjfx.io/)).
   - Import the project into NetBeans or your preferred IDE.
3. **Run**:
   - Build and run the `Main.java` file to launch the application.

## Project Structure
- **Model**: Contains game logic and data classes (`Ballon`, `Equipe`, `Joueur`, `TirAuBut`, `Tournoi`, etc.).
- **View**: JavaFX-based UI components (`WelcomeView.java`, `GameView.java`, etc.).
- **Controller**: Handles user interactions and updates (`GameController.java`, `WelcomeController.java`, etc.).
- **Exceptions**: Custom exceptions for error handling (`EquipePleineException`, `PointsInvalideException`, etc.).

## Usage
1. Launch the application to access the welcome screen.
2. Enter your name and select a tournament type (Cup or Championship).
3. Choose a team from the available 16 teams.
4. Navigate through the tournament, alternating between shooting and goalkeeping.
5. View match results, team rankings, and progress through the tournament stages.

## Limitations
- Shot and save outcomes are based on random logic, not advanced AI.
- No support for full-match gameplay; focused solely on penalty shootouts.
- Limited to single-player mode; no multiplayer functionality.

## Future Improvements
- Implement predictive AI for goalkeepers and shooters using machine learning.
- Add multiplayer support for local two-player matches.
- Enhance the UI with modern visuals and responsive design for all screen sizes.
- Introduce additional gameplay mechanics, such as shot power or player fatigue.

## Contributors
- **Youssef Srasra**
- **Mahdi Toumi**

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgments
Developed as part of the Java Project course at the National Engineering School of Carthage, University of Carthage, for the academic year 2024-2025.