package sample;

public class SampleTennisGameHard implements ISampleTennisGame {
    
    private Player playerOne;
    private Player playerTwo;

    public SampleTennisGameHard(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
    }

    public String getScore() {
        String message;
        String[] pointTranslations = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        if (isLessThanFour(playerOne, playerTwo) &&
                !(playerOne.getPoints() + playerTwo.getPoints() == 6)) {
            message = pointTranslations[playerOne.getPoints()];
            return (isTied(playerOne, playerTwo)) ? message +
                    "-All" : message + "-" + pointTranslations[playerTwo.getPoints()];
        } else {
            if (isTied(playerOne, playerTwo))
                return "Deuce";
            message = playerOne.getPoints() > playerTwo.getPoints() ? playerOne.getName() : playerTwo.getName();
            return ((playerOne.getPoints()-playerTwo.getPoints())*(playerOne.getPoints()-playerTwo.getPoints()) == 1) 
                    ? "Advantage " + message
                    : "Win for " + message;
        }
    }

    private boolean isLessThanFour(Player playerOne, Player playerTwo) {
        return playerOne.getPoints() < 4 && playerTwo.getPoints() < 4;
    }

    private boolean isTied(Player playerOne, Player playerTwo) {
        return playerOne.getPoints() == playerTwo.getPoints();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.getName()))
            playerOne.score();
        else
            playerTwo.score();
        
    }

}
