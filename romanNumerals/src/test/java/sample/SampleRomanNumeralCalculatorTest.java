package sample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleRomanNumeralCalculatorTest {

  private SampleRomanNumeralCalculator calculator;

  @Before
  public void setUp(){
    calculator = new SampleRomanNumeralCalculator();
  }

  @Test
  public void onePlusOneIsTwo() {
    assertEquals("II", calculator.add("I", "I"));
  }

  @Test
  public void onePlusTwoIsThree() {
    assertEquals("III", calculator.add("I", "II"));
  }

  @Test
  public void twoPlusOneIsThree() {
    assertEquals("III", calculator.add("II", "I"));
  }

  @Test
  public void twoPlusTwoIsFour() {
    assertEquals("IV", calculator.add("II", "II"));
  }

  @Test
  public void twoPlusThreeIsFive() {
    assertEquals("V", calculator.add("II", "III"));
  }

  @Test
  public void fourPlusOneIsFive() {
    assertEquals("V", calculator.add("IV", "I"));
  }

  @Test
  public void sixPlusOneIsSeven() {
    assertEquals("VII", calculator.add("VI", "I"));
  }

  @Test
  public void fourPlusFiveIsNine() {
    assertEquals("IX", calculator.add("IV", "V"));
  }
}
