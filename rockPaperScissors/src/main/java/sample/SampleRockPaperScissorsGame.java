package sample;

public class SampleRockPaperScissorsGame {

    public String determineWinner(String gesture1, String gesture2) {
        if ("paper".equals(gesture1) && "rock".equals(gesture2)) {
            return "paper beats rock";
        }
        return "rock beats scissors";
    }

}
