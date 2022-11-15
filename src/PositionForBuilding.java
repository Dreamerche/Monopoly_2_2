import java.util.Scanner;
public class PositionForBuilding extends Position {
    static int numberPosition;


    public int owner;
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

    public static int[][] getPrices() {
        int price;
        int[] [] prices = {
                {300, 200, 300},//i made them higher because the game will be really slow for testing otherwise:)
                {250, 500, 700},
                {150, 100, 150}
                //place | house | hotel
                /*{150, 100, 150},//buy
                {10,25,35},//rent
                {75,50,75}//sell*/
        };
        return prices;
    }
    public static boolean askForBuyingThePlace(String n, String[][] pPAM, int position, int[][] prices) {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        if (Integer.parseInt(pPAM[2][position]) >= prices[0][0])
            while (true) {
                System.out.print(n + ", do you want to buy this position, " + pPAM[1][position] + ", for " + prices[0][0] + "? Type \"y\" for yes or \"n\" for no: ");
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    check = true;
                    break;
                } else if (answer.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Incorrect input, try again, " + n + ".");
                }
            }
        return check;
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
}
