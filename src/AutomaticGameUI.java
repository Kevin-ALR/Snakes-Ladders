public class AutomaticGameUI implements GameMode {
    private final Game game;

    public AutomaticGameUI(Game game){
        this.game = game;
    }

    @Override
    public void startGame(){
        while (!game.isGameOver()){
            game.playTurn();
        }
        System.out.println("-- GAME OVER --");
    }
}
