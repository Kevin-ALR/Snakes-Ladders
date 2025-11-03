import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    final private List<Player> players = new ArrayList<>();
    final private Board board;
    final private Dice dice;
    private int currentTurnNumber;
    private boolean isGameOver;
    private int currentPlayerNumber;
    final private int maxNumberOfTurns;

    public Game() {
        this.board = new Board();
        this.dice = new Dice();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        players.add(p1);
        players.add(p2);
        this.currentTurnNumber = 1;
        this.isGameOver = false;
        this.currentPlayerNumber = 0;
        maxNumberOfTurns = 30;
    }

     public boolean isGameOver() {
        return isGameOver;
    }

    public void endGame() {
        this.isGameOver = true;
    }

    public int getMaxNumberOfTurns() {
        return maxNumberOfTurns;
    }

    public int getCurrentTurnNumber() {
        return currentTurnNumber;
    }

    public void playTurn() {
        if (currentTurnNumber >= maxNumberOfTurns) {
            System.out.println("The maximum number of turns has been reached...");
            endGame();
            return;
        }
        int currentTile = players.get(currentPlayerNumber).getCurrentTile();
        int diceRoll = dice.roll();
        int tentative = currentTile + diceRoll;

        if (tentative > board.getNumberOfTiles() - 1) tentative = board.getNumberOfTiles() - 1;

        TileType tileType = board.getTile(tentative);

        int finalPosition = tentative + tileType.getMovement();

        if (finalPosition < 0) {
            finalPosition = 0;
        }

        System.out.println(currentTurnNumber + " " + players.get(currentPlayerNumber).getPlayerNumber() + " " + (currentTile + 1) + " " + diceRoll + " " + tileType.getSymbol() + " " + (finalPosition + 1));

        if (finalPosition >= board.getNumberOfTiles() - 1) {
            System.out.println("Player " + players.get(currentPlayerNumber).getPlayerNumber() + " is the winner!!!");
            endGame();
            return;
        }

        players.get(currentPlayerNumber).setCurrentTile(finalPosition);

        if(currentPlayerNumber < players.size() - 1) {
            this.currentPlayerNumber++;
        } else {
            this.currentPlayerNumber = 0;
        }
        currentTurnNumber++;
    }
}
