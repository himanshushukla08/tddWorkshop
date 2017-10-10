package sample;

import org.junit.Test;
import sample.stub.RandomWrapperStub;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SampleSomeClassTest {

    @Test
    public void trueTrueTrueTrueReturnsBacon() {
        assertRandom("Bacon", true, true, true, true);
    }

    @Test
    public void trueTrueTrueFalseReturnsBacon() {
        assertRandom("Bacon", true, true, true, false);
    }

    @Test
    public void trueTrueFalseTrueReturnsBacon() {
        assertRandom("Bacon", true, true, false, true);
    }

    @Test
    public void trueTrueFalseFalseReturnsBacon() {
        assertRandom("Bacon", true, true, false, false);
    }

    @Test
    public void falseFalseTrueTrueReturnsBacon() {
        assertRandom("Bacon", false, false, true, true);
    }

    @Test
    public void trueFalseTrueTrueReturnsTofu() {
        assertRandom("Tofu", true, false, true, true);
    }

    @Test
    public void trueFalseTrueFalseReturnsTofu() {
        assertRandom("Tofu", true, false, true, false);
    }

    @Test
    public void trueFalseFalseTrueReturnsTofu() {
        assertRandom("Tofu", true, false, false, true);
    }

    @Test
    public void trueFalseFalseFalseReturnsTofu() {
        assertRandom("Tofu", true, false, false, false);
    }

    @Test
    public void falseTrueTrueTrueReturnsTofu() {
        assertRandom("Tofu", false, true, true, true);
    }

    @Test
    public void falseTrueTrueFalseReturnsTofu() {
        assertRandom("Tofu", false, true, true, false);
    }

    @Test
    public void falseTrueFalseTrueReturnsTofu() {
        assertRandom("Tofu", false, true, false, true);
    }

    @Test
    public void falseTrueFalseFalseReturnsTofu() {
        assertRandom("Tofu", false, true, false, false);
    }

    @Test
    public void falseFalseTrueFalseReturnsTofu() {
        assertRandom("Tofu", false, false, true, false);
    }

    @Test
    public void falseFalseFalseTrueReturnsTofu() {
        assertRandom("Tofu", false, false, false, true);
    }

    @Test
    public void falseFalseFalseFalseReturnsTofu() {
        assertRandom("Tofu", false, false, false, false);
    }


    private void assertRandom(String expectedValue, boolean first, boolean second, boolean third, boolean fourth) {
        assertEquals(expectedValue, buildFor(first, second, third, fourth).someMethod());
    }

    private SampleSomeClass buildFor(boolean first, boolean second, boolean third, boolean fourth) {
        RandomWrapper randomWrapperStub = new RandomWrapperStub(Arrays.asList(first, second, third, fourth).iterator());
        return new SampleSomeClass(randomWrapperStub);
    }
}
