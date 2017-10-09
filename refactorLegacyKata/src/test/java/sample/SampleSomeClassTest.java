package sample;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore("Remove this line when you're ready to run the tests")
public class SampleSomeClassTest {

    @Test
    public void shouldFailSometimesAndPassSometimesWhichIsAbsolutelyUseless() {
        SampleSomeClass someClass = new SampleSomeClass();
        assertEquals("Tofu", someClass.someMethod());
    }
}
