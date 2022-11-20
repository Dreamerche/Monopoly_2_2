import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class TestGetRandom {
    Scanner scan = new Scanner(System.in);

    @Test

    public void testGetRandomFrom0to6WhenPositionCommunityChestCard() {

        List<Integer> testList = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        PositionCommunityChestCard testPosition = new PositionCommunityChestCard(2);

            for (int i = 0; i < 7; i++) {
            Assert.assertTrue("Method doesn't return expected value",testList.contains(testPosition.getRandomFrom0To6()));
        }
    }


    @Test
    public void testGetRandomFrom0to6WhenPositionChangeCard() {

        List<Integer> testList1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        PositionChanceCard testPosition = new PositionChanceCard(10);

        for (int i = 0; i <= 7; i++) {
            Assert.assertTrue("Method doesn't return expected value",testList1.contains(testPosition.getRandomFrom0To6()));
        }
    }
}



