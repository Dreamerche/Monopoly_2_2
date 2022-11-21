import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class TestGetRandom {
    Scanner scan = new Scanner(System.in);

    @Test
    public void testGetRandomFrom0to6WhenPositionsCards() {
        Player player1=new Player("Name for test 1");
        List<Integer> testList = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
            for (int i = 0; i < testList.size(); i++) {
            Assert.assertTrue("Method doesn't return expected value",testList.contains(player1.getRandomNumberFromMinToMax(0,6)));
        }
    }
    @Test
    public void testGetRandomFrom0to10WhenPositionsCards() {
        Player player2=new Player("Name for test 2");
        List<Integer> testList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,7,8,9,10);
        for (int i = 0; i < testList.size(); i++) {
            Assert.assertTrue("Method doesn't return expected value",testList.contains(player2.getRandomNumberFromMinToMax(0,10)));
        }
    }
    @Test
    public void testSeeTheCommunityChestCard() {

        Player player3=new Player("Name for test 3");
        PositionCommunityChestCard positionCommunityChestCard3=new PositionCommunityChestCard(1);
        player3.setCurrentPosition(positionCommunityChestCard3.getNumberPosition());
        List<Player> players=new ArrayList<>();
        players.add(player3);
        List<String> testList = Arrays.asList("first scenario","second scenario","third scenario");
        for (int i = 0; i < testList.size(); i++) {
            Assert.assertTrue("Method doesn't return expected value",testList.contains(positionCommunityChestCard3.seeTheCommunityChestCard(players,0)));
        }
    }
    @Test
    public void testSeeTheChanceCard() {

        Player player4=new Player("Name for test 4");
        PositionChanceCard positionChanceCard4=new PositionChanceCard(1);
        player4.setCurrentPosition(positionChanceCard4.getNumberPosition());
        List<Player> players=new ArrayList<>();
        players.add(player4);
        List<String> testList = Arrays.asList("first scenario","second scenario","third scenario");
        for (int i = 0; i < testList.size(); i++) {
            Assert.assertTrue("Method doesn't return expected value",testList.contains(positionChanceCard4.seeTheChanceCard(players,0)));
        }
    }
    }






