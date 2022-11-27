import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestBuying {
    @Test
    public void testByuAPosition() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(17);
        String input = "y\n";
        Assert.assertEquals(true, positionForBuilding.askForBuyingThePlace(new Scanner(input),players,0));
        System.out.println();
    }
    @Test
    public void testByuAPosition2() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(17);
        String input = "n\n";
        Assert.assertEquals(false, positionForBuilding.askForBuyingThePlace(new Scanner(input),players,0));
        System.out.println();
    }
    @Test
    public void testByuAHouse() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(17);
        String input = "y\n";
        Assert.assertEquals(true, positionForBuilding.askForBuyingAHouse(new Scanner(input),players,1));
        System.out.println();
    }
    @Test
    public void testByuAHouse2() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(17);
        String input = "n\n";
        Assert.assertEquals(false, positionForBuilding.askForBuyingAHouse(new Scanner(input),players,1));
        System.out.println();
    }
    @Test
    public void testByuAHotel() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(17);
        String input = "y\n";
        Assert.assertEquals(true, positionForBuilding.askForBuyingAHotel(new Scanner(input),players,1));
        System.out.println();
    }
    @Test
    public void testByuAHotel2() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionForBuilding positionForBuilding = new PositionForBuilding(17);
        String input = "n\n";
        Assert.assertEquals(false, positionForBuilding.askForBuyingAHotel(new Scanner(input),players,1));
        System.out.println();
    }
}
