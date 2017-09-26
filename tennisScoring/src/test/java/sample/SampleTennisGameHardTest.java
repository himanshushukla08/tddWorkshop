package sample;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

@RunWith(Parameterized.class)
public class SampleTennisGameHardTest extends SampleBaseTennisTest {
  
  @Parameters(name = " {0}-{1} is {2} ")
  public static Collection<Object[]> getAllScores() {
    return SampleTestData.getTestCases();
  }

  public SampleTennisGameHardTest(int player1Score, int player2Score, String expectedScore) {
    super(player1Score, player2Score, expectedScore, SampleTennisGameHard::new);
  }
  
}