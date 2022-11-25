import org.junit.Assert;
import org.junit.Test;

public class TestGetResultFromDices {//method needs to be fixed

    @Test
    public void testGetResultFromDices(){

        Player player= new Player("Pesho");

        for (int i = 0; i < 100; i++) {

            Assert.assertTrue("Method doesn't return expected value",
                    player.getResultFromDices()>=2 && player.getResultFromDices()<=12);

        }
    }

}
