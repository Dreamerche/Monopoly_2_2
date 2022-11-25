import java.util.List;
import java.util.Scanner;

public class PositionPrison extends PositionsPuttingPlayerInPrison implements OutOfJailable{

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
            super.askForPayingTheBankAndGetFree(players,i);
        }
        else {
            System.out.println(throwTheDicesToGetOutOfJail(players, i));
        }
    }
    @Override
    public String throwTheDicesToGetOutOfJail(List<Player> players, int i) {
        players.get(i).throwTheDices();
        int firstNum = players.get(i).getRandomNumberFromMinToMax(1,6);
        int secondNum = players.get(i).getRandomNumberFromMinToMax(1,6);
        if (firstNum == secondNum) {
            players.get(i).setBeingInJail(false);
            return ("Lucky you! You got " + firstNum + "-" + secondNum + " from the dices and you're free!\n" +
                    "Now throw the dices to get to your new position!");
        } else {
            return ("You got " + firstNum + "-" + secondNum + " from the dices and you aren't free!\n");
        }
    }

}

