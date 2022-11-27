import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements MoveOnBoardable {
    protected static int cashShowingBadFinancialStatus=300;
    private String name;
    private double cash;
    private int currentPosition;
    private boolean beingInJail;
    private boolean hasBankrupted;
    private boolean hasLostAllTheirProperty;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", currentPosition=" + currentPosition +
                ", beingInJail=" + beingInJail +
                ", hasBankrupted=" + hasBankrupted +
                ", hasLostAllTheirProperty"+hasLostAllTheirProperty+
                '}';
    }

    public Player(String name) {
        this.name = name;
        this.cash = 1500;
        this.currentPosition = 1;
        this.beingInJail = false;
        this.hasBankrupted = false;
        this.hasLostAllTheirProperty=false;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        if (cash < 0) {
            System.out.println(getName() + " has bankrupted.");
            setHasBankrupted(true);
        }
        this.cash = cash;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isBeingInJail() {
        return beingInJail;
    }

    public void setBeingInJail(boolean beingInJail) {
        this.beingInJail = beingInJail;
    }

    public boolean isHasBankrupted() {
        return hasBankrupted;
    }

    public void setHasBankrupted(boolean hasBankrupted) {
        this.hasBankrupted = hasBankrupted;
    }

    public boolean isHasLostAllTheirProperty() {
        return hasLostAllTheirProperty;
    }

    public void setHasLostAllTheirProperty(boolean hasLostAllTheirProperty) {
        this.hasLostAllTheirProperty = hasLostAllTheirProperty;
    }

    @Override
    public void setTheNewPosition(List<Player> players, int i) {
        throwTheDices(new Scanner(System.in));
        int score = getResultFromDices();
        System.out.println(getName() + " got score " + score + ".");
        setCurrentPosition(getCurrentPosition() + score);
        if (getCurrentPosition() > 40) {
            setCurrentPosition(getCurrentPosition() - 40);
            setCash(getCash() + 200);
            System.out.print(getName()+ " gains 200 money, because they passed the start. ");

        }
        System.out.println("Now " + getName() + " is on position " + getCurrentPosition() + ".\n");
    }
    public boolean offerToSellProperty(int i,List<Player>players,List<Position>positions){
        CurrentPositionsForBuilding currentPositionsForBuilding=new CurrentPositionsForBuilding();
        List<PositionForBuilding> positionsWithOwners=currentPositionsForBuilding.getPositionsForBuildingWithOwners(players,positions);
        List<PositionForBuilding> playersPositions=new ArrayList<>();
        for (PositionForBuilding position:positionsWithOwners) {
            if(position.getOwner()==i){
                playersPositions.add(position);
            }
        }
        if(playersPositions.size()!=0 && getCash()<=cashShowingBadFinancialStatus){//has property and lacks in cash
            return (askPlayerToSellProperty(new Scanner(System.in),i,positions,playersPositions));
        }
        return false;
    }
    protected boolean askPlayerToSellProperty(Scanner scanner,int i,List<Position> positions, List<PositionForBuilding>playersPositions) {
        while (true) {
            PlayersProperty playersProperty=new PlayersProperty();
            playersProperty.getPlayersPropertyInformation(i,playersPositions);
            List<Integer> playersPropertyPositions = new ArrayList<>();
            for (PositionForBuilding position : playersPositions) {
                playersPropertyPositions.add(position.getNumberPosition());
            }

            System.out.print("Do you want to sell one of your properties?\n" +
                    "If yes, type \"y\", type \"n\" otherwise:");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("n"))
            {
                return false;
            }
            else if(option.equalsIgnoreCase("y")){
                return true;
            }
        }
        /*try {
            //if (playersPropertyPositions.contains(option)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }*/
    }
    public String throwTheDices(Scanner scanner) {//test if you can
        System.out.print(getName() + ", throw the dices by typing \"t\": ");
        while (true) {
            String typed = scanner.nextLine();
            if (typed.equalsIgnoreCase("t")) {
                return ("dices were thrown");
            }
        }
    }
    public int getRandomNumberFromMinToMax( int minNumber, int maxNumber){
        return (int) Math.floor(Math.random() * (maxNumber-minNumber+1) + minNumber);
    }
    protected int getResultFromDices() {
        int sum = 0;
        sum += getRandomNumberFromMinToMax(1,6);
        sum += getRandomNumberFromMinToMax(1,6);
        return sum;
    }

    public void loseAllProperty(int i, List<PositionForBuilding> positionsWithOwners) {
        for (PositionForBuilding position:positionsWithOwners) {
            if(position.getOwner()==i){
                position.setOwner(-1);
            }
        }
        setHasLostAllTheirProperty(true);
    }
}
