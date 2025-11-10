public abstract class Tile {

    protected final char symbol;

    Tile(char c){
        this.symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract int calculateEffect();
}