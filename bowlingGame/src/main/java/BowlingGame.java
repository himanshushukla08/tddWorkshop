public class BowlingGame {

    public int score(String rolls) {
        int score = 0;

        for (Character character : rolls.toCharArray()) {
            try {
                Integer roll = Integer.valueOf(character.toString());
                score += roll;
            } catch (NumberFormatException exception) {

            }
        }
        return score;
    }
}
