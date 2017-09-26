package sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleFizzBuzzTest {

    @Test
    public void testOneEqualsStringOne(){
        assertEquals("1", SampleFizzBuzz.convert(1));
    }

    @Test
    public void testTwoEqualsStringTwo(){
        assertEquals("2", SampleFizzBuzz.convert(2));
    }

    @Test
    public void testThreeEqualsFizz(){
        assertEquals("Fizz", SampleFizzBuzz.convert(3));
    }

    @Test
    public void testFourEqualsStringFour(){
        assertEquals("4", SampleFizzBuzz.convert(4));
    }

    @Test
    public void testFiveEqualsBuzz(){
        assertEquals("Buzz", SampleFizzBuzz.convert(5));
    }

    @Test
    public void testSixEqualsBuzz(){
        assertEquals("Fizz", SampleFizzBuzz.convert(6));
    }

    @Test
    public void testSevenEqualsStringSeven(){
        assertEquals("7", SampleFizzBuzz.convert(7));
    }

    @Test
    public void testEightEqualsStringEight(){
        assertEquals("8", SampleFizzBuzz.convert(8));
    }

    @Test
    public void testNineEqualsFizz(){
        assertEquals("Fizz", SampleFizzBuzz.convert(9));
    }

    @Test
    public void testTenEqualsBuzz(){
        assertEquals("Buzz", SampleFizzBuzz.convert(10));
    }

    @Test
    public void testElevenEqualsStringEleven(){
        assertEquals("11", SampleFizzBuzz.convert(11));
    }

    @Test
    public void testTwelveEqualsFizz(){
        assertEquals("Fizz", SampleFizzBuzz.convert(12));
    }

    @Test
    public void testThirteenEqualsStringThirteen(){
        assertEquals("13", SampleFizzBuzz.convert(13));
    }

    @Test
    public void testFourteenEqualsStringFourteen(){
        assertEquals("14", SampleFizzBuzz.convert(14));
    }

    @Test
    public void testFifteenEqualsSampleFizzBuzz(){
        assertEquals("FizzBuzz", SampleFizzBuzz.convert(15));
    }

    @Test
    public void testSixteenEqualsStringSixteen(){
        assertEquals("16", SampleFizzBuzz.convert(16));
    }
}
