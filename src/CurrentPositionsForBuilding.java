import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CurrentPositionsForBuilding {
    public List<PositionForBuilding> getPositionsForBuildingWithOwners(List<Player> players,List<Position>positions){
        List<PositionForBuilding> positionsWithOwners=new ArrayList<PositionForBuilding>();
        for (Position position:positions) {
            positionsWithOwners.add(getPositionForBuildingWithPlayerForOwner(position));
        }
        positionsWithOwners.removeIf(Objects::isNull);//removes null elements from the list
        return positionsWithOwners;
    }
    protected PositionForBuilding getPositionForBuildingWithPlayerForOwner(Object position){
        if (position instanceof PositionForBuilding) {
            if(((PositionForBuilding) position).getOwner()!=-1){
                return (PositionForBuilding)position;
            }
            else {
                return null;
            }
        }
        else{
            return null;
        }
    }

}
