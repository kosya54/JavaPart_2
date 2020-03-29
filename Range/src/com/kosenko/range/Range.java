package com.kosenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        double epsilon = 1.0e-10;
        return (to - number >= -epsilon) && (number - from >= -epsilon);
    }

    public Range getIntersection(Range range) {
        if (from >= range.to || range.from >= to) {
            return null;
        }

        if (from <= range.from && to >= range.to) {
            return new Range(range.from, range.to);
        }

        if (from >= range.from && to <= range.to) {
            return new Range(from, to);
        }

        if (from >= range.from && to >= range.to) {
            return new Range(from, range.to);
        }
        return new Range(range.from, to);
    }

    public Range[] getUnion(Range range) {
        if (from > range.to || range.from > to) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (from <= range.from && to >= range.to) {
            return new Range[]{new Range(from, to)};
        }

        if (from >= range.from && to <= range.to) {
            return new Range[]{new Range(range.from, range.to)};
        }

        if (from >= range.from && to >= range.to) {
            return new Range[]{new Range(range.from, to)};
        }

        return new Range[]{new Range(from, range.to)};
    }

    public Range[] getDifference(Range range) {
        if (from > range.to || range.from > to) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from < range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }
        return new Range[]{new Range(range.to, to)};
    }
}
