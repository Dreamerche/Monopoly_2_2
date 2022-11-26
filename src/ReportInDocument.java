import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportInDocument {
    public void getTheGameResult(List<Player> players) throws IOException {
        String theWinner=getTheWinnerInfo(players);
        String allPlayers=getNamesOfPlayersInfo(players);
        DateTimeFormatter dtf;
        LocalDateTime currentDateTime= LocalDateTime.of(LocalDate.now(),LocalTime.now());
        dtf=DateTimeFormatter.ofPattern("HH:mm d-MM-yy");
        saveTheNewGameData(theWinner,allPlayers,dtf,currentDateTime);
    }
    protected void saveTheNewGameData(String theWinner,String allPlayers, DateTimeFormatter dtf,LocalDateTime currentDateTime) throws IOException {
        String previousInfoFromFile=readFile("playedGames.txt");
        PrintStream fileWriter = new PrintStream("playedGames.txt");
        fileWriter.println(previousInfoFromFile);
        fileWriter.println(theWinner);
        fileWriter.println(allPlayers);
        fileWriter.println(dtf.format(currentDateTime)+"\n\n");
        fileWriter.close();
    }
    protected String readFile(String fileName) throws IOException {
        File file=new File(fileName);
        file.createNewFile();
        BufferedReader reader = new BufferedReader(new FileReader(file.getName()));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
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
        allPlayers+=players.get(players.size()-1).getName();
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
