package sample;

import org.junit.Test;
import sample.stub.RandomWrapperStub;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SampleSomeClassTest {

    @Test
    public void allFalseReturnsTofu() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(false, false, false, false).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Tofu", someClass.someMethod());
    }

    @Test
    public void allTrueReturnsBacon() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(true, true, true, true).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Bacon", someClass.someMethod());
    }
}
