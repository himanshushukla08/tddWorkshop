public class BowlingGame {

    public int score(String rolls) {
        int score = 0;
        int previousScore = 0;
        boolean hasSpare = false;
        boolean hasStrike = false;
        int bonusRollCount = 0;

        for (Character character : rolls.toCharArray()) {
            try {
                int currentScore = Integer.valueOf(character.toString());

                if (hasSpare) {
                    score += previousScore;
                }
                if (hasStrike && (bonusRollCount < 2)) {
                    score += currentScore;
                } else {
                    bonusRollCount = 0;
                }

                score += currentScore;
                previousScore = currentScore;
            } catch (NumberFormatException exception) {
                if ("X".equals(character.toString())) {
                    score += 10;
                    hasStrike = true;
                }
                if ("/".equals(character.toString())) {
                    score += (10 - previousScore);
                    hasSpare = true;
                }
            }
        }
        return score;
    }
}
