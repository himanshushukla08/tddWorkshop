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

    @Test
    public void falseTrueTrueTrueReturnsTofu() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(false, true, true, true).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Tofu", someClass.someMethod());
    }

    @Test
    public void trueFalseTrueTrueReturnsTofu() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(true, false, true, true).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Tofu", someClass.someMethod());
    }

    @Test
    public void falseFalseTrueTrueReturnsBacon() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(false, false, true, true).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Bacon", someClass.someMethod());
    }

    @Test
    public void falseFalseFalseTrueReturnsTofu() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(false, false, false, true).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Tofu", someClass.someMethod());
    }

    @Test
    public void trueTrueFalseTrueReturnsBacon() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(true, true, false, true).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Bacon", someClass.someMethod());
    }

    @Test
    public void trueTrueTrueFalseReturnsBacon() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(true, true, true, false).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Bacon", someClass.someMethod());
    }

    @Test
    public void trueTrueFalseFalseReturnsBacon() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(true, true, false, false).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Bacon", someClass.someMethod());
    }

    @Test
    public void trueFalseFalseFalseReturnsBacon() {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(true, true, false, false).iterator());
        SampleSomeClass someClass = new SampleSomeClass(randomWrapperStub);
        assertEquals("Bacon", someClass.someMethod());
    }
}
