package sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleRomanNumeralCalculatorTest {

  @Test
  public void onePlusOneIsTwo() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("II", calculator.add("I", "I"));
  }

  @Test
  public void onePlusTwoIsThree() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("III", calculator.add("I", "II"));
  }

  @Test
  public void TwoPlusOneIsThree() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("III", calculator.add("II", "I"));
  }

  @Test
  public void TwoPlusTwoIsFour() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("IV", calculator.add("II", "II"));
  }

  @Test
  public void TwoPlusThreeIsFive() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("V", calculator.add("II", "III"));
  }
}
