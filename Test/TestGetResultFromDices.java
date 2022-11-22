import org.junit.Assert;
import org.junit.Test;

public class TestGetResultFromDices {

    @Test
    public void testGetResultFromDices(){

        Player player= new Player("Pesho");

        for (int i = 0; i < 10; i++) {

            Assert.assertTrue("Method doesn't return expected value",
                    player.getResultFromDices()>=2 && player.getResultFromDices()<=12);

        }
    }

}
