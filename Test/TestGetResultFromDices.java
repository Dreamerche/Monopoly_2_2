import org.junit.Assert;
import org.junit.Test;

public class TestGetResultFromDices {//method needs to be fixed

    @Test
    public void testGetResultFromDices(){

        Player player= new Player("Pesho");

        for (int i = 0; i < 100; i++) {
            int result= player.getResultFromDices();
            Assert.assertTrue("Method doesn't return expected value",
                    result>=2 && result<=12);
        }
    }

}
