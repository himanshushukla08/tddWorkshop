package sample;

import org.junit.Before;
import org.junit.Test;
import sample.RomanNumerals;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {
    private RomanNumerals romanNumerals;

    @Before
    public void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @Test
    public void testOneEqualsI() {
        assertEquals("I", romanNumerals.convert(1));
    }

    @Test
    public void testTwoEqualsIi() {
        assertEquals("II", romanNumerals.convert(2));
    }

    @Test
    public void testThreeEqualsIii() {
        assertEquals("III", romanNumerals.convert(3));
    }

    @Test
    public void testFourEqualsIv() {
        assertEquals("IV", romanNumerals.convert(4));
    }

    @Test
    public void testFiveEqualsV() {
        assertEquals("V", romanNumerals.convert(5));
    }

    @Test
    public void testSixEqualsVi() {
        assertEquals("VI", romanNumerals.convert(6));
    }

    @Test
    public void testSevenEqualsVii() {
        assertEquals("VII", romanNumerals.convert(7));
    }

    @Test
    public void testEightEqualsViii() {
        assertEquals("VIII", romanNumerals.convert(8));
    }

    @Test
    public void testNineEqualsIx() {
        assertEquals("IX", romanNumerals.convert(9));
    }

    @Test
    public void testTenEqualsX() {
        assertEquals("X", romanNumerals.convert(10));
    }

    @Test
    public void testElevenEqualsXi() {
        assertEquals("XI", romanNumerals.convert(11));
    }

    @Test
    public void testTwelveEqualsXii() {
        assertEquals("XII", romanNumerals.convert(12));
    }

    @Test
    public void testThirteenEqualsXiii() {
        assertEquals("XIII", romanNumerals.convert(13));
    }

    @Test
    public void testFourteenEqualsXiv() {
        assertEquals("XIV", romanNumerals.convert(14));
    }

    @Test
    public void testFifteenEqualsXv() {
        assertEquals("XV", romanNumerals.convert(15));
    }

    @Test
    public void testNineteenEqualsXix() {
        assertEquals("XIX", romanNumerals.convert(19));
    }

    @Test
    public void testThrityEightEqualsXxxvii() {
        assertEquals("XXXVIII", romanNumerals.convert(38));
    }

    @Test
    public void testThrityNineEqualsXxxix() {
        assertEquals("XXXIX", romanNumerals.convert(39));
    }

    @Test
    public void testFiftyEqualsL() {
        assertEquals("L", romanNumerals.convert(50));
    }

    @Test
    public void testFiftyFourEqualsLiv() {
        assertEquals("LIV", romanNumerals.convert(54));
    }

    @Test
    public void testSixtyNineEqualsLxix() {
        assertEquals("LXIX", romanNumerals.convert(69));
    }

    @Test
    public void testSeventyFourEqualsLxxiv() {
        assertEquals("LXXIV", romanNumerals.convert(74));
    }

    @Test
    public void testSeventyEightEqualsLxxviii() {
        assertEquals("LXXVIII", romanNumerals.convert(78));
    }

    @Test
    public void testNinetyEqualsXc() {
        assertEquals("XC", romanNumerals.convert(90));
    }

    @Test
    public void testNinetyNineEqualsXcix() {
        assertEquals("XCIX", romanNumerals.convert(99));
    }

    @Test
    public void testOneHundredEqualsC() {
        assertEquals("C", romanNumerals.convert(100));
    }

    @Test
    public void testFourHundredFourtyFourEqualsCdxliv() {
        assertEquals("CDXLIV", romanNumerals.convert(444));
    }

    @Test
    public void testFiveHundredEqualsCdxliv() {
        assertEquals("D", romanNumerals.convert(500));
    }

    @Test
    public void testSixHundredSixtySevenEqualsDclixvii() {
        assertEquals("DCLXVII", romanNumerals.convert(667));
    }

    @Test
    public void testNineHundredEqualsCm() {
        assertEquals("CM", romanNumerals.convert(900));
    }

    @Test
    public void testNineHundredFourtyFourEqualsCmxliv() {
        assertEquals("CMXLIV", romanNumerals.convert(944));
    }

    @Test
    public void testOneThousandEqualsM() {
        assertEquals("M", romanNumerals.convert(1000));
    }

    @Test
    public void testOneThousandFourHundredFourtyFourEqualsMcdxliv() {
        assertEquals("MCDXLIV", romanNumerals.convert(1444));
    }

    @Test
    public void testThreeThousandNineHundredNinetyNineEqualsMmmcmxcix() {
        assertEquals("MMMCMXCIX", romanNumerals.convert(3999));
    }
}
