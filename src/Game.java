import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    final private List<Player> players = new ArrayList<>();
    final private Board board;
    final private Dice dice = new Dice();
    private int currentTurnNumber = 1;
    private boolean isGameOver = false;
    private int currentPlayerNumber = 0;
    final private int maxNumberOfTurns;


    public Game(int tiles, int snakes, int ladders, int penalty, int reward,int playersCount, int turns) {
        if(turns <= 0)
            throw new IllegalArgumentException("The number of turns must be positive!");

        if(playersCount <= 0)
            throw new IllegalArgumentException("There must be at least one player.");

        this.maxNumberOfTurns = turns;
        this.board = new Board(tiles,snakes,penalty,ladders,reward);

        for (int i = 1; i <= playersCount; i++) {
            players.add(new Player(i));
        }
    }

    public boolean isGameOver() { return isGameOver; }

    public void endGame() {
        this.isGameOver = true;
    }

    public Board board() {
        return board;
    }

    public void playTurn() {
        if (currentTurnNumber >= maxNumberOfTurns) {
            System.out.println("The maximum number of turns has been reached...");
            endGame();
            return;
        }

        Player p = players.get(currentPlayerNumber);
        int currentTile = players.get(currentPlayerNumber).getCurrentTile();
        int diceRoll = dice.roll();
        int nextPos = Math.min(p.getCurrentTile() + diceRoll, board.getNumberOfTiles() - 1);
        Tile tile = board.getTile(nextPos);
        int finalPos = Math.max(0, nextPos + tile.calculateEffect());

        System.out.printf("Turn: %d | Player: %d | Actual: %d | Roll: %d | Type: %s | Landed: %d |\n",
                currentTurnNumber, p.getPlayerNumber(), currentTile + 1, diceRoll, tile.getSymbol(), finalPos + 1);

        p.setCurrentTile(finalPos);

        if (finalPos >= board.getNumberOfTiles() - 1) {
            System.out.println("Player " + p.getPlayerNumber() + " is the winner!!!");
            endGame();
            return;
        }



        currentPlayerNumber = (currentPlayerNumber + 1) % players.size();
        currentTurnNumber++;
    }
}
