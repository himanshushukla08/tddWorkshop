package sample;

import org.junit.Test;
import sample.stub.RandomWrapperStub;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SampleSomeClassTest {

    @Test
    public void shouldFailSometimesAndPassSometimesWhichIsAbsolutelyUseless() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(false, false, false).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Tofu", someClass.someMethod());
    }
}
