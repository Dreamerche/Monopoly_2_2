import java.util.*;

public class Main {
    static int playersCount=0;
    static List<String> nicknames=new ArrayList<>();
    public static void main(String[] args) {
    letsPlayMonopoly();
}
    public static void letsPlayMonopoly() {//to add try-catch
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the number of players[2;4]: ");
            String option = scan.nextLine();
            String[] numbers = {"2", "3", "4"};
            boolean checkTheOption = false;
            for (String num : numbers) {//check if the input is 2,3 or 4
                if (option.equalsIgnoreCase(num)) {
                    checkTheOption = true;
                }
            }
            if (checkTheOption) {
                playersCount=Integer.valueOf(option);
                startTheGame();
                break;
            } else {
                System.out.println("Your input isn't correct!");
            }
        }
    }//

    public static void showThePlayersPositionAndMoney(List<Player> players) {
        System.out.println("Player | Position | Money");
        for (int i = 0; i < playersCount; i++) {
            System.out.println(players.get(i).getName()+" | "+players.get(i).getCurrentPosition()+" | "+players.get(i).getCash());
        }
        System.out.println();
    }//Main

    public static void setPositionsByDefault(List<Position> positions) {
        //lists with the indexes, when playing, we typically chose the first position to be position 1, but in the programming
        //the first element in the list positions has index 0, that's why in the for we check if (i+1)=40
        List<Integer> positionsWithPlacesForBuilding = Arrays.asList(2, 4, 7, 9, 10, 12, 14, 15, 17, 19, 20, 22, 24, 25, 27, 28, 30, 32, 33, 35, 38, 40);//positions
        List<Integer> chancePositions=Arrays.asList(8,23,37);//0-3: receive 50,100,150,200 money, 4-5: give 100 to the bank, 6:go to jail
        List<Integer> communityPositions=Arrays.asList(3,18,34);//0-2: receive 50,100,150 money, 3-5: give 100 money, 6: go to jailint[] positionsWithChanceCards={};
        List<Integer> jailPositions=Arrays.asList(11,31);
        for (int i = 0; i < 40; i++) {//1
            if(positionsWithPlacesForBuilding.contains(i+1))
            {
                positions.add(new PositionForBuilding(i+1));
            }
            else if(chancePositions.contains(i+1)){
                positions.add(new PositionChanceCard(i+1));
            }
            else if(communityPositions.contains(i+1)){
                positions.add(new PositionCommunityChestCard(i+1));
            }
            else if(jailPositions.contains(i+1)){
                positions.add(new PositionPrison(i+1));
            }
            else{
                positions.add(new Position(i+1));//if the position don't have anything special, it's just a position
            }
        }
    }//Main

    public static void showAllThePropertiesOfThePlayers(List<Player>players,List<Position>positions) {
        CurrentPositionsForBuilding currentPositionsForBuilding=new CurrentPositionsForBuilding();
        List<PositionForBuilding> positionsWithOwners=currentPositionsForBuilding.getPositionsForBuildingWithOwners(players,positions);
        for (int i = 0; i < playersCount; i++) {
            if(checkIfThePlayerHasAnyProperty(i,positionsWithOwners)){
                System.out.println(players.get(i).getName()+"'s property:");
                PlayersProperty playersProperty=new PlayersProperty();
                playersProperty.getPlayersPropertyInformation(i,positionsWithOwners);
            }
        }
    }
    /*int[] pFC = pricesForColumn(pWCBBO[0].length);
        System.out.print("\nPlace's position: | ");
        int br = 0;//saves indexes and helps to sum
        for (int j = 0; j < pWCBBO[0].length; j++) {
            if (i == pWCBBO[1][j]) {
                System.out.print(pWCBBO[0][j] + " | ");
                pFC[br] = pFC[br] + prices[2][0];
                br++;
            }
        }
        br = 0;
        System.out.print("\nHouses there:     | ");
        for (int j = 0; j < pWCBBO[0].length; j++) {
            if (i == pWCBBO[1][j]) {
                System.out.print(pWCBBO[2][j] + " | ");
                pFC[br] += pFC[br] + (prices[2][1] * pWCBBO[2][j]);
                br++;
            }
        }
        br = 0;
        System.out.print("\nHotels there:     | ");
        for (int j = 0; j < pWCBBO[0].length; j++) {
            if (i == pWCBBO[1][j]) {
                System.out.print(pWCBBO[3][j] + " | ");
                pFC[br] = pFC[br] + (prices[2][2] * pWCBBO[3][j]);
                br++;
            }
        }
        System.out.print("\nPrice you'll get: ");
        for (int j = 0; j < br; j++) {
            System.out.print(pFC[j] + " | ");
        }
        System.out.println();*/
    public static boolean checkIfThePlayerHasAnyProperty(int i, List<PositionForBuilding> currentPositionsForBuilding){
        for (PositionForBuilding position:currentPositionsForBuilding) {
            if(position.getOwner()==i){
                return true;
            }
        }
        return false;
    }
    public static void putPlayersAtStart(List<Player> players){
        letsPickNicknames();
        for (int i = 0; i < playersCount; i++) {
            players.add(new Player(nicknames.get(i)));
        }
    }
    public static void startTheGame() {
        List<Player> players=new ArrayList<Player>();
        putPlayersAtStart(players);
        ArrayList<Position> positions=new ArrayList<Position>(40);//ListOfPositions
        setPositionsByDefault(positions);
        int br = playersCount;//saves the number of players who hasn't bankrupted yet
        while (br != 1) {//while we have at least 2 to be playing
            for (int i = 0; i < playersCount; i++) {
                if (!players.get(i).isHasBankrupted() && br != 1) {//if the player hasn't bankrupted or isn't the only one left
                    if (players.get(i).isBeingInJail()) {
                        positions.get(players.get(i).getCurrentPosition()-1).seeWhatThePositionOffersOrTakes(players,i,positions);//PositionsForJail
                    }
                    if(!players.get(i).isBeingInJail()){
                    players.get(i).setTheNewPosition(players,i);
                    positions.get(players.get(i).getCurrentPosition()-1).seeWhatThePositionOffersOrTakes(players,i,positions);
                    }
                    showThePlayersPositionAndMoney(players);
                    showAllThePropertiesOfThePlayers(players,positions);
                }
            }
        }
        showTheWinner(players);
    }//Main
    public static void showTheWinner(List<Player> players) {
        for (int i = 0; i < playersCount; i++) {
            if (!players.get(i).isHasBankrupted()) {
                System.out.println("The winner is " + players.get(i).getName() + "!");
            }
        }
    }//Main
    public static void letsPickNicknames() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < playersCount; i++) {
            System.out.print("Enter a nickname: ");
            String newNickname=scan.nextLine();
            nicknames.add(newNickname);
        }
    }//Main
}