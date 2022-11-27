import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPayTheOwner {
    /* public String payTheOwner(List<Player> players, int i) {
        int sum = rentAPosition + (rentAHouse * amountOfHouses) + (rentAHotel * amountOfHotels);
        players.get(owner).setCash(players.get(getOwner()).getCash() + sum);
        players.get(i).setCash(players.get(i).getCash() - sum);
        return (players.get(i).getName() + " gave " + sum + " rent to " + players.get(owner).getName() + ".");
    }*/

    @Test
    public void testPayTheOwner1() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(10);
        positionForBuilding.setOwner(0);
        int pricePosition= positionForBuilding.getRentAPosition();
        int priceHouse= positionForBuilding.getRentAHouse();
        int priceHotel= positionForBuilding.getRentAHotel();
               int rent=pricePosition+priceHouse*positionForBuilding.getAmountOfHouses()+priceHotel*positionForBuilding.getAmountOfHotels();

        Assert.assertEquals("Gosho gave "+rent+" rent to Pesho.",positionForBuilding.payTheOwner(players,1));
    }

    @Test
    public void testPayTheOwner2() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(10);
        positionForBuilding.setOwner(0);
        positionForBuilding.setAmountOfHouses(4);
        positionForBuilding.setAmountOfHotels(1);
        int pricePosition= positionForBuilding.getRentAPosition();
        int priceHouse= positionForBuilding.getRentAHouse();
        int priceHotel= positionForBuilding.getRentAHotel();

        int oldCash= (int) players.get(1).getCash();

        positionForBuilding.payTheOwner(players,1);
        int newCash= (int) players.get(1).getCash();
        int rent=pricePosition+priceHouse*positionForBuilding.getAmountOfHouses()+priceHotel*positionForBuilding.getAmountOfHotels();
        boolean check=(oldCash==newCash+rent);
        Assert.assertTrue("Method doesn't return expected value", check);
    }

    @Test
    public void testPayTheOwner3() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(10);
        positionForBuilding.setOwner(0);
        positionForBuilding.setAmountOfHouses(3);
        positionForBuilding.setAmountOfHotels(0);
        int pricePosition= positionForBuilding.getRentAPosition();
        int priceHouse= positionForBuilding.getRentAHouse();
        int priceHotel= positionForBuilding.getRentAHotel();

        int oldCash= (int) players.get(1).getCash();

        positionForBuilding.payTheOwner(players,1);
        int newCash= (int) players.get(1).getCash();
        int rent=pricePosition+priceHouse*positionForBuilding.getAmountOfHouses()+priceHotel*positionForBuilding.getAmountOfHotels();
        boolean check=(oldCash==newCash+rent);
        Assert.assertTrue("Method doesn't return expected value", check);
    }

    @Test
    public void testPayTheOwner4() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(10);
        positionForBuilding.setOwner(0);
        positionForBuilding.setAmountOfHouses(-1);
        positionForBuilding.setAmountOfHotels(2);
        int pricePosition= positionForBuilding.getRentAPosition();
        int priceHouse= positionForBuilding.getRentAHouse();
        int priceHotel= positionForBuilding.getRentAHotel();

        int oldCash= (int) players.get(1).getCash();

        positionForBuilding.payTheOwner(players,1);
        int newCash= (int) players.get(1).getCash();
        int rent=pricePosition+priceHouse*positionForBuilding.getAmountOfHouses()+priceHotel*positionForBuilding.getAmountOfHotels();
        boolean check=(oldCash==newCash+rent);
        Assert.assertTrue("Method doesn't return expected value", check);
    }

    @Test
    public void testPayTheOwner5 (){
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(10);
        positionForBuilding.setOwner(0);
        positionForBuilding.setAmountOfHouses(0);
        positionForBuilding.setAmountOfHotels(0);
        int pricePosition= positionForBuilding.getRentAPosition();
        int priceHouse= positionForBuilding.getRentAHouse();
        int priceHotel= positionForBuilding.getRentAHotel();

        int oldCash= (int) players.get(1).getCash();

        positionForBuilding.payTheOwner(players,1);
        int newCash= (int) players.get(1).getCash();
        int rent=pricePosition+priceHouse*positionForBuilding.getAmountOfHouses()+priceHotel*positionForBuilding.getAmountOfHotels();
        boolean check=(oldCash==newCash+rent);
        Assert.assertTrue("Method doesn't return expected value", check);
    }
}
