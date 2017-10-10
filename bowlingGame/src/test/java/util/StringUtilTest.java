package util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    public static final String NON_NUMERIC = " ";
    public static final String NUMBER = "1";
    public static final String BIGGER_THAN_AN_INT = "9999999999999999999999999999999999999999999999999999999999";
    public static final String SYMBOLS = "@";

    @Test
    public void nonNumericValueReturnsFalse() {
        assertFalse(StringUtil.isNumeric(NON_NUMERIC));

    }

    @Test
    public void symbolsReturnsFalse() {
        assertFalse(StringUtil.isNumeric(SYMBOLS));

    }

    @Test
    public void nullValueReturnsFalse() {
        assertFalse(StringUtil.isNumeric(null));

    }

    @Test
    public void numericValueReturnsTrue() {
        assertTrue(StringUtil.isNumeric(NUMBER));

    }

    @Test
    public void numericValueReturnsAnException() {
        assertTrue(StringUtil.isNumeric(BIGGER_THAN_AN_INT));

    }

}