package sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleRockPaperScissorsGameTest {

    @Test
    public void rockCrushesScissors() {
        SampleRockPaperScissorsGame game = new SampleRockPaperScissorsGame();

        assertEquals("rock beats scissors", game.determineWinner("rock", "scissors"));
    }
}
