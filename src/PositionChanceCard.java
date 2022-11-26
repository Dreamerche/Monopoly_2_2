import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionChanceCard extends PositionsPuttingPlayerInPrison {

    public PositionChanceCard(int numberPosition) {
        super(numberPosition);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void seeWhatThePositionOffersOrTakes(List<Player> players, int i, List<Position> positions) {
        String isTheCardPuttingInJail = seeTheChanceCard(players, i);
        if (isTheCardPuttingInJail.equalsIgnoreCase("third scenario")) {
            super.askForPayingTheBankAndGetFree(players, i);
        }
    }

    protected String seeTheChanceCard(List<Player> players, int i) {//we couldn't think of another way to make a void better for testing
        int number = players.get(i).getRandomNumberFromMinToMax(0, 6);
        System.out.print(players.get(i).getName() + ", your chance card ");
        if (number <= 3) {//0-3: receive 50,100,150,200 money, 4-5: give 100 to the bank, 6:go to jail
            int sum = (number + 1) * 50;
            System.out.println("gives you " + sum + " money!\n");
            players.get(i).setCash(players.get(i).getCash() + sum);
            return "first scenario";

        } else if (number <= 5) {
            int sum = 100;
            System.out.println("gets from you " + sum + " money and gives them to the bank!\n");
            players.get(i).setCash(players.get(i).getCash() - sum);
            return "second scenario";
        } else {
            System.out.print("puts you in prison!");
            return "third scenario";
        }
    }
}



