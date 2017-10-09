import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BowlingGame {

    public static final String STRIKE = "X";
    public static final String SPARE = "/";
    int scoreOneBack = 0;
    int scoreTwoBack = 0;
    int score = 0;

    public int score(String rolls) {

        int position = 0;
        boolean hasSpare = false;

        for (String stringScore : reverse(rolls)) {
            if (isNumeric(stringScore)) {
                int currentScore = Integer.valueOf(stringScore);

                if (hasSpare) {
                    hasSpare = false;
                } else {
                    score += currentScore;
                }

                trackPreviousScores(currentScore);

            } else {
                if (isStrike(stringScore)) {
                    if (beyondBonusFrames(position)) {
                        score += scoreTwoBack;
                        score += scoreOneBack;
                    }

                    score(10);
                }
                if (isSpare(stringScore)) {
                    if (beyondBonusFrames(position)) {
                        score += scoreOneBack;
                    }

                    hasSpare = true;
                    score(10);
                }
            }
            position++;
        }
        return score;
    }

    private void score(int amount) {
        score += amount;
        trackPreviousScores(amount);
    }

    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private boolean isSpare(String stringScore) {
        return SPARE.equals(stringScore);
    }

    private boolean isStrike(String stringScore) {
        return STRIKE.equals(stringScore);
    }

    private boolean beyondBonusFrames(int position) {
        return position >= 3;
    }

    private void trackPreviousScores(int currentScore) {
        scoreTwoBack = scoreOneBack;
        scoreOneBack = currentScore;
    }

    private List<String> reverse(String rolls) {
        List<String> scores = new ArrayList<>();

        for (Character character : rolls.toCharArray()) {
            scores.add(Character.toString(character));
        }

        Collections.reverse(scores);
        return scores;
    }
}
