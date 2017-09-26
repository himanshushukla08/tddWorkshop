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
  public void twoPlusOneIsThree() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("III", calculator.add("II", "I"));
  }

  @Test
  public void twoPlusTwoIsFour() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("IV", calculator.add("II", "II"));
  }

  @Test
  public void twoPlusThreeIsFive() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("V", calculator.add("II", "III"));
  }

  @Test
  public void fourPlusOneIsFive() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("V", calculator.add("IV", "I"));
  }

  @Test
  public void sixPlusOneIsSeven() {
    SampleRomanNumeralCalculator calculator = new SampleRomanNumeralCalculator();

    assertEquals("VII", calculator.add("VI", "I"));
  }
}
