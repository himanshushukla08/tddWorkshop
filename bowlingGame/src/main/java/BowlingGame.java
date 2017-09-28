public class BowlingGame {

    public int score(String rolls) {
        int score = 0;

        for (Character character : rolls.toCharArray()) {
            try {
                score += Integer.valueOf(character.toString());
            } catch (NumberFormatException exception) {
                if ("X".equals(character.toString())) {
                    score += 10;
                }
            }
        }
        return score;
    }
}
