import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int playersCount=0;
    static List<String> nicknames;
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
                playersCount=Integer.parseInt(option);
                startTheGame();
                break;
            } else {
                System.out.println("Your input isn't correct!");
            }
        }
    }//

    public static String[][] putNicknamesPlaceThePlayersOnStartAnGiveThemMoney(String[] n) {
        String[][] a = new String[3][n.length];
        for (int i = 0; i < n.length; i++) {
            a[0][i] = n[i];
            a[1][i] = "0";
            a[2][i] = "1500";
        }
        return a;
    }//Main

    public static void showThePlayersPositionAndMoney(String[][] pPAM) {
        System.out.println("Player | Position | Money");
        for (int i = 0; i < pPAM[0].length; i++) {
            System.out.print("| ");
            for (int j = 0; j < pPAM.length; j++) {
                System.out.print(pPAM[j][i] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }//Main

    public static void setPositionsByDefault(List<Positions> positions) {
        int[] positionsWithPlacesForBuilding = {2, 4, 7, 9, 10, 12, 14, 15, 17, 19, 20, 22, 24, 25, 27, 28, 30, 32, 33, 35, 38, 40};//positions
        int[][] pWCBBO = new int[4][positionsWithPlacesForBuilding.length];
        for (int i = 0; i < positionsWithPlacesForBuilding.length; i++) {
            pWCBBO[0][i] = positionsWithPlacesForBuilding[i];//positions
            pWCBBO[1][i] = -1;//owner, if -1, it's a bank's property
            pWCBBO[2][i] = 0;//houses on this place
            pWCBBO[3][i] = 0;//hotels on this place
        }
    }//Main

    //public static int[][] getPrices() {
//PositionForBuilding

    //public static int checkIfThePositionIsPlaceForBuilding(String playerPosition, int[][] p) {
//getOnNewPosition() -да го създам в интерфейс

    //public static boolean askForBuyingThePlace(String n, String[][] pPAM, int position, int[][] prices) {
    //classPositionForBuilding
    //public static boolean askForBuyingAHouse(int[][] pWCBBO, String[][] pPAM, int i, int[][] prices, int a)
    //classPositionForBuilding
    //public static boolean askForBuyingAHotel(int[][] pWCBBO, String[][] pPAM, int i, int[][] prices, int a)
    //classPositionForBuilding
    //public static int whatIsPutInThePosition(int[][] pWCBBO, int[][] prices, String[][] pPAM, int a, int i) {
    //classPositionForBuilding
    public static int getRandomFrom0To6() {
        return (int) Math.floor(Math.random() * (7 - 0 + 0) + 0);
    }
    //cardsPosition
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
    //Newinterface -implements Prison, card+
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
    //chanceCard
    public static String[][] seeTheCommunityChestCard(String[][] pPAM, int i) {
        int number = getRandomFrom0To6();
        System.out.print(pPAM[0][i] + ", your community chest card ");
        if (number <= 2) {
            int sum = (number + 1) * 50;
            System.out.println("gives you " + sum + " money!");
            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) + sum);
        } else if (number <= 5) {
            int sum = 100;
            System.out.println("gets from you " + sum + " money and gives them to the bank!");
            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - sum);
        } else {
            System.out.print("puts you in prison!");
            pPAM = askForPayingTheBankAndGetFree(pPAM, i);
        }
        return pPAM;
    }
    //CommunityChestCard
    public static String[][] getAChanceCardOrCommunityChestCard(String[][] pPAM, int i) {
        int[] chancePositions = {8, 23, 37};//0-3: receive 50,100,150,200 money, 4-5: give 100 to the bank, 6:go to jail
        int[] communityPositions = {3, 18, 34};//0-2: receive 50,100,150 money, 3-5: give 100 money, 6: go to jail
        for (int pos : chancePositions) {
            if (Integer.parseInt(pPAM[1][i]) == pos) {
                pPAM = seeTheChanceCard(pPAM, i);
            }
        }
        for (int pos : communityPositions) {
            if (Integer.parseInt(pPAM[1][i]) == pos) {
                pPAM = seeTheCommunityChestCard(pPAM, i);
            }
        }
        System.out.println();
        return pPAM;
    }
    //Main
    public static void showAllThePropertiesPfThePlayers(String[][] pPAM, int[][] pWCBBO) {
        for (int i = 0; i < pPAM[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < pWCBBO[0].length; j++) {
                if (i == pWCBBO[1][j]) {
                    sum++;
                }
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
    //Main
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
    //cardPrison
    public static void putPlayersAtStart(List<Player> players){
        for (int i = 0; i < playersCount; i++) {
            players.add(new Player(nicknames.get(i)));
        }
    }
    public static void startTheGame() {
        List<Player> players=new ArrayList<Player>();
        putPlayersAtStart(players);
        ArrayList<Positions> positions=new ArrayList<Positions>(40);//ListOfPositions
        setPositionsByDefault(positions);
        for (var p:players) {
            System.out.println(p);        }

        int[][] prices = getPrices();//static prices in Position Of Building
        int br = nicknames.length;//saves the number of players who hasn't bankrupted yet
        while (br != 1) {//while we have at least 2 to be playing
            for (int i = 0; i < nicknames.length; i++) {
                if (Integer.parseInt(pPAM[2][i]) > -1 && br != 1) {//if the player hasn't bankrupted or isn't the only one left
                    int br2 = 0;//check if in prison
                    if (Integer.parseInt(pPAM[1][i]) == 11) {
                        throwTheDices(nicknames[i]);
                        pPAM = throwTheDicesToGetOutOfJail(pPAM, i);
                        if (pPAM[1][i].equalsIgnoreCase("12")) {
                            pPAM[1][i] = Integer.toString(11);
                        } else {
                            br2 = 1;
                        }
                    }
                    if (br2 == 0) {
                        pPAM = letThePlayerPlay(nicknames, i, pPAM);//throw dices and move to the new position
                        if (pPAM[1][i].equalsIgnoreCase("11") || pPAM[1][i].equalsIgnoreCase("31")) {
                            System.out.println(pPAM[0][i] + " goes to jail! ");
                            int a = Integer.parseInt(pPAM[2][i]);
                            int b = Integer.parseInt(pPAM[1][i]);
                            pPAM = askForPayingTheBankAndGetFree(pPAM, i);
                            if (Integer.parseInt(pPAM[2][i]) != a) {
                                if (b == 11) {
                                    pPAM[1][i] = "13";
                                    System.out.println("Now you're on position 13.");
                                } else {
                                    System.out.println("You stay on position 31.");
                                    pPAM[1][i] = "31";
                                }
                            }
                        }
                    }
                    int a = checkIfThePositionIsPlaceForBuilding(pPAM[1][i], pWCBBO);//saves the index of the column
                    if (a >= 0)//check if the place can have buildings on it
                    {
                        if (pWCBBO[1][a] == i)//check if we have the place
                        {
                            boolean f = askForBuyingAHotel(pWCBBO, pPAM, i, prices, a);
                            if (f) {
                                pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - prices[0][2]);
                                pWCBBO[3][a]++;
                            }
                            boolean c = askForBuyingAHouse(pWCBBO, pPAM, i, prices, a);
                            if (c) {
                                pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - prices[0][1]);
                                pWCBBO[2][a]++;
                            }
                        } else if (pWCBBO[1][a] > -1) {//pay rent
                            System.out.println("\n" + pPAM[0][i] + " gives a rent of " + whatIsPutInThePosition(pWCBBO, prices, pPAM, a, i) + "  to " + pPAM[0][pWCBBO[1][a]] + ".\n");
                            pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - whatIsPutInThePosition(pWCBBO, prices, pPAM, a, i));
                            pPAM[2][pWCBBO[1][a]] = Integer.toString(Integer.parseInt(pPAM[2][pWCBBO[1][a]]) + whatIsPutInThePosition(pWCBBO, prices, pPAM, a, i));
                        } else {
                            boolean b = askForBuyingThePlace(nicknames[i], pPAM, i, prices);
                            if (b)//check if buying the place
                            {
                                pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - prices[0][0]);
                                pWCBBO[1][a] = i;
                            }
                        }
                    }
                    boolean b = checkIfThePositionGivesAChanceOrCommunityChestCard(pPAM[1][i]);
                    if (b) {
                        pPAM = getAChanceCardOrCommunityChestCard(pPAM, i);
                    }
                    if (Integer.parseInt(pPAM[2][i]) < 0) {//check if the player has money and if they're in dept
                        pWCBBO = giveAllThePropertyToTheBank(i, pWCBBO);
                        System.out.println(pPAM[0][i] + ", you bankrupted and lost your property.\n");
                        br--;
                    }
                    /*String[] chosenPropertyToSell=aksIfSellingProperty(nicknames[i], i, pWCBBO,prices);
                    for (int j = 0; j < pWCBBO[0].length; j++) {
                        for (int k = 0; k < chosenPropertyToSell.length; k++) {
                            if(chosenPropertyToSell[k]!=null) {
                                if (chosenPropertyToSell[k].equalsIgnoreCase(Integer.toString(pWCBBO[0][j]))) {
                                    pPAM = giveMoneyToThePlayer(pPAM, i, pWCBBO, j, prices);
                                    pWCBBO[1][j] = -1;
                                }
                            }
                        }
                    }*/
                    showThePlayersPositionAndMoney(pPAM);
                    showAllThePropertiesPfThePlayers(pPAM, pWCBBO);
                }
            }
        }
        showTheWinner(pPAM);
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
    public static void showTheWinner(String[][] pPAM) {
        for (int i = 0; i < pPAM[0].length; i++) {
            if (Integer.parseInt(pPAM[2][i]) > 0) {
                System.out.println("The winner is " + pPAM[0][i] + ".");
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

    public static String[] getNicknames(String o) {
        String[] nicknames = letsPickNicknames(Integer.parseInt(o));
        String[] finalNicknames = letsThrowDicesBeforeTheActualGame(nicknames);
        System.out.println("This is the order of the players:");
        for (int i = 0; i < finalNicknames.length; i++) {
            System.out.println((i + 1) + ". " + finalNicknames[i]);
        }
        return finalNicknames;
    }//Main

    //I was enthusiastic, so I let the "lets" part remain in the next two methods' names
    public static String[] letsPickNicknames(int countOfPlayers) {
        Scanner scan = new Scanner(System.in);
        String[] nicknames = new String[countOfPlayers];
        for (int i = 0; i < countOfPlayers; i++) {
            System.out.print("Enter a nickname: ");
            nicknames[i] = scan.nextLine();
        }
        return nicknames;
    }//Main

    public static String[] letsThrowDicesBeforeTheActualGame(String[] n) {
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

    public static void throwTheDices(String n) {
        Scanner scan = new Scanner(System.in);
        System.out.print(n + ", throw the dices by typing \"t\": ");
        while (true) {
            String typed = scan.nextLine();
            if (typed.equalsIgnoreCase("t")) {
                break;
            }
        }
    }//Main

    public static int getResultFromDices() {
        int sum = 0;
        sum += Math.floor(Math.random() * (6 - 1 + 1) + 1);
        sum += Math.floor(Math.random() * (6 - 1 + 1) + 1);
        return sum;
    }//Main

    public static String[][] letThePlayerPlay(String[] n, int i, String[][] pAP) {
        throwTheDices(n[i]);
        int score = getResultFromDices();
        System.out.println(n[i] + " got score " + score + ".");
        for (int j = 0; j < n.length; j++) {
            if (pAP[0][j] == n[i]) {
                int newPosition = Integer.parseInt(pAP[1][j]) + score;
                if (newPosition > 40) {
                    newPosition = newPosition - 40;
                    pAP[2][j] = Integer.toString(Integer.parseInt(pAP[2][j]) + 200);
                    System.out.print(pAP[0][j] + " gains 200 money. ");

                }
                pAP[1][j] = Integer.toString(newPosition);
                System.out.println("Now " + pAP[0][j] + " is on position " + newPosition + ".\n");
            }
        }
        return pAP;
    }//Main

}