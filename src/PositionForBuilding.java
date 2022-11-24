import java.util.List;
import java.util.Scanner;

public class PositionForBuilding extends Position implements RentAblе {
    private static final int buyAPosition = 300;
    private static final int buyAHouse = 150;
    private static final int buyAHotel = 100;

    private static final int rentAPosition = 200;
    private static final int rentAHouse = 100;
    private static final int rentAHotel = 50;
    private int owner;
    private int amountOfHouses;
    private int amountOfHotels;

    @Override
    public void seeWhatThePositionOffersOrTakes(List<Player> players, int i, List<Position> positions) {
        Scanner sc = new Scanner(System.in);
        if (isTheBankTheOwner()) {
            if (askForBuyingThePlace(players, i)) {
                System.out.println(buyThePlace(players, i));
            }
        } else if (getOwner() == i) {
            if (amountOfHouses < 4 && players.get(i).getCash() >= buyAHouse && askForBuyingAHouse(players, i)) {
                System.out.println(buildHouseOnPosition(players, i));
            }
            if (amountOfHotels == 0 && players.get(i).getCash() >= buyAHotel && askForBuyingAHotel(players, i)) {
                System.out.println(buildHotelOnPosition(players, i));
            }
        } else {
            System.out.println(payTheOwner(players, i));
        }
        System.out.println();
    }

    protected String buildHouseOnPosition(List<Player> players, int i) {
        setAmountOfHouses(getAmountOfHouses() + 1);
        players.get(i).setCash(players.get(i).getCash() - buyAHouse);
        return (players.get(i).getName() + " bought a house.");
    }

    protected String buildHotelOnPosition(List<Player> players, int i) {
        setAmountOfHotels(1);
        players.get(i).setCash(players.get(i).getCash() - buyAHotel);
        return (players.get(i).getName() + " bought a hotel.");
    }

    protected String buyThePlace(List<Player> players, int i) {
        setOwner(i);
        players.get(i).setCash(players.get(i).getCash() - buyAPosition);
        return ("The place on position " + getNumberPosition() + " is bought by " + players.get(i).getName() + ".");
    }

    @Override
    public String payTheOwner(List<Player> players, int i) {
        int sum = rentAPosition + (rentAHouse * amountOfHouses) + (rentAHotel * amountOfHotels);
        players.get(owner).setCash(players.get(getOwner()).getCash() + sum);
        players.get(i).setCash(players.get(i).getCash() - sum);
        return (players.get(i).getName() + " gave " + sum + " rent to " + players.get(owner).getName() + ".");
    }

    protected boolean isTheBankTheOwner() {
        if (owner == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean askForBuyingAHouse(List<Player> players, int i) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(players.get(i).getName() + ", do you want to buy a house on this position, " + getNumberPosition() + ", for " + buyAHouse + "? Type \"y\" for yes or \"n\" for no: ");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Incorrect input, try again, " + players.get(i).getName() + ".");
            }
        }
    }

    public boolean askForBuyingAHotel(List<Player> players, int i) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(players.get(i).getName() + ", do you want to buy a hotel on this position, " + getNumberPosition() + ", for " + buyAHotel + "? Type \"y\" for yes or \"n\" for no: ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Incorrect input, try again, " + players.get(i).getName() + ".");
            }
        }
    }

    public boolean askForBuyingThePlace(List<Player> players, int i) {
        Scanner scan = new Scanner(System.in);
        if (players.get(i).getCash() >= buyAPosition) {
            while (true) {
                System.out.print(players.get(i).getName() + ", do you want to buy this position, " + getNumberPosition() + ", for " + buyAPosition + "? Type \"y\" for yes or \"n\" for no: ");
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    return true;
                } else if (answer.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    System.out.println("Incorrect input, try again, " + players.get(i).getName() + ".");
                }
            }
        }
        return false;
    }

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
                "numberPosition=" + getNumberPosition() +
                ", owner=" + getOwner() +
                ", amountOfHouses=" + getAmountOfHouses() +
                ", amountOfHotels=" + getAmountOfHotels() +
                '}';
    }

}
