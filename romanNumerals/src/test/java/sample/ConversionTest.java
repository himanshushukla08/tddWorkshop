package sample;


import org.junit.Test;
import sample.Conversion;

import static org.junit.Assert.assertEquals;

public class ConversionTest {

    @Test
    public void testConstructionWithRange(){
        Conversion conversion = new Conversion(1, "test", 2);
        assertEquals(1, conversion.getNumber());
        assertEquals("test", conversion.getRomanNumeral());
        assertEquals(2, conversion.getRange());
    }

    @Test
    public void testConstructionWithoutRange(){
        Conversion conversion = new Conversion(1, "test");
        assertEquals(1, conversion.getNumber());
        assertEquals("test", conversion.getRomanNumeral());
        assertEquals(1, conversion.getRange());
    }
}