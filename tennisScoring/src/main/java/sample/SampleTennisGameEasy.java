package sample;

public class SampleTennisGameEasy implements ISampleTennisGame
{

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

        if (isAhead(playerOne, playerTwo))
            score = buildScore(buildResponse(playerOne), buildResponse(playerTwo));

        if (hasAdvantage(playerOne, playerTwo))
            score = "Advantage " + retrieveWinner(playerOne, playerTwo).getName();

        if (hasWinner(playerOne, playerTwo))
            score = "Win for " + retrieveWinner(playerOne, playerTwo).getName();

        return score;
    }

    private boolean isAhead(Player playerOne, Player playerTwo) {
        return playerOne.getPoints() != playerTwo.getPoints() && playerOne.getPoints() < 4;
    }

    private boolean hasAdvantage(Player playerOne, Player playerTwo){
        return isAdvantage(playerOne.getPoints(), playerTwo.getPoints()) ||
                isAdvantage(playerTwo.getPoints(), playerOne.getPoints());
    }

    private boolean hasWinner(Player playerOne, Player playerTwo){
        return hasWon(playerOne.getPoints(), playerTwo.getPoints()) ||
                hasWon(playerTwo.getPoints(), playerOne.getPoints());
    }

    private Player retrieveWinner(Player playerOne, Player playerTwo) {
        if(playerOne.getPoints() > playerTwo.getPoints()){
            return playerOne;
        }
        if(playerTwo.getPoints() > playerOne.getPoints()){
            return playerTwo;
        }
        return null;
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

    private String buildScore(String playerOneResponse, String playerTwoResponse) {
        return playerOneResponse + "-" + playerTwoResponse;
    }

    private String buildResponse(Player player) {
        String playerResponse = "";
        if (player.getPoints() ==0)
            playerResponse = "Love";
        if (player.getPoints() ==1)
            playerResponse = "Fifteen";
        if (player.getPoints() ==2)
            playerResponse = "Thirty";
        if (player.getPoints() ==3)
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