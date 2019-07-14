class Range {
    private double from;
    private double to;

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    private Range() {

    }

    double getFrom() {
        return this.from;
    }

    double getTo() {
        return this.to;
    }

    private void setFrom(double from) {
        this.from = from;
    }

    private void setTo(double to) {
        this.to = to;
    }

    double getLength() {
        return this.to - this.from;
    }

/*    private boolean isInside(double number) {
        double epsilon = 1.0e-10;
        return (this.to - number >= -epsilon) && (number - this.from >= -epsilon);
    } */

    Range getIntersectionRange(Range rangeB) {
        Range rangeC = new Range();

        if (this.from <= rangeB.getTo() && this.to >= rangeB.getFrom()) {
            if (this.from >= rangeB.getFrom()) {
                rangeC.setFrom(this.from);
            } else {
                rangeC.setFrom(rangeB.getFrom());
            }

            if (this.to >= rangeB.getTo()) {
                rangeC.setTo(rangeB.getTo());
            } else {
                rangeC.setTo(this.to);
            }
        } else {
            rangeC = null;
        }
        return rangeC;
    }

    Range[] getCombinedRange(Range rangeB) {
        Range rangeC = new Range();

        if (this.from <= rangeB.getTo() && this.to >= rangeB.getFrom()) {
            if (this.from >= rangeB.getFrom()) {
                rangeC.setFrom(rangeB.getFrom());
            } else {
                rangeC.setFrom(this.from);
            }

            if (this.to >= rangeB.getTo()) {
                rangeC.setTo(this.to);
            } else {
                rangeC.setTo(rangeB.getTo());
            }
            return new Range[]{rangeC};
        }
        return new Range[]{new Range(this.from, this.to), rangeB};
    }
}