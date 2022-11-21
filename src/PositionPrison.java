import java.util.List;
import java.util.Scanner;

public class PositionPrison extends Position implements Askablе, OutOfJailable {

    public PositionPrison(int numberPosition) {
        super(numberPosition);
    }

    @Override
    public String toString() {
        return "PositionPrison{" +
                "numberPosition=" + numberPosition +
                '}';
    }
    @Override
    public void seeWhatThePositionOffersOrTakes(List<Player>players,int i,List<Position>positions){
        if(!players.get(i).isBeingInJail()){
            askForPayingTheBankAndGetFree(players,i);
        }
        else {
            System.out.println(throwTheDicesToGetOutOfJail(players, i));
        }
    }
    @Override
    public String throwTheDicesToGetOutOfJail(List<Player> players, int i) {
        throwTheDices(players,i);
        int firstNum = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        int secondNum = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        if (firstNum == secondNum) {
            players.get(i).setBeingInJail(false);
            return ("Lucky you! You got " + firstNum + "-" + secondNum + " from the dices and you're free!\n" +
                    "Now throw the dices to get to your new position!");
        } else {
            return ("You got " + firstNum + "-" + secondNum + " from the dices and you aren't free!");
        }
    }
    private void throwTheDices(List<Player> players, int i) {//test if you can
        Scanner scan = new Scanner(System.in);
        System.out.print(players.get(i) + ", throw the dices by typing \"t\": ");
        while (true) {
            String typed = scan.nextLine();
            if (typed.equalsIgnoreCase("t")) {
                break;
            }
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

