class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getWidth() {
        return getMax(x1, x2, x3) - getMin(x1, x2, x3);
    }

    public double getHeight() {
        return getMax(y1, y2, y3) - getMin(y1, y2, y3);
    }

    public double getArea() {
        return (getWidth() * getHeight()) / 2;
    }

    public double getPerimeter() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) + Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)) + Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
    }

    private double getMax(double coordinate1, double coordinate2, double coordinate3) {
        double max;

        if (coordinate1 >= coordinate2) {
            max = coordinate1;
        } else {
            max = coordinate2;
        }

        if (max <= coordinate3) {
            max = coordinate3;
        }
        return max;
    }

    private double getMin(double coordinate1, double coordinate2, double coordinate3) {
        double min;

        if (coordinate1 <= coordinate2) {
            min = coordinate1;
        } else {
            min = coordinate2;
        }

        if (min >= coordinate3) {
            min = coordinate3;
        }
        return min;
    }

    @Override
    public String toString() {
        return String.format("Ширина: %.2f.%nВысота: %.2f.%nПлощадь: %.2f.%nПериметр: %.2f.%nХэш: %d.", getWidth(), getHeight(), getArea(), getPerimeter(), hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) object;

        return getWidth() == triangle.getWidth() && getHeight() == triangle.getHeight() && getArea() == triangle.getArea() && getPerimeter() == triangle.getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}