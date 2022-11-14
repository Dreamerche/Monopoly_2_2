import java.util.Scanner;

public interface Askably {

    //public void askForPayingTheBankAndGetFree ();

    public static String[][] askForPayingTheBankAndGetFree(String[][] pPAM, int i) {
        Scanner scan = new Scanner(System.in);
        if (Integer.parseInt(pPAM[2][i]) >= 50)//check if the player has 50 money
        {
            while (true) {
                System.out.print("Do you want to pay the bank 50 money and not get in jail?\n" +
                        "Type \"y\" for yes or \"n\" for no:");
                String option = scan.nextLine();
                if (option.equalsIgnoreCase("y")) {
                    pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) - 50);
                    break;
                } else if (option.equalsIgnoreCase("n")) {
                    System.out.println(pPAM[0][i] + " goes to jail.");
                    pPAM[1][i] = Integer.toString(11);
                    break;
                } else {
                    System.out.println("Incorrect input, try again, " + pPAM[0][i] + ".");
                }
            }
        }
        return pPAM;
    }
}
