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

    public static void showAllThePropertiesPfThePlayers(List<Player>players,List<Position>positions) {
   /*     List<Integer> ownersOfPositions=new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if((i+1)==positionsWithPlacesForBuilding){
                ownersOfPositions.add(positions.get(i+1))
            }
            if (sum != 0) {
                System.out.print(pPAM[0][i] + "'s property:\nPlace's position: | ");
                for (int j = 0; j < pWCBBO[0].length; j++) {
                    if (i == pWCBBO[1][j]) {
                        System.out.print(pWCBBO[0][j] + " | ");
                    }
                }
                System.out.print("\nHouses there:     | ");
                for (int j = 0; j < pWCBBO[0].length; j++) {
                    if (i == pWCBBO[1][j]) {
                        System.out.print(pWCBBO[2][j] + " | ");
                    }
                }
                System.out.print("\nHotels there:     | ");
                for (int j = 0; j < pWCBBO[0].length; j++) {
                    if (i == pWCBBO[1][j]) {
                        System.out.print(pWCBBO[3][j] + " | ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    */}
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
                    showAllThePropertiesPfThePlayers(players,positions);
                }
            }
        }
        showTheWinner(players);
    }//Main

    /*public static String[][] giveMoneyToThePlayer(String[][] pPAM, int i, int[][] pWCBBO, int j, int[][] prices) {
        int sum = prices[2][0] + (prices[2][1] * pWCBBO[2][j]) + (prices[2][2] * pWCBBO[3][j]);
        pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) + sum);
        return pPAM;
    }*/
    //set in property for Building-или метод p
    public static int[] pricesForColumn(int l) {
        int[] pFC = new int[l];
        for (int i = 0; i < l; i++) {
            pFC[i] = 0;
        }
        return pFC;
    }//Main

    public static void showProperty(int i, int[][] pWCBBO, int[][] prices) {
        int[] pFC = pricesForColumn(pWCBBO[0].length);
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
        System.out.println();
    }//Main

    public static boolean checkIfThePlayerHasAnyProperty(int[][] pWCBBO, int i) {
        boolean check = false;
        for (int j = 0; j < pWCBBO[0].length; j++) {
            if (pWCBBO[1][j] == i) {
                check = true;
                break;
            }
        }
        return check;
    }//Main

    public static int[] getPropertyIndexes(int i, int[][] pWCBBO) {
        int[] array = new int[pWCBBO[0].length];
        int br = 0;//save the number of indexes
        for (int j = 0; j < array.length; j++) {//create array
            array[j] = -1;
        }
        for (int j = 0; j < pWCBBO.length; j++) {
            if (pWCBBO[1][j] == i) {
                array[br] = pWCBBO[0][j];
                br++;
            }
        }
        int[] array2 = new int[br];//final array
        for (int j = 0; j < br; j++) {
            array2[j] = array[j];
        }
        return array2;
    }//Main

    /*public static String[] aksIfSellingProperty(String n, int i, int [][]pWCBBO, int[][]prices){
        Scanner scan=new Scanner(System.in);
        String []array=new String[pWCBBO[0].length];// a player can have all the properties after all
        int br=0;//number of indexes we have in array, saves the last index
        boolean check=checkIfThePlayerHasAnyProperty(pWCBBO,i);
        while(check) {
            System.out.print(n + ", do you want to sell property to the bank?\nType \"y\" for yes and \"n\" for now:");
            String option= scan.nextLine();
            if(option.equalsIgnoreCase("y")) {
                while(check){
                    showProperty(i, pWCBBO, prices);
                    System.out.print("Type a position of the property you want to sell.\nIf there are buildings on it," +
                            " they will be sold too.\nIf you don't want to sell anything, type \"c\" for cancel: ");
                    String option2 = scan.nextLine();
                    if (option2.equalsIgnoreCase("c")) {
                        check = false;
                        break;
                    }
                    int[] gPI = getPropertyIndexes(i, pWCBBO);
                    for (int g : gPI) {
                        if (option2.equalsIgnoreCase(Integer.toString(g))) {
                            array[br] = option2;
                            br++;
                            System.out.println(n + ", you sold your property on position " + option2 + " to the bank.");
                            for (int j = 0; j < pWCBBO[0].length; j++) {
                                if (Integer.toString(pWCBBO[0][j]).equalsIgnoreCase(option2)) {
                                    pWCBBO[1][j] = -1;
                                }
                            }
                        }
                        check = checkIfThePlayerHasAnyProperty(pWCBBO, i);
                    }
                }
            }
            if(option.equalsIgnoreCase("n")){
            check=false;
            }
        }
        System.out.println();
        return array;
    }*/
    public static void showTheWinner(List<Player> players) {
        for (int i = 0; i < playersCount; i++) {
            if (!players.get(i).isHasBankrupted()) {
                System.out.println("The winner is " + players.get(i).getName() + "!");
            }
        }
    }//Main

    public static int[][] giveAllThePropertyToTheBank(int x, int[][] pWCBBO) {
        for (int i = 0; i < pWCBBO[0].length; i++) {
            if (pWCBBO[1][i] == x) {
                pWCBBO[1][i] = -1;
                pWCBBO[2][i] = 0;
                pWCBBO[3][i] = 0;
            }
        }
        return pWCBBO;
    }//Main and Person

    /*public static String[] getNicknames(String o) {
        String[] nicknames = letsPickNicknames(Integer.parseInt(o));
        String[] finalNicknames = letsThrowDicesBeforeTheActualGame(nicknames);
        System.out.println("This is the order of the players:");
        for (int i = 0; i < finalNicknames.length; i++) {
            System.out.println((i + 1) + ". " + finalNicknames[i]);
        }
        return finalNicknames;
    }//Main
*/
    //I was enthusiastic, so I let the "lets" part remain in the next two methods' names
    public static void letsPickNicknames() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < playersCount; i++) {
            System.out.print("Enter a nickname: ");
            String newNickname=scan.nextLine();
            nicknames.add(newNickname);
        }
    }//Main

    /*public static String[] letsThrowDicesBeforeTheActualGame(String[] n) {
        Scanner scan = new Scanner(System.in);
        String[] finalNicknames = new String[n.length];
        int[][] sortedScore = new int[2][n.length];//[score][index of nickname]
        int[][] safeIndexesWhichOwnersHadEqualScores = new int[n.length - 1][2];
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n.length; i++) {
            throwTheDices(n[i]);
            int score = getResultFromDices();
            System.out.println(n[i] + " got score " + score);
            sortedScore[0][i] = score;
            sortedScore[1][i] = i;
        }//8,7,5,5,  0,1,2,3
        for (int i = 0; i < sortedScore[0].length; i++) {
            for (int j = 0; j < sortedScore[0].length; j++) {
                if ((i != j) && (sortedScore[0][i] == sortedScore[0][j])) {
                    int br2 = 0;
                    //checkIfWe
                    boolean letsSeeIfWeHaveNotAlreadyCheckedTheseIndexesAndTheirScores = true;
                    for (int k = 0; k < safeIndexesWhichOwnersHadEqualScores.length; k++) {
                        int s3 = safeIndexesWhichOwnersHadEqualScores[k][0];
                        int s4 = safeIndexesWhichOwnersHadEqualScores[k][1];
                        if ((sortedScore[1][i] == s3 && sortedScore[1][j] == s4) || (sortedScore[1][i] == s4 && sortedScore[1][j] == s3)) {
                            letsSeeIfWeHaveNotAlreadyCheckedTheseIndexesAndTheirScores = false;

                        }
                    }

                    while (br2 == 0 && letsSeeIfWeHaveNotAlreadyCheckedTheseIndexesAndTheirScores) {
                        int[] newThrowingScores = {0, 0};
                        throwTheDices(n[i]);
                        newThrowingScores[0] = getResultFromDices();
                        System.out.println(n[i] + " got score " + newThrowingScores[0]);
                        throwTheDices(n[j]);
                        newThrowingScores[1] = getResultFromDices();
                        System.out.println(n[j] + " got score " + newThrowingScores[1]);
                        if (newThrowingScores[0] < newThrowingScores[1]) {
                            sortedScore[1][i] = j;
                            sortedScore[1][j] = i;
                            safeIndexesWhichOwnersHadEqualScores[s1][s2] = i;
                            s2++;
                            safeIndexesWhichOwnersHadEqualScores[s1][s2] = j;
                            s1++;
                            br2 = 1;
                        } else if (newThrowingScores[0] > newThrowingScores[1]) {
                            br2 = 1;
                            safeIndexesWhichOwnersHadEqualScores[s1][s2] = i;
                            s2++;
                            safeIndexesWhichOwnersHadEqualScores[s1][s2] = j;
                            s1++;
                        }
                    }
                    s2 = 0;
                }
            }
        }
        ArrayList<Integer> inDescendingOrder = new ArrayList<Integer>(n.length);
        for (int i = 0; i < sortedScore[0].length; i++) {
            inDescendingOrder.add(sortedScore[0][i]);
        }
        Collections.sort(inDescendingOrder);
        Collections.reverse(inDescendingOrder);
        int[] a = new int[n.length];
        int b = 0;
        for (int num : inDescendingOrder) {
            a[b] = num;
            b++;
        }
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (a[i] == sortedScore[0][j]) {
                    finalNicknames[i] = n[sortedScore[1][j]];
                    sortedScore[0][j] = 0;
                    j = n.length;
                }
            }
        }
        return finalNicknames;
    }//Main
*/
}