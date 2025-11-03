public class Player {
    final private int playerNumber;
    private int currentTile;

    public Player(int playerNumber) {
        if(playerNumber <= 0) {
            throw new IllegalArgumentException("The player number cannot be negative");
        }
        this.playerNumber = playerNumber;
        this.currentTile = 1;
    }

    public int getCurrentTile() {
        return currentTile;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setCurrentTile(int currentTile) {
        if(currentTile < 0) {
            throw new IllegalArgumentException("Error, the current tile cannot be negative");
        }
        this.currentTile = currentTile;
    }
}
