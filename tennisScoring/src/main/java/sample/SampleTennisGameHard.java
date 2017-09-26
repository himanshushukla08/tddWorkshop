package sample;

public class SampleTennisGameHard implements ISampleTennisGame {
    
    private Player playerOne;
    private Player playerTwo;

    public SampleTennisGameHard(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
    }

    public String getScore() {
        String s;
        if (playerOne.getPoints() < 4 && playerTwo.getPoints() < 4 && 
                !(playerOne.getPoints() + playerTwo.getPoints() == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[playerOne.getPoints()];
            return (playerOne.getPoints() == playerTwo.getPoints()) ? s + 
                    "-All" : s + "-" + p[playerTwo.getPoints()];
        } else {
            if (playerOne.getPoints() == playerTwo.getPoints())
                return "Deuce";
            s = playerOne.getPoints() > playerTwo.getPoints() ? playerOne.getName() : playerTwo.getName();
            return ((playerOne.getPoints()-playerTwo.getPoints())*(playerOne.getPoints()-playerTwo.getPoints()) == 1) 
                    ? "Advantage " + s 
                    : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.getName()))
            playerOne.score();
        else
            playerTwo.score();
        
    }

}
