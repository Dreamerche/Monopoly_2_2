import java.util.List;
import java.util.Scanner;

public class PositionCommunityChestCard extends Position implements Askablе{

    public PositionCommunityChestCard(int numberPosition) {
        super(numberPosition);
    }
    public void seeWhatThePositionOffersOrTakes(List<Player>players,int i,List<Position>positions){
        seeTheCommunityChestCard(players,i);
    }
    @Override
    public String toString() {
        return "PositionCommunityChestCart{" +
                "numberPosition=" + numberPosition +
                '}';
    }

    protected int getRandomFrom0To6() {
        return (int) Math.floor(Math.random() * (6 - 0 + 0) + 0);
    }

    private void seeTheCommunityChestCard(List<Player> players, int i) {
        int number = getRandomFrom0To6();
        System.out.print(players.get(i).getName() + ", your community chest card ");
        if (number <= 2) {
            int sum = (number + 1) * 50;
            System.out.println("gives you " + sum + " money!");
            players.get(i).setCash(players.get(i).getCash() + sum);
        } else if (number <= 5) {
            int sum = 100;
            System.out.println("gets from you " + sum + " money and gives them to the bank!");
            players.get(i).setCash(players.get(i).getCash() - sum);
        } else {
            System.out.print("puts you in prison!");
            askForPayingTheBankAndGetFree(players, i);
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
