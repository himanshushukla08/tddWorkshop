package sample;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

@RunWith(Parameterized.class)
public class SampleTennisGameMediumTest extends SampleBaseTennisTest {

    public SampleTennisGameMediumTest(int player1Score, int player2Score, String expectedScore) {
        super(player1Score, player2Score, expectedScore, SampleTennisGameMedium::new);
    }

    @Parameters(name = " {0}-{1} is {2} ")
    public static Collection<Object[]> getAllScores() {
        return SampleTestData.getTestCases();
    }

}