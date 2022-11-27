import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public abstract class PositionsPuttingPlayerInPrison extends Position implements Askablе{
    //this class helps as its children use the method for paying and not getting in jail
    public PositionsPuttingPlayerInPrison(int numberPosition) {
        super(numberPosition);
    }
public String askForPayingTheBankAndGetFree(List<Player>players, int i){
        return askForPayingTheBankAndGetFree1(new Scanner(System.in),players,i);
}
    public String askForPayingTheBankAndGetFree1(Scanner scanner, List<Player> players, int i) {
        if (players.get(i).getCash() >= 50.0)//check if the player has 50 money
        {
            while (true) {
                System.out.print("Do you want to pay the bank 50 money and not get in jail?\n" +
                        "Type \"y\" for yes or \"n\" for no:");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("y")) {
                    players.get(i).setCash(players.get(i).getCash() - 50);
                    return "first scenario";
                }
                else if (option.equalsIgnoreCase("n")) {

                    players.get(i).setCurrentPosition(11);
                    players.get(i).setBeingInJail(true);
                    System.out.println(players.get(i).getName() + " goes to jail.");
                    return "second scenario";
                } else {
                    System.out.println("Incorrect input, try again, " + players.get(i).getName() + ".");
                    }
            }
        }
        else {
            System.out.println(players.get(i).getName() + " goes to jail.");
            players.get(i).setCurrentPosition(11);
            players.get(i).setBeingInJail(true);
            return "third scenario";
        }
    }
}