public class LadderTile extends Tile{
    private final int reward;

    public LadderTile(int reward) {
        super('L');
        this.reward = reward;
    }

    @Override
    public int calculateEffect() {
        return reward;
    }
}
