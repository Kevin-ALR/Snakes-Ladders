public class NormalTile extends Tile{
    public NormalTile(int movement) {
        super('N');
    }

    @Override
    public int calculateEffect() {
        return 0;
    }
}
