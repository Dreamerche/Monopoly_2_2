import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestThrowingDices {//method needs to be fixed

    @Test
    public void testThrowingTheDices(){
            Player player=new Player("Pesho");
            String input = "t\n";
            Assert.assertEquals("dices were thrown", player.throwTheDices(new Scanner(input)));
    }
    @Test
    public void testGetResultFromDices(){

        Player player= new Player("Pesho");

        for (int i = 0; i < 100; i++) {
            int result= player.getResultFromDices();
            Assert.assertTrue("Method doesn't return expected value",
                    result>=2 && result<=12);
        }
    }
    @Test
    public void testThrowTheDicesToGetOutOfJail(){
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionPrison positionPrison=new PositionPrison(11);
        List<String> results= Arrays.asList((players.get(1).getName()+" is free"),(players.get(1).getName()+" isn't free"));
        String result=positionPrison.throwTheDicesToGetOutOfJail(players,1);
        Assert.assertTrue(results.contains(result));
    }

}
