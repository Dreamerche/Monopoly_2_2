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

    public void seeWhatThePositionOffersOrTakes(List<Player> players, int i, List<Position> positions) {
        if (isTheBankTheOwner()) {
            if(askForBuyingThePlace(players,i)){
                System.out.println(buyThePlace(players,i));
            }
        }
        else {
            System.out.println(payTheOwner(players,i));
        }
        System.out.println("Working on this method");
    }
    @Override
    public String payTheOwner(List<Player> players,int i){
        int sum=rentAPosition+(rentAHouse*amountOfHouses)+(rentAHotel*amountOfHotels);
        players.get(owner).setCash(players.get(owner).getCash()+sum);
        players.get(i).setCash(players.get(i).getCash()-sum);
        return (players.get(i).getName()+" gave "+sum+" rent to "+players.get(owner).getName()+".");
    }
    protected String buyThePlace(List<Player> players,int i){
        owner=i;
        players.get(i).setCash(players.get(i).getCash()-buyAPosition);
        return ("The place on position "+getNumberPosition()+" is bought by "+players.get(i).getName()+".");
    }
    protected boolean isTheBankTheOwner() {
        if (owner == -1) {
            return true;
        } else {
            return false;
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

    public static boolean askForBuyingAHouse(int[][] pWCBBO, String[][] pPAM, int i, int[][] prices, int a) {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        if (Integer.parseInt(pPAM[2][i]) >= prices[0][1] && pWCBBO[2][a] < 4) {
            while (true) {
                System.out.print(pPAM[0][i] + ", do you want to buy a house on  your current position," +
                        pPAM[1][i] + ", for " + prices[0][1] + "? Type \"y\" for yes and \"n\" for no: ");
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    check = true;
                    break;
                } else if (answer.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Incorrect input, try again, " + pPAM[0][i] + ".");
                }
            }
        }
        return check;
    }

    public static boolean askForBuyingAHotel(int[][] pWCBBO, String[][] pPAM, int i, int[][] prices, int a) {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        if (Integer.parseInt(pPAM[2][i]) >= prices[0][2] && pWCBBO[2][a] == 4 && pWCBBO[3][a] == 0) {
            while (true) {
                System.out.print(pPAM[0][i] + ", do you want to buy a hotel on  your current position, " + pPAM[1][i] +
                        ", for " + prices[0][2] + "? Type \"y\" for yes and \"n\" for no: ");
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    check = true;
                    break;
                } else if (answer.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Incorrect input, try again, " + pPAM[0][i] + ".");
                }
            }
        }
        return check;
    }

    public static int whatIsPutInThePosition(int[][] pWCBBO, int[][] prices, String[][] pPAM, int a, int i) {
        int sum = prices[1][0] + pWCBBO[2][a] * prices[1][1] + pWCBBO[3][a] * prices[1][2];
        return sum;
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
