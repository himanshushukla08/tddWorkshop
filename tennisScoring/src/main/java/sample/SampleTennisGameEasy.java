package sample;

public class SampleTennisGameEasy implements ISampleTennisGame
{
    public int playerOnePoint = 0;
    public int playerTwoPoint = 0;
    
    public String playerOneResponse = "";
    public String playerTwoResponse = "";

    public String getScore(){
        String score = "";
        if (isAllScore())
        {
            if (playerOnePoint ==0)
                score = "Love";
            if (playerOnePoint ==1)
                score = "Fifteen";
            if (playerOnePoint ==2)
                score = "Thirty";
            score += "-All";
        }
        if (isDeuce())
            score = "Deuce";

        if (playerOnePoint != playerTwoPoint && playerOnePoint < 4)
        {
            playerTwoResponse = buildResponse(playerTwoPoint, playerTwoResponse);
            playerOneResponse = buildResponse(playerOnePoint, playerOneResponse);
            score = buildScore();
        }

        if (isAdvantage(playerOnePoint, playerTwoPoint))
        {
            score = "Advantage player1";
        }
        
        if (isAdvantage(playerTwoPoint, playerOnePoint))
        {
            score = "Advantage player2";
        }
        
        if (hasWon(playerOnePoint, playerTwoPoint))
        {
            score = "Win for player1";
        }
        if (hasWon(playerTwoPoint, playerOnePoint))
        {
            score = "Win for player2";
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
        return playerOnePoint == playerTwoPoint && playerOnePoint >=3;
    }

    private boolean isAllScore() {
        return playerOnePoint == playerTwoPoint && playerOnePoint < 4;
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
        playerOnePoint++;
    }
    
    public void playerTwoScore(){
        playerTwoPoint++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            playerOneScore();
        else
            playerTwoScore();
    }
}