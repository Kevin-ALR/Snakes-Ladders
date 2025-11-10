import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Snakes and Ladders ===");

        System.out.print("Enter the tiles number on the board: ");
        int numberOfTiles = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the number of snakes on the board: ");
        int numberOfSnakes = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the number of ladders on the board: ");
        int numberOfLadders = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the penalty for the snake: ");
        int snakePenalty = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the reward for the ladder: ");
        int ladderReward = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the number of players: ");
        int numberOfPlayers = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the maximum number of turns: ");
        int maxNumberOfTurns = Integer.parseInt(sc.nextLine());
        System.out.print("\nSelect the game type: (A: Automatic, M: Manual): ");
        String gameType = sc.nextLine().trim().toLowerCase();

        Game g = new Game(numberOfTiles, numberOfSnakes, numberOfLadders, snakePenalty, ladderReward, numberOfPlayers, maxNumberOfTurns);

        GameMode mode = switch (gameType) {
            case "a" -> new AutomaticGameUI(g);
            case "m" -> new ManualGameUI(g);
            default -> {
                System.out.println("Invalid option, defaulting to manual mode.");
                yield new ManualGameUI(g);
            }
        };

        g.board().draw();
        mode.startGame();
    }
}
