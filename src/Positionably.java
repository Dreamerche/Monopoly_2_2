public interface Positionably {
    public void getOnNewPosition();

    static int getOnNewPosition(String playerPosition, int[][] p) {
        int a = -1;
        for (int i = 0; i < p[0].length; i++) {
            if (Integer.parseInt(playerPosition) == p[0][i]) {
                a = i;
                break;
            }
        }
        return a;
    }
}
