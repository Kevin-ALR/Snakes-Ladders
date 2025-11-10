public class Dice {
    final private int faces;

    public Dice() {
        this(6);
    }

    public Dice(int faces) {
        if (faces <= 0) {
            throw new IllegalArgumentException("Dice must have at least one face!");
        }
        this.faces = faces;
    }

    public int roll() {
        return (int)(1 + Math.random() * faces);
    }
}
