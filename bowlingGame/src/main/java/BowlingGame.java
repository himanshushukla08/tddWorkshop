public class BowlingGame {

    public int score(String rolls) {
        int score = 0;
        int previousScore = 0;

        for (Character character : rolls.toCharArray()) {
            try {
                previousScore = Integer.valueOf(character.toString());
                score += previousScore;
            } catch (NumberFormatException exception) {
                if ("X".equals(character.toString())) {
                    score += 10;
                }
                if ("/".equals(character.toString())) {
                    score += (10 - previousScore);
                }
            }
        }
        return score;
    }
}
