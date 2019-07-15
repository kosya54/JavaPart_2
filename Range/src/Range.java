class Range {
    private double from;
    private double to;

    Range(double from, double to) {
        this.from = from;
        this.to = to;
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

    boolean isInside(double number) {
        double epsilon = 1.0e-10;
        return (this.to - number >= -epsilon) && (number - this.from >= -epsilon);
    }
    
    Range getIntersection(Range range) {
        if (this.from >= range.getTo() || range.getFrom() >= this.to) {
            return null;
        }
        
        if (this.from <= range.getFrom() && this.to >= range.getTo()) {
            return new Range(range.getFrom(), range.getTo());
        }
        
        if (this.from >= range.getFrom() && this.to <= range.getTo()) {
            return new Range(this.from, this.to);
        }
        
        if (this.from >= range.getFrom() && this.to >= range.getTo()) {
            return new Range(this.from, range.getTo());
        }
        return new Range(range.getFrom(), this.to);
    }
    
    Range[] getUnion(Range range) {
        if (this.from > range.getTo() || range.getFrom() > this.to) {
            return new Range[] { new Range(this.from, this.to), new Range(range.getFrom(), range.getTo()) };
        }
        
        if (this.from <= range.getFrom() && this.to >= range.getTo()) {
            return new Range[] { new Range(this.from, this.to) };
        }
        
        if (this.from >= range.getFrom() && this.to <= range.getTo() ) {
            return new Range[] { new Range(range.getFrom(), range.getTo()) };
        }
        
        if (this.from >= range.getFrom() && this.to >= range.getTo()) {
            return new Range[] { new Range(range.getFrom(), this.to) };
        }
        
        return new Range[] { new Range(this.from, range.getTo()) };
    }
    
    Range[] getDifference(Range range) {
        if (this.from > range.getTo() || range.getFrom() > this.to) {
            return new Range[] { new Range(this.from, this.to) };
        }
        
        if (this.from < range.getFrom() && this.to > range.getTo()) {
            return new Range[] { new Range(this.from, range.getFrom()), new Range(range.getTo(), this.to) };
        }
        
        if (this.from < range.getFrom() && this.to <= range.getTo()) {
            return new Range[] { new Range(this.from, range.getFrom()) };
        }
        
        if (this.from >= range.getFrom() && this.to <= range.getTo()) {
            return new Range[] { };
        }
        return new Range[] { new Range(range.getTo(), this.to) };
    }
}
