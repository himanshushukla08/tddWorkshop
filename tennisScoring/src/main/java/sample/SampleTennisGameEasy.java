package sample;

import static sample.SampleTennisGameEasy.ScoringUtility.*;

public class SampleTennisGameEasy implements ISampleTennisGame {
    private Player playerOne;
    private Player playerTwo;

    public SampleTennisGameEasy(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public String getScore() {
        String score = "";

        if (isAllScore(playerOne, playerTwo))
            score = buildResponse(playerOne) + "-All";

        if (isDeuce(playerOne, playerTwo))
            score = "Deuce";

        if (isAhead(playerOne, playerTwo))
            score = buildScore(buildResponse(playerOne), buildResponse(playerTwo));

        if (hasAdvantage(playerOne, playerTwo))
            score = "Advantage " + retrieveWinner(playerOne, playerTwo).getName();

        if (hasWinner(playerOne, playerTwo))
            score = "Win for " + retrieveWinner(playerOne, playerTwo).getName();

        return score;
    }

    private Player retrieveWinner(Player playerOne, Player playerTwo) {
        if (playerOne.getPoints() > playerTwo.getPoints()) {
            return playerOne;
        }
        if (playerTwo.getPoints() > playerOne.getPoints()) {
            return playerTwo;
        }
        return null;
    }

    private String buildScore(String playerOneResponse, String playerTwoResponse) {
        return playerOneResponse + "-" + playerTwoResponse;
    }

    private String buildResponse(Player player) {
        String playerResponse = "";
        if (player.getPoints() == 0)
            playerResponse = "Love";
        if (player.getPoints() == 1)
            playerResponse = "Fifteen";
        if (player.getPoints() == 2)
            playerResponse = "Thirty";
        if (player.getPoints() == 3)
            playerResponse = "Forty";
        return playerResponse;
    }


    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.getName()))
            playerOne.score();
        else
            playerTwo.score();
    }

    public static class ScoringUtility {
        public static boolean isAhead(Player playerOne, Player playerTwo) {
            return playerOne.getPoints() != playerTwo.getPoints() && playerOne.getPoints() < 4;
        }

        public static boolean hasAdvantage(Player playerOne, Player playerTwo) {
            return isAdvantage(playerOne.getPoints(), playerTwo.getPoints()) ||
                    isAdvantage(playerTwo.getPoints(), playerOne.getPoints());
        }

        public static boolean hasWinner(Player playerOne, Player playerTwo) {
            return hasWon(playerOne.getPoints(), playerTwo.getPoints()) ||
                    hasWon(playerTwo.getPoints(), playerOne.getPoints());
        }

        public static boolean isDeuce(Player playerOne, Player playerTwo) {
            return playerOne.getPoints() == playerTwo.getPoints() && playerOne.getPoints() >= 3;
        }

        public static boolean isAllScore(Player playerOne, Player playerTwo) {
            return playerOne.getPoints() == playerTwo.getPoints() && playerOne.getPoints() < 4;
        }

        private static boolean isAdvantage(int playerPoint, int comparisonPoint) {
            return playerPoint > comparisonPoint && comparisonPoint >= 3;
        }

        private static boolean hasWon(int playerPoint, int comparisonPoint) {
            return isAtLeastFourPointGame(playerPoint, comparisonPoint) && isAheadByAtLeastFour(playerPoint, comparisonPoint);
        }

        private static boolean isAheadByAtLeastFour(int playerPoint, int comparisonPoint) {
            return (playerPoint - comparisonPoint) >= 2;
        }

        private static boolean isAtLeastFourPointGame(int playerPoint, int comparisonPoint) {
            return playerPoint >= 4 && comparisonPoint >= 0;
        }
    }
}