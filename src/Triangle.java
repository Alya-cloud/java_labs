class Triangle extends Figure {
    double a, b, c;

    public Triangle(double a, double b, double c, String name) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return super.toString() + "a = " + a + ", b = " + b + ", c = " + c;
    }

    public double P() {
        return a + b + c;
    }

    public static double P(double a, double b, double c) {
        return a + b + c;
    }

    public static double P(Triangle t) {
        return t.P();
    }

    public double S() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double S(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double S(Triangle t) {
        return t.S();
    }
}