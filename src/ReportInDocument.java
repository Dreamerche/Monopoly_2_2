import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportInDocument {

    public void getTheGameResult(List<Player> players) throws IOException {
        String theWinner=getTheWinnerInfo(players);
        String allPlayers=getNamesOfPlayersInfo(players);
        DateTimeFormatter dtf;
        LocalDateTime currentDateTime= LocalDateTime.of(LocalDate.now(),LocalTime.now());
        dtf=DateTimeFormatter.ofPattern("HH:mm d-MM-yy");
        String previousInfoFromFile=readFile("playedGames.txt");
        saveTheNewGameData("playedGames.txt",previousInfoFromFile,theWinner,allPlayers,dtf,currentDateTime);

    }
    protected void saveTheNewGameData(String fileName,String previousInfoFromFile,String theWinner,String allPlayers, DateTimeFormatter dtf,LocalDateTime currentDateTime) throws FileNotFoundException {
        PrintStream fileWriter = new PrintStream(fileName);
        fileWriter.print(previousInfoFromFile);
        fileWriter.println(theWinner);
        fileWriter.println(allPlayers);
        fileWriter.println(dtf.format(currentDateTime)+"\n");
        fileWriter.close();
    }
    private String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    protected String getNamesOfPlayersInfo(List<Player>players){
        String allPlayers=("The players in this game were ");
        for (int i = 0; i < players.size()-1; i++) {
            allPlayers+=(players.get(i).getName()+", ");
        }
        allPlayers+=players.get(players.size()-1);
        return allPlayers;//using this in unit tests
    }
    protected String getTheWinnerInfo(List<Player>players){
        for (Player player:players) {
            if(!player.isHasBankrupted()){
                return ("The winner is "+player.getName());
            }
        }
        return ("There's no winner");//using this in unit tests
    }
}
