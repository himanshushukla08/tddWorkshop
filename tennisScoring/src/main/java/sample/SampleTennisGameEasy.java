package sample;

public class SampleTennisGameEasy implements ISampleTennisGame
{
    public int playerOnePoint = 0;
    public int playerTwoPoint = 0;
    
    public String playerOneResponse = "";
    public String playerTwoResponse = "";

    public String getScore(){
        String score = "";
        if (playerOnePoint == playerTwoPoint && playerOnePoint < 4)
        {
            if (playerOnePoint ==0)
                score = "Love";
            if (playerOnePoint ==1)
                score = "Fifteen";
            if (playerOnePoint ==2)
                score = "Thirty";
            score += "-All";
        }
        if (playerOnePoint == playerTwoPoint && playerOnePoint >=3)
            score = "Deuce";
        
        if (playerOnePoint > 0 && playerTwoPoint ==0)
        {
            if (playerOnePoint ==1)
                playerOneResponse = "Fifteen";
            if (playerOnePoint ==2)
                playerOneResponse = "Thirty";
            if (playerOnePoint ==3)
                playerOneResponse = "Forty";
            
            playerTwoResponse = "Love";
            score = playerOneResponse + "-" + playerTwoResponse;
        }
        if (playerTwoPoint > 0 && playerOnePoint ==0)
        {
            if (playerTwoPoint ==1)
                playerTwoResponse = "Fifteen";
            if (playerTwoPoint ==2)
                playerTwoResponse = "Thirty";
            if (playerTwoPoint ==3)
                playerTwoResponse = "Forty";
            
            playerOneResponse = "Love";
            score = playerOneResponse + "-" + playerTwoResponse;
        }
        
        if (playerOnePoint > playerTwoPoint && playerOnePoint < 4)
        {
            if (playerOnePoint ==2)
                playerOneResponse ="Thirty";
            if (playerOnePoint ==3)
                playerOneResponse ="Forty";
            if (playerTwoPoint ==1)
                playerTwoResponse ="Fifteen";
            if (playerTwoPoint ==2)
                playerTwoResponse ="Thirty";
            score = playerOneResponse + "-" + playerTwoResponse;
        }
        if (playerTwoPoint > playerOnePoint && playerTwoPoint < 4)
        {
            if (playerTwoPoint ==2)
                playerTwoResponse ="Thirty";
            if (playerTwoPoint ==3)
                playerTwoResponse ="Forty";
            if (playerOnePoint ==1)
                playerOneResponse ="Fifteen";
            if (playerOnePoint ==2)
                playerOneResponse ="Thirty";
            score = playerOneResponse + "-" + playerTwoResponse;
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
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            playerOneScore();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            playerTwoScore();
        }
            
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