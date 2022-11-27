import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBuyPosition {
    /*protected String buyThePlace(List<Player> players, int i) {
        setOwner(i);
        players.get(i).setCash(players.get(i).getCash() - buyAPosition);
        return ("The place on position " + getNumberPosition() + " is bought by " + players.get(i).getName() + ".");
    }*/
    @Test
    public void testBuyThePlace1() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(3);
        Assert.assertEquals("The place on position 3 is bought by Pesho.", positionForBuilding.buyThePlace(players,0));
    }

    @Test
    public void testBuyThePlace2() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(5);
        positionForBuilding.buyThePlace(players,1);
        Assert.assertTrue("Method doesn't return expected value", (positionForBuilding.getOwner()==1));
    }

    @Test
    public void testBuyThePlace3() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(8);
        int oldCash= (int) players.get(1).getCash();
        int pricePosition= positionForBuilding.getBuyAPosition();
        positionForBuilding.buyThePlace(players,1);
        int newCash= (int) players.get(1).getCash();
        Assert.assertTrue("Method doesn't return expected value", (oldCash==newCash+pricePosition));
    }
}
