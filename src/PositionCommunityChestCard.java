import java.util.List;
import java.util.Scanner;

public class PositionCommunityChestCard extends Positions implements Askablе {

    public PositionCommunityChestCard(int numberPosition) {
        super(numberPosition);
    }

    @Override
    public String toString() {
        return "PositionCommunityChestCart{" +
                "numberPosition=" + numberPosition +
                '}';
    }

    public static String[][] askForPayingTheBankAndGetFree(String[][] pPAM, int i) {
        Scanner scan = new Scanner(System.in);
        if (Integer.parseInt(pPAM[2][i]) >= 50)//check if the player has 50 money
        {
            while (true) {
                System.out.print("Do you want to pay the bank 50 money and not get in jail?\n" +
                        "Type \"y\" for yes or \"n\" for no:");
                String option = scan.nextLine();
                if (option.equalsIgnoreCase("y")) {
                    pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - 50);
                    break;
                } else if (option.equalsIgnoreCase("n")) {
                    System.out.println(pPAM[0][i] + " goes to jail.");
                    pPAM[1][i] = Integer.toString(11);
                    break;
                } else {
                    System.out.println("Incorrect input, try again, " + pPAM[0][i] + ".");
                }
            }
        }
        return pPAM;
    }

    public static int getRandomFrom0To6() {
        return (int) Math.floor(Math.random() * (7 - 0 + 0) + 0);
    }

    public static String[][] seeTheCommunityChestCard(String[][] pPAM, int i) {
        int number = getRandomFrom0To6();
        System.out.print(pPAM[0][i] + ", your community chest card ");
        if (number <= 2) {
            int sum = (number + 1) * 50;
            System.out.println("gives you " + sum + " money!");
            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) + sum);
        } else if (number <= 5) {
            int sum = 100;
            System.out.println("gets from you " + sum + " money and gives them to the bank!");
            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - sum);
        } else {
            System.out.print("puts you in prison!");
            pPAM = askForPayingTheBankAndGetFree(pPAM, i);
        }
        return pPAM;
    }


    @Override
    public void askForPayingTheBankAndGetFree(List<Player> players, int i) {
        Scanner scan = new Scanner(System.in);
        if (players.get(i).getCash() >= 50.0)//check if the player has 50 money
        {
            while (true) {
                System.out.print("Do you want to pay the bank 50 money and not get in jail?\n" +
                        "Type \"y\" for yes or \"n\" for no:");
                String option = scan.nextLine();
                if (option.equalsIgnoreCase("y")) {
                    players.get(i).setCash(players.get(i).getCash() - 50);
                    break;
                } else if (option.equalsIgnoreCase("n")) {
                    System.out.println(players.get(i).getName() + " goes to jail.");
                    players.get(i).setCurrentPosition(11);
                    players.get(i).setBeingInJail(true);
                    break;
                } else {
                    System.out.println("Incorrect input, try again, " + players.get(i).getName() + ".");
                }
            }
        }
    }
}
