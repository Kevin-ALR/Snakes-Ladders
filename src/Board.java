import java.util.ArrayList;

public class Board {
        final private ArrayList<Tile> tiles;
        final private int numberOfTiles;

        public Board(int numberOfTiles, int numberOfSnakes,int snakePenalty, int numberOfLadders, int ladderReward) {
            if (numberOfLadders < 0 || numberOfSnakes < 0)
                throw new IllegalArgumentException("The number of snake and leader tiles must be positive or zero");

            if (numberOfTiles <= 0)
                throw new IllegalArgumentException("The number of tiles must be positive");

            if(numberOfTiles < 5)
                throw new IllegalArgumentException("Board must have at least 5 tiles.");

            if(numberOfLadders + numberOfSnakes >= numberOfTiles - 2)
                throw new IllegalArgumentException("Too many snakes/ladders for the board size.");

            this.tiles = new ArrayList<>(numberOfTiles);
            this.numberOfTiles = numberOfTiles;

            for(int i = 0; i < numberOfTiles; i++) {
                tiles.add(new NormalTile('N'));
            }


            int s = 0, l = 0;
            while (s < numberOfSnakes) {
                int t = (int)(1 + Math.random() * (numberOfTiles - 2));
                if (tiles.get(t) instanceof NormalTile) {
                    tiles.set(t, new SnakeTile(-Math.abs(snakePenalty)));
                    s++;
                }
            }

            while (l < numberOfLadders) {
                int t = (int)(1 + Math.random() * (numberOfTiles - 2));
                if (tiles.get(t) instanceof NormalTile) {
                    tiles.set(t, new LadderTile(Math.abs(ladderReward)));
                    l++;
                }
            }
        }

        public void draw() {
            for (Tile tile: tiles) {
                System.out.print(tile.getSymbol() + " ");
            }
            System.out.println();
        }

        public Tile getTile(int tileNumber) {
            return tiles.get(tileNumber);
        }

        public int getNumberOfTiles() {
            return numberOfTiles;
        }

}
