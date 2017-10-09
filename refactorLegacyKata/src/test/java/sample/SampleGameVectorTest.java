package sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SampleGameVectorTest {

    private static final double SIG_DIGITS = 0.000000000000001;
    private static final double PI = Math.PI;

    @Test
    public void add_Leftly() throws Exception {
        final SampleGameVector vector1 = new SampleGameVector(0, 10, SampleGameVector.VectorDirection.LEFT);
        final SampleGameVector vector2 = new SampleGameVector(0, 15, SampleGameVector.VectorDirection.LEFT);
        final SampleGameVector result = vector1.add(vector2);
        assertEquals(0, result.slope, SIG_DIGITS);
        assertEquals(25, result.distance, 0);
        assertEquals(SampleGameVector.VectorDirection.LEFT, result.direction);
    }

    @Test
    public void add_Rightly() throws Exception {
        final SampleGameVector vector1 = new SampleGameVector(15, 42, SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector vector2 = new SampleGameVector(15, 21, SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector result = vector1.add(vector2);
        assertEquals(15, result.slope, SIG_DIGITS * 10);
        assertEquals(63, result.distance, 0);
        assertEquals(SampleGameVector.VectorDirection.RIGHT, result.direction);
    }

    @Test
    public void add_Angles_KnownRightTriangle() throws Exception {
        final SampleGameVector vector1 = new SampleGameVector(0, 3, SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector vector2 = new SampleGameVector(Double.POSITIVE_INFINITY, 4,
                SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector result = vector1.add(vector2);
        assertEquals(5, result.distance, 0);
        assertEquals(SampleGameVector.VectorDirection.RIGHT, result.direction);
    }

    @Test
    public void add_Angles_Known45degreeAngle() throws Exception {
        final SampleGameVector vector1 = new SampleGameVector(0, 10, SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector vector2 = new SampleGameVector(Double.POSITIVE_INFINITY, 10,
                SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector result = vector1.add(vector2);
        assertEquals(1.0, result.slope, 0);
        assertEquals(SampleGameVector.VectorDirection.RIGHT, result.direction);
    }

    @Test
    public void oppositeVectorsWillCancelOutToZero() throws Exception {
        final SampleGameVector vector1 = new SampleGameVector(10, 70, SampleGameVector.VectorDirection.LEFT);
        final SampleGameVector vector2 = new SampleGameVector(10, 70, SampleGameVector.VectorDirection.RIGHT);
        final SampleGameVector result = vector1.add(vector2);
        assertEquals(0, result.slope, 0);
        assertEquals(0, result.distance, 0.00000000000001);
    }

    @Test
    public void testAddWillNotReverseDirectionInStrangeSituation_BeCarefulWithCasting()
            throws Exception {
        final SampleGameVector gameVector = new SampleGameVector(-2.0334448160535117, 1,
                SampleGameVector.VectorDirection.LEFT);

        final SampleGameVector result = gameVector.add(gameVector);
        assertEquals(gameVector.slope, result.slope, SIG_DIGITS);
        assertEquals(SampleGameVector.VectorDirection.LEFT, result.direction);
        assertEquals(2, result.distance, 0);
    }

    @Test
    public void testAngleInRadians() throws Exception {
        assertEquals(0, new SampleGameVector(0, 1, SampleGameVector.VectorDirection.RIGHT).getAngle(),
                0);
        assertEquals(Math.PI / 4,
                new SampleGameVector(1, 1, SampleGameVector.VectorDirection.RIGHT).getAngle(), 0);
        assertEquals(Math.PI / 2, new SampleGameVector(Double.POSITIVE_INFINITY, 1,
                SampleGameVector.VectorDirection.RIGHT).getAngle(), 0);
        assertEquals(3 * Math.PI / 2, new SampleGameVector(Double.POSITIVE_INFINITY,
                1, SampleGameVector.VectorDirection.LEFT).getAngle(), 0);
        assertEquals(3 * Math.PI / 2, new SampleGameVector(Double.POSITIVE_INFINITY,
                -1, SampleGameVector.VectorDirection.LEFT).getAngle(), 0);
    }

    @Test
    public void testCreateWithAngle() throws Exception {
        checkCreateWithAngle(0, 10);
        checkCreateWithAngle(PI / 4, 6);
        checkCreateWithAngle(PI / 2, 8);
        checkCreateWithAngle(3 * PI / 4, 8);
        checkCreateWithAngle(PI, 1);
        checkCreateWithAngle(5 * PI / 4, 9);
        checkCreateWithAngle(3 * PI / 2, 11);
        checkCreateWithAngle(7 * PI / 4, 99);
    }

    @Test
    public void testCreateWithAngleTooLarge() throws Exception {
        final int distance = 99;
        final SampleGameVector gameVector = SampleGameVector.create(8.768435912084136,
                distance);
        assertEquals(8.768435912084136 - PI * 2, gameVector.getAngle(),
                SIG_DIGITS);
        assertEquals(distance, gameVector.distance, 0);
    }

    @Test
    public void testCreateWithNegativeAngle() throws Exception {
        final int distance = 6;
        final SampleGameVector gameVector = SampleGameVector.create(-PI / 4, distance);
        assertEquals(7 * PI / 4, gameVector.getAngle(), 0);
        assertEquals(distance, gameVector.distance, 0);
    }

    private void checkCreateWithAngle(final double angle, final double distance) {
        final SampleGameVector gameVector = SampleGameVector.create(angle, distance);
        assertEquals(angle, gameVector.getAngle(), 0);
        assertEquals(distance, gameVector.distance, 0);
    }

}