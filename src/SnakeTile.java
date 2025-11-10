public class SnakeTile extends Tile{
    public final int penalty;

    public SnakeTile(int penalty) {
        super('S');
        this.penalty = penalty;
    }

    @Override
    public int calculateEffect() {
        return penalty;
    }
}
