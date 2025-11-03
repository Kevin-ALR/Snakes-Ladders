public enum TileType {
    NORMAL('N',0),
    SNAKE('S', -3),
    LADDER('L',3);

    private final char symbol;
    private final int movement;

    TileType(char c, int m){
        this.symbol = c;
        this.movement = m;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getMovement() {
        return movement;
    }
}