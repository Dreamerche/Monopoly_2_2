import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAskForPayingTheBankAndGetFree {
    @Test

    public void askForPayingTheBankAndGetFree(List<Player> players, int i) {
        List<Player> players1 = new ArrayList<>();
        players1.add(new Player("Pesho"));
        players1.add(new Player("Gosho"));

        players1.get(1).setCash(49.99);
        //String option=askForPayingTheBankAndGetFree (players1,0);

    }
}