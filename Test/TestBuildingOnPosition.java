import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestBuildingOnPosition {
    @Test
    public void testBuildHouseOnPosition() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(7);
        Assert.assertEquals("Pesho bought a house.", positionForBuilding.buildHouseOnPosition(players, 0));

    }
    @Test
    public void testBuildHouseOnPositionCheckIfCashChange() {

        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(7);
        int oldCash= (int) players.get(1).getCash();
        int priceHouse= positionForBuilding.getBuyAHouse();
        positionForBuilding.buildHouseOnPosition(players,1);
        int newCash= (int) players.get(1).getCash();

        Assert.assertTrue("Method doesn't return expected value",(oldCash==newCash+priceHouse));

    }
    @Test
    public void testBuildHotelOnPosition() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(7);
        Assert.assertEquals("Pesho bought a hotel.", positionForBuilding.buildHotelOnPosition(players, 0));
    }
    @Test
    public void testBuildHotelOnPositionCheckIfCashChange() {

        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(7);
        int oldCash= (int) players.get(1).getCash();
        int priceHotel=positionForBuilding.getBuyAHotel();
        positionForBuilding.buildHotelOnPosition(players,1);
        int newCash= (int) players.get(1).getCash();
        Assert.assertTrue("Method doesn't return expected value",(oldCash==newCash+priceHotel));

    }


}
