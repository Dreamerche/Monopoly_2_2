public class PositionForBuilding extends Positions {
static int numberPosition;


    private int owner;
    private int amountOfHouses;
    private int amountOfHotels;

    public PositionForBuilding(int numberPosition) {
        super(numberPosition);
        this.owner = -1;
        this.amountOfHouses = 0;
        this.amountOfHotels = 0;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getAmountOfHouses() {
        return amountOfHouses;
    }

    public void setAmountOfHouses(int amountOfHouses) {
        if (amountOfHouses < 0) {
            amountOfHouses = 0;

        } else if (amountOfHouses > 4) {
            amountOfHouses = 4;
        }
        this.amountOfHouses = amountOfHouses;
    }

    public int getAmountOfHotels() {
        return amountOfHotels;
    }

    public void setAmountOfHotels(int amountOfHotels) {
        if (amountOfHotels < 0) {
            amountOfHotels = 0;

        } else if (amountOfHotels > 1) {
            amountOfHotels = 1;
        }

        this.amountOfHotels = amountOfHotels;
    }

    @Override
    public String toString() {
        return "PositionForBuilding{" +
                "owner=" + owner +
                ", amountOfHouses=" + amountOfHouses +
                ", amountOfHotels=" + amountOfHotels +
                '}';
    }
}
