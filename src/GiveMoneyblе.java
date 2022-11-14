public interface GiveMoneyblе {

    static String[][] giveMoneyToThePlayer(String[][] pPAM, int i, int[][] pWCBBO, int j, int[][] prices) {
        int sum = prices[2][0] + (prices[2][1] * pWCBBO[2][j]) + (prices[2][2] * pWCBBO[3][j]);
        pPAM[2][i] = Integer.toString(Integer.parseInt(pPAM[2][i]) + sum);
        return pPAM;
    }

}
