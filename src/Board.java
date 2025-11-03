import java.util.ArrayList;

public class Board {
        final private ArrayList<Tile> tiles = new ArrayList<>();
        final private int numberOfTiles = 30;
        final private int numberOfSnakes = 3;
        final private int numberOfLadders = 3;

        public Board() {
            int s = 0, l = 0;
            for(int i = 0; i < numberOfTiles; i++) {
                tiles.add(new Tile(TileType.NORMAL));
            }

            while (s < numberOfSnakes) {
                int t = (int)(1 + Math.random() * (numberOfTiles - 1));
                if (tiles.get(t).getType() == TileType.NORMAL) {
                    tiles.set(t, new Tile(TileType.SNAKE));
                    s++;
                }
            }

            while (l < numberOfLadders) {
                int t = (int)(1 + Math.random() * (numberOfTiles - 1));
                if (tiles.get(t).getType() == TileType.NORMAL) {
                    tiles.set(t, new Tile(TileType.LADDER));
                    l++;
                }
            }
        }

        public void draw() {
            for (Tile tile: tiles) {
                System.out.print(tile.getType().getSymbol() + " ");
            }
        }

        public TileType getTile(int tileNumber) {
            return tiles.get(tileNumber).getType();
        }

        public int getNumberOfTiles() {
            return numberOfTiles;
        }

}
