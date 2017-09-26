package sample;

public class SampleTennisGameEasy implements ISampleTennisGame
{
    public String playerOneResponse = "";
    public String playerTwoResponse = "";

    private Player playerOne = new Player("player1");
    private Player playerTwo = new Player("player2");

    public String getScore(){
        String score = "";
        if (isAllScore())
        {
            if (playerOne.getPoints() ==0)
                score = "Love";
            if (playerOne.getPoints() ==1)
                score = "Fifteen";
            if (playerOne.getPoints() ==2)
                score = "Thirty";
            score += "-All";
        }
        if (isDeuce())
            score = "Deuce";

        if (playerOne.getPoints() != playerTwo.getPoints() && playerOne.getPoints() < 4)
        {
            playerTwoResponse = buildResponse(playerTwo.getPoints(), playerTwoResponse);
            playerOneResponse = buildResponse(playerOne.getPoints(), playerOneResponse);
            score = buildScore();
        }

        if (isAdvantage(playerOne.getPoints(), playerTwo.getPoints()))
        {
            score = "Advantage " + playerOne.getName();
        }

        if (isAdvantage(playerTwo.getPoints(), playerOne.getPoints()))
        {
            score = "Advantage " + playerTwo.getName();
        }

        if (hasWon(playerOne.getPoints(), playerTwo.getPoints()))
        {
            score = "Win for " + playerOne.getName();
        }
        if (hasWon(playerTwo.getPoints(), playerOne.getPoints()))
        {
            score = "Win for " + playerTwo.getName();
        }
        return score;
    }

    private boolean isAdvantage(int playerPoint, int comparisonPoint) {
        return playerPoint > comparisonPoint && comparisonPoint >= 3;
    }

    private boolean hasWon(int playerPoint, int comparisonPoint) {
        return isAtLeastFourPointGame(playerPoint, comparisonPoint) && isAheadByAtLeastFour(playerPoint, comparisonPoint);
    }

    private boolean isAheadByAtLeastFour(int playerPoint, int comparisonPoint) {
        return (playerPoint - comparisonPoint) >= 2;
    }

    private boolean isAtLeastFourPointGame(int playerPoint, int comparisonPoint) {
        return playerPoint >= 4 && comparisonPoint >= 0;
    }

    private boolean isDeuce() {
        return playerOne.getPoints() == playerTwo.getPoints() && playerOne.getPoints() >=3;
    }

    private boolean isAllScore() {
        return playerOne.getPoints() == playerTwo.getPoints() && playerOne.getPoints() < 4;
    }

    private String buildScore() {
        return playerOneResponse + "-" + playerTwoResponse;
    }

    private String buildResponse(int playerPoint, String playerResponse) {
        if (playerPoint ==0)
            playerResponse = "Love";
        if (playerPoint ==1)
            playerResponse = "Fifteen";
        if (playerPoint ==2)
            playerResponse = "Thirty";
        if (playerPoint ==3)
            playerResponse = "Forty";
        return playerResponse;
    }


    public void playerOneScore(){
        playerOne.score();
    }

    public void playerTwoScore(){
        playerTwo.score();
    }

    public void wonPoint(String player) {
        if (player == "player1")
            playerOneScore();
        else
            playerTwoScore();
    }

    private class Player{
        private int points;
        private String name;

        public Player(String name) {
            this.points = 0;
            this.name = name;
        }

        public int getPoints(){
            return points;
        }

        public void score(){
            points++;
        }

        public String getName() {
            return name;
        }
    }
}