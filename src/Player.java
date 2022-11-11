public class Player {
    private String name;
    private double cash;
    private int currentPosition;
    private boolean beingInJail;
    private boolean hasBankrupted;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", currentPosition=" + currentPosition +
                ", beingInJail=" + beingInJail +
                ", hasBankrupted=" + hasBankrupted +
                '}';
    }

    public Player(String name) {
        this.name = name;
        this.cash = 1500;
        this.currentPosition = 1;
        this.beingInJail = false;
        this.hasBankrupted=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isBeingInJail() {
        return beingInJail;
    }

    public void setBeingInJail(boolean beingInJail) {
        this.beingInJail = beingInJail;
    }

    public boolean isHasBankrupted() {
        return hasBankrupted;
    }

    public void setHasBankrupted(boolean hasBankrupted) {
        this.hasBankrupted = hasBankrupted;
    }
}
