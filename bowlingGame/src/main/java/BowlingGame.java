import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BowlingGame {

    int scoreOneBack = 0;
    int scoreTwoBack = 0;

    public int score(String rolls) {

        int position = 0;
        int score = 0;
        boolean hasSpare = false;

        for (String stringScore : reverse(rolls)) {
            try {
                int currentScore = Integer.valueOf(stringScore);

                if (!hasSpare) {
                    score += currentScore;
                } else {
                    hasSpare = false;
                }

                trackPreviousScores(currentScore);

            } catch (NumberFormatException exception) {
                if ("X".equals(stringScore)) {
                    if (position >= 3) {
                        score += scoreOneBack;
                        score += scoreTwoBack;
                    }
                    score += 10;
                    trackPreviousScores(10);
                }
                if ("/".equals(stringScore)) {
                    score += 10;
                    if (position >= 3) {
                        score += scoreOneBack;
                    }
                    hasSpare = true;
                }
            }
            position++;
        }
        return score;
    }

    private void trackPreviousScores(int currentScore) {
        scoreTwoBack = scoreOneBack;
        scoreOneBack = currentScore;
    }

    private List<String> reverse(String rolls) {
        ArrayList<String> scores = new ArrayList<>();

        for (Character character : rolls.toCharArray()) {
            scores.add(Character.toString(character));
        }

        Collections.reverse(scores);
        return scores;
    }
}
