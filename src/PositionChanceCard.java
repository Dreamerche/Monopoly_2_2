import java.util.Scanner;

public class PositionChanceCard extends Positions {

    public PositionChanceCard(int numberPosition) {
        super(numberPosition);
    }

    @Override
    public String toString() {
        return "PositionChanceCard{" +
                "numberPosition=" + numberPosition +
                '}';
    }

    public static int getRandomFrom0To6() {
        return (int) Math.floor(Math.random() * (7 - 0 + 0) + 0);
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
    public static String[][] seeTheChanceCard(String[][] pPAM, int i) {
        int number = getRandomFrom0To6();
        System.out.print(pPAM[0][i] + ", your chance card ");
        if (number <= 3) {
            int sum = (number + 1) * 50;
            System.out.println("gives you " + sum + " money!");
            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) + sum);
        } else if (number <= 5) {
            int sum = 100;
            System.out.println("gets from you " + sum + " money and gives them to the bank!");
            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - sum);
        } else {
            System.out.print("puts you in prison! ");
            pPAM = askForPayingTheBankAndGetFree(pPAM, i);
        }
        return pPAM;
    }

    public static String[][] throwTheDicesToGetOutOfJail(String[][] pPAM, int i) {
        int firstNum = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        int secondNum = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        if (firstNum == secondNum) {
            System.out.println("Lucky you! You got " + firstNum + "-" + secondNum + " from the dices and you're free!\n" +
                    "Now throw the dices to get to your new position!");
            pPAM[1][i] = Integer.toString(12);
        } else {
            System.out.println("You got " + firstNum + "-" + secondNum + " from the dices and you aren't free!");
        }
        return pPAM;
    }

}
