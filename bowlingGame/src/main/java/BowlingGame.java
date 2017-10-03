import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BowlingGame {

    public int score(String rolls) {
        int score = 0;
        boolean hasSpare = false;
        int scoreOneBack = 0;
        int scoreTwoBack = 0;

        for (String stringScore : reverse(rolls)) {
            try {
                int currentScore = Integer.valueOf(stringScore);

                if (!hasSpare) {
                    score += currentScore;
                } else {
                    hasSpare = false;
                }

                scoreTwoBack = scoreOneBack;
                scoreOneBack = currentScore;
            } catch (NumberFormatException exception) {
                if ("X".equals(stringScore)) {
                    score += scoreOneBack;
                    score += scoreTwoBack;
                    score += 10;
                }
                if ("/".equals(stringScore)) {
                    score += 10;
                    score += scoreOneBack;
                    hasSpare = true;
                }
            }
        }
        return score;
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
