import java.util.List;

public class Position implements Playable {
    protected int numberPosition;

    public Position(int numberPosition) {
        this.numberPosition = numberPosition;
    }

    public int getNumberPosition() {
        return numberPosition;
    }

    public void setNumberPosition(int numberPosition) {
        this.numberPosition = numberPosition;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "numberPosition=" + numberPosition +
                '}';
    }

    @Override
    public void seeWhatThePositionOffersOrTakes(List<Player> players, int i, List<Position> positions) {
        //will be used by the children with overriding in addition to their needs
    }

}
