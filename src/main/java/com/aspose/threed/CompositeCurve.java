package com.aspose.threed;

import java.util.ArrayList;

/**
 * A CompositeCurve is consisting of several curve segments.
 */
public class CompositeCurve extends Curve {
    private final ArrayList<Segment> segments = new ArrayList<>();

    /**
     * The segments of the curve.
     */
    public ArrayList<Segment> getSegments() {
        return segments;
    }

    /**
     * Constructor of CompositeCurve.
     */
    public CompositeCurve() {
        super();
    }

    /**
     * Add a new segment to current curve.
     * @param curve The curve to add
     * @param sameDirection Same direction with current curve.
     */
    public void addSegment(Curve curve, boolean sameDirection) {
        segments.add(new Segment(curve, sameDirection));
    }

    /**
     * Add a new segment to current curve.
     * @param curve The curve to add
     */
    public void addSegment(Curve curve) {
        addSegment(curve, true);
    }

    /**
     * Segment of CompositeCurve.
     */
    public static class Segment {
        private Curve curve;
        private boolean sameDirection;

        /**
         * Constructor.
         * @param curve The curve
         * @param sameDirection Same direction flag
         */
        public Segment(Curve curve, boolean sameDirection) {
            this.curve = curve;
            this.sameDirection = sameDirection;
        }

        /**
         * Gets the curve.
         */
        public Curve getCurve() {
            return curve;
        }

        /**
         * Gets whether the segment has the same direction with the composite curve.
         */
        public boolean getSameDirection() {
            return sameDirection;
        }
    }
}
