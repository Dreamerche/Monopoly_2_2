
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAskForPayingTheBankAndGetFree1 {
    @Test
    public void askForPayingTheBankAndGetFree11() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Pesho"));
        players.add(new Player("Gosho"));
        PositionPrison positionPrison = new PositionPrison(11);
        StringWriter output = new StringWriter();
        String input = "y\n";
        Assert.assertEquals("first scenario", positionPrison.askForPayingTheBankAndGetFree1(new Scanner(input),players,0));

    }

}
