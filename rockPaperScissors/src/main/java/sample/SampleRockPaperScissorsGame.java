package sample;

public class SampleRockPaperScissorsGame {

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";

    public String determineWinner(String gestureOne, String gestureTwo) {
        if (PAPER.equals(gestureOne) && ROCK.equals(gestureTwo)) {
            return createMessage(gestureOne, gestureTwo);
        }
        if (SCISSORS.equals(gestureOne) && PAPER.equals(gestureTwo)) {
            return createMessage(gestureOne, gestureTwo);
        }
        return createMessage(ROCK, SCISSORS);
    }

    private String createMessage(String gestureOne, String gestureTwo) {
        return gestureOne + " beats " + gestureTwo;
    }

}
