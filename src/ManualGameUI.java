import java.util.Scanner;

public class ManualGameUI implements GameMode{
    final private Game game;

    public ManualGameUI(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        String option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press C to continue next turn, or E to end the game:");
        while (!game.isGameOver()){
            option = sc.nextLine();
            switch (option.trim().toLowerCase()) {
                case "c":
                    game.playTurn();
                    break;
                case "e":
                    System.out.println("Thanks for playing!!!");
                    game.endGame();
                    break;
                default:
                    System.out.println("Invalid option, please press C to continue next turn or E to end the game");
            }
        }
        System.out.println("-- GAME OVER --");
        sc.close();
    }

    public Game getGame() {
        return game;
    }
}
