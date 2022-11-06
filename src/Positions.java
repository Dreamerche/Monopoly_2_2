public class Positions {
    protected int numberPosition;

    public Positions(int numberPosition) {
        this.numberPosition = numberPosition;
    }

    public int getNumberPosition() {
        return numberPosition;
    }

    public void setNumberPosition(int numberPosition) {
        this.numberPosition = numberPosition;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "numberPosition=" + numberPosition +
                '}';
    }
}
