public class BowlingGame {

    public int score(String rolls) {
        int score = 0;
        int previousScore = 0;
        boolean hasSpare = false;

        for (Character character : rolls.toCharArray()) {
            try {
                int currentScore = Integer.valueOf(character.toString());

                if (hasSpare) {
                    score += previousScore;
                }

                score += currentScore;
                previousScore = currentScore;
            } catch (NumberFormatException exception) {
                if ("X".equals(character.toString())) {
                    score += 10;
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
