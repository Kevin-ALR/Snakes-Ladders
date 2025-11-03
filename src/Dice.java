public class Dice {
    final private int numberOfOptions;

    public Dice() {
        this(6);
    }

    public Dice(int numberOfOptions) {
        if (numberOfOptions <= 0) {
            throw new IllegalArgumentException("The number of options cannot be negative or zero!");
        }
        this.numberOfOptions = numberOfOptions;
    }

    public int roll() {
        return (int)(1 + Math.random() * numberOfOptions);
    }
}
