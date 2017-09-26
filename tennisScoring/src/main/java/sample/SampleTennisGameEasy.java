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

        if (isLeadingAgainstLove(playerOnePoint, playerTwoPoint))
        {
            playerOneResponse = lookupBallOneThroughThree(playerOnePoint, playerOneResponse);
            playerTwoResponse = "Love";
            score = buildScore();
        }
        if (isLeadingAgainstLove(playerTwoPoint, playerOnePoint))
        {
            playerTwoResponse = lookupBallOneThroughThree(playerTwoPoint, playerTwoResponse);
            playerOneResponse = "Love";
            score = buildScore();
        }

        if (playerOnePoint != playerTwoPoint && playerOnePoint < 4)
        {
            playerTwoResponse = lookupBallOneThroughThree(playerTwoPoint, playerTwoResponse);
            playerOneResponse = lookupBallOneThroughThree(playerOnePoint, playerOneResponse);
            score = buildScore();
        }

        if (playerOnePoint > playerTwoPoint && playerTwoPoint >= 3)
        {
            score = "Advantage player1";
        }
        
        if (playerTwoPoint > playerOnePoint && playerOnePoint >= 3)
        {
            score = "Advantage player2";
        }
        
        if (playerOnePoint >=4 && playerTwoPoint >=0 && (playerOnePoint - playerTwoPoint)>=2)
        {
            score = "Win for player1";
        }
        if (playerTwoPoint >=4 && playerOnePoint >=0 && (playerTwoPoint - playerOnePoint)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isLeadingAgainstLove(int firstPlayerPoint, int secondPlayerPoint) {
        return firstPlayerPoint > 0 && secondPlayerPoint ==0;
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

    private String lookupBallOneThroughThree(int playerPoint, String playerResponse) {
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