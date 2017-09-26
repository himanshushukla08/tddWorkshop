package sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

    @Test
    public void testToString(){
        assertEquals("test", new Builder(1, "test").toString());
    }

    @Test
    public void testAppend(){
        Builder builder = new Builder(1, "test");
        builder.append("1");
        assertEquals("test1", builder.toString());
    }
}