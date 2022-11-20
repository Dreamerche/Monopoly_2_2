import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.junit.Test;
import java.util.Scanner;

public class TestaskForPayingTheBankAndGetFree {
    Scanner scan = new Scanner(System.in);



//    assertTrue-First
//    public class CalculatorTest {
//        private Calculator calc = new Calculator();

//        //in this case test passes
//        @Test
//        public void testAreEqualWhenInputNumbersAreSame(){
//            Assert.assertTrue(“Method doesn’t
//            return expected value”, calc.areEqual(1, 1));
//        }
//    assertFalse(String message, boolean condition) - за проверка дали дадено условие е лъжа
//    assertNull(String message, Object o) - за проверка дали даден обект е Null
//    assertNotNull(String message, Object o) - за проверка дали даден обект не е Null
//    assertArrayEquals(String message, expected, actual) - за сравнение на масиви по дължина и съдържание
//    assertEquals(String message, double expected, double actual, double delta) - за сравнение на
//    double, delta - точност след запетаята
        //@Test
         ///public void givenRadius_whenCalculateArea_thenReturnArea() {
         //    double actualArea = Circle.calculateArea(1d);
         ///    double expectedArea = 3.141592653589793;
        ///    Assert.assertEquals(expectedArea, actualArea);
        ///}
            //@Test
            //public void givenRadius_whenCalculateArea_thenReturnArea() {
            //    double actualArea = Circle.calculateArea(2d);
            //    double expectedArea = 3.141592653589793 * 2 * 2;
            //    Assert.assertEquals(expectedArea, actualArea);
            //}


    }




//    public void askForPayingTheBankAndGetFree(List<Player> players, int i) {
//        Scanner scan = new Scanner(System.in);
//        if (players.get(i).getCash() >= 50.0)//check if the player has 50 money
//        {
//            while (true) {
//                System.out.print("Do you want to pay the bank 50 money and not get in jail?\n" +
//                        "Type \"y\" for yes or \"n\" for no:");
//                String option = scan.nextLine();
//
//                if (option.equalsIgnoreCase("y")) {
//                   players.get(i).setCash(players.get(i).getCash() - 50);
//                    break;
//                } else if (option.equalsIgnoreCase("n")) {
//                    System.out.println(players.get(i).getName() + " goes to jail.");
//                    players.get(i).setCurrentPosition(11);
//                    players.get(i).setBeingInJail(true);
//                    break;
//                } else {
//                    System.out.println("Incorrect input, try again, " + players.get(i).getName() + ".");
//}

                }
