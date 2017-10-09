package sample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleRockPaperScissorsGameTest {

    private SampleRockPaperScissorsGame game;

    @Before
    public void setUp() {
        game = new SampleRockPaperScissorsGame();
    }

    @Test
    public void rockCrushesScissors() {
        assertEquals("rock beats scissors", game.determineWinner("rock", "scissors"));
    }

    @Test
    public void paperWrapsRockes() {
        assertEquals("paper beats rock", game.determineWinner("paper", "rock"));
    }

    @Test
    public void scissorsCutPaper() {
        assertEquals("scissors beats paper", game.determineWinner("scissors", "paper"));
    }

    @Test
    public void scissorsOnlyGoesAgain() {
        assertEquals("go again", game.determineWinner("scissors", "scissors"));
    }
}
