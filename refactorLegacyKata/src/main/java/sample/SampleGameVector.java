package sample;

import java.awt.geom.Point2D;

public class SampleGameVector {

    public static final double HALF_PI = Math.PI / 2;
    public static final double DOUBLE_PI = Math.PI * 2;
    final double slope;
    final double distance;
    final VectorDirection direction;

    public SampleGameVector(final double slope, final double distance, final VectorDirection direction) {
        this.slope = Double.isNaN(slope) ? 0 : slope;
        this.distance = distance;
        this.direction = direction;
    }

    public static SampleGameVector create(final double angle, final double distance) {
        if (shouldReverse(angle)) {
            return new SampleGameVector(Math.tan(angle), distance, VectorDirection.LEFT);
        } else {
            return new SampleGameVector(Math.tan(angle), distance, VectorDirection.RIGHT);
        }
    }

    public static double getAngle(final double slope, final VectorDirection direction) {
        final double arctanAngle = Math.atan(slope);
        if (direction.equals(VectorDirection.LEFT)) {
            return arctanAngle + Math.PI;
        } else if (arctanAngle < 0) {
            return arctanAngle + DOUBLE_PI;
        } else {
            return arctanAngle;
        }
    }

    private static boolean shouldReverse(double angle) {
        angle = angle % DOUBLE_PI;
        return (angle > HALF_PI && angle <= 3 * HALF_PI)
                || (angle < -HALF_PI && angle >= -(3 * HALF_PI));
    }

    public SampleGameVector add(final SampleGameVector additionalVector) {
        double angleOne = lookupAngle(direction, slope);
        double angleTwo = lookupAngle(additionalVector.direction, additionalVector.slope);

        final double finalX = buildPointTwoD(angleOne).getX() + additionalVector.buildPointTwoD(angleTwo).getX();
        final double finalY = buildPointTwoD(angleOne).getY() + additionalVector.buildPointTwoD(angleTwo).getY();
        return new SampleGameVector(finalY / finalX, Math.sqrt(finalX * finalX + finalY * finalY), finalX < 0 ?
                VectorDirection.LEFT : VectorDirection.RIGHT);
    }

    public double getAngle() {
        return getAngle(this.slope, this.direction);
    }

    private double lookupAngle(VectorDirection direction, double slope) {
        double angleOne;
        if (direction.equals(VectorDirection.LEFT)) {
            angleOne = Math.atan(slope) + Math.PI;
        } else if (Math.atan(slope) < 0) {
            angleOne = Math.atan(slope) + DOUBLE_PI;
        } else {
            angleOne = Math.atan(slope);
        }
        return angleOne;
    }

    private Point2D.Double buildPointTwoD(double angle) {
        return new Point2D.Double(Math.cos(angle) * distance, Math.sin(angle) * distance);
    }

    public enum VectorDirection {RIGHT, LEFT;}
}
