package sample;

public class SampleTennisGameMedium implements ISampleTennisGame {

    private Player playerOne;
    private Player playerTwo;

    public SampleTennisGameMedium(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.getName()))
            playerOne.score();
        else
            playerTwo.score();
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOne.getPoints();
            else {
                score += "-";
                tempScore = playerTwo.getPoints();
            }
            score = calculateScore(score, tempScore);
        }
        if (isTied(playerOne, playerTwo)) score = calculateTiedScore();
        if (hasAdvantage()) score = "Advantage " + winningPlayerName();
        if (hasWinner()) score = "Win for " + winningPlayerName();
        return score;
    }

    private String winningPlayerName(){
        if(playerOne.getPoints() > playerTwo.getPoints()){
            return playerOne.getName();
        }else{
            return playerTwo.getName();
        }
    }

    private boolean hasWinner() {
        return atLeastOnePlayerHasFourPoints() && (minusResult() >= 2 || minusResult() <=-2);
    }

    private boolean hasAdvantage() {
        return atLeastOnePlayerHasFourPoints() && (minusResult() == 1 || minusResult() == -1);
    }

    private int minusResult() {
        return playerOne.getPoints() - playerTwo.getPoints();
    }

    private boolean atLeastOnePlayerHasFourPoints() {
        return playerOne.getPoints() >= 4 || playerTwo.getPoints() >= 4;
    }

    private String calculateScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private String calculateTiedScore() {
        String score;
        switch (playerOne.getPoints()) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private boolean isTied(Player playerOne, Player playerTwo) {
        return playerOne.getPoints() == playerTwo.getPoints();
    }
}
