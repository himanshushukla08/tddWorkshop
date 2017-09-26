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
        if (playerOne.getPoints() == playerTwo.getPoints()) {
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
        } else if (playerOne.getPoints() >= 4 || playerTwo.getPoints() >= 4) {
            int minusResult = playerOne.getPoints() - playerTwo.getPoints();
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = playerOne.getPoints();
                else {
                    score += "-";
                    tempScore = playerTwo.getPoints();
                }
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
            }
        }
        return score;
    }
}
