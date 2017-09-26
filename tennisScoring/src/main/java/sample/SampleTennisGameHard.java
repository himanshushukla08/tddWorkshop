package sample;

public class SampleTennisGameHard implements ISampleTennisGame {
    
    private Player playerOne;
    private Player playerTwo;

    public SampleTennisGameHard(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
    }

    public String getScore() {
        String[] pointTranslations = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        if (isLessThanFour(playerOne, playerTwo) && totalScoreLessThanSix()) {
            return (isTied(playerOne, playerTwo))
                    ? pointTranslations[playerOne.getPoints()] + "-All"
                    : pointTranslations[playerOne.getPoints()] + "-" + pointTranslations[playerTwo.getPoints()];
        } else {
            if (isTied(playerOne, playerTwo)) return "Deuce";
            return isAdvantage() ? "Advantage " + retrieveWinnersName() : "Win for " + retrieveWinnersName();
        }
    }

    private boolean totalScoreLessThanSix() {
        return !(playerOne.getPoints() + playerTwo.getPoints() >= 6);
    }

    private boolean isAdvantage() {
        return (playerOne.getPoints() - playerTwo.getPoints()) * (playerOne.getPoints() - playerTwo.getPoints()) == 1;
    }

    private String retrieveWinnersName() {
        return playerOne.getPoints() > playerTwo.getPoints() ? playerOne.getName() : playerTwo.getName();
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
