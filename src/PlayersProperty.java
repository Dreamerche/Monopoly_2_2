import java.util.List;

public class PlayersProperty {
    public String getPlayersPropertyInformation(int i, List<PositionForBuilding> positionForBuildings){
        System.out.println("Positions:"+showPositionsOfAPlayer(i,positionForBuildings));
        System.out.println("Houses:   "+showHousesOfThePlayersPositions(i,positionForBuildings));
        System.out.println();
        return "All information is shown";
    }
    protected String showPositionsOfAPlayer(int i, List<PositionForBuilding> positionForBuildings){
        String savedPositionsNumberInfo = "";
        for (int j = 0; j < positionForBuildings.size(); j++) {
            if(positionForBuildings.get(j).getOwner()==i){
                savedPositionsNumberInfo+=(" "+positionForBuildings.get(j).getNumberPosition()+" |");
            }
        }
        return savedPositionsNumberInfo;
    }
    protected String showHousesOfThePlayersPositions(int i, List<PositionForBuilding> positionForBuildings){
        String savedPositionsHousesInfo = "";
        for (int j = 0; j < positionForBuildings.size(); j++) {
            if(positionForBuildings.get(j).getOwner()==i){
                savedPositionsHousesInfo+=(" "+positionForBuildings.get(j).getAmountOfHouses()+" |");
            }
        }
        return savedPositionsHousesInfo;
    }
    protected String showHotelsOfThePlayersPositions(int i, List<PositionForBuilding> positionForBuildings){
        String savedPositionsHotelsInfo = "";
        for (int j = 0; j < positionForBuildings.size(); j++) {
            if(positionForBuildings.get(j).getOwner()==i){
                savedPositionsHotelsInfo+=(" "+positionForBuildings.get(j).getAmountOfHotels()+" |");
            }
        }
        return savedPositionsHotelsInfo;
    }
}
