import java.util.List;
import java.util.Scanner;

public class PositionPrison extends Positions implements Askablе {

    public PositionPrison(int numberPosition) {
        super(numberPosition);
    }

    @Override
    public String toString() {
        return "PositionPrison{" +
                "numberPosition=" + numberPosition +
                '}';
    }

    public void throwTheDicesToGetOutOfJail(List<Player> players, int i) {
        int firstNum = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        int secondNum = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        if (firstNum == secondNum) {
            System.out.println("Lucky you! You got " + firstNum + "-" + secondNum + " from the dices and you're free!\n" +
                    "Now throw the dices to get to your new position!");
            players.get(i).setBeingInJail(false);
        } else {
            System.out.println("You got " + firstNum + "-" + secondNum + " from the dices and you aren't free!");
        }
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

